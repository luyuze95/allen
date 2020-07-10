package com.luyuze.allen.api.v1;

import com.luyuze.allen.dto.UserRegisterDTO;
import com.luyuze.allen.utils.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
@Validated
public class TestController {

    @PostMapping("/list")
    public Object test(
            @RequestBody @Validated UserRegisterDTO userRegisterDTO
            ) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "hello");
        return map;
    }

    /**
     * 需要登陆即可访问
     * @return
     */
    @GetMapping("/login")
    @RequiresAuthentication
    public String needLogin() {
        return "need Login";
    }

    /**
     * 需要有common角色才可以访问
     * @return
     */
    @GetMapping("/common")
    @RequiresRoles("common")
    public String needCommon() {
        return "need role common";
    }

    /**
     * 需要有super角色才可以访问
     * @return
     */
    @GetMapping("/super")
    @RequiresRoles("super")
    public String needSuper() {
        return "need role super";
    }

    /**
     * 需要有p5权限才可以访问
     * @return
     */
    @GetMapping("/p5")
    @RequiresPermissions("p5")
    public String needP5() {
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        String username = JWTUtil.getUsername(token);
        return "need authority p5";
    }
}
