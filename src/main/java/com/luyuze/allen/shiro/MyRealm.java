package com.luyuze.allen.shiro;

import com.luyuze.allen.entity.User;
import com.luyuze.allen.exception.http.UnauthorizedException;
import com.luyuze.allen.service.UserService;
import com.luyuze.allen.utils.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 必须重写此方法，不然shiro会报错
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限时才会调用此方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = JWTUtil.getUsername(principalCollection.toString());
        User user = userService.getUser(username);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(userService.getRoles(user.getId()));
        List<String> authorities = userService.getAuthorities(user.getId());
        authorizationInfo.addStringPermissions(authorities);
        return authorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库对比
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token is invalid");
        }
        User user = userService.getUser(username);
        if (user == null) {
            throw new AuthenticationException("user is not existed");
        }
        if (!JWTUtil.verify(token, username, user.getPassword())) {
           throw new AuthenticationException("username or password error");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
