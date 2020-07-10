package com.luyuze.allen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luyuze.allen.entity.*;
import com.luyuze.allen.mapper.*;
import com.luyuze.allen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    /**
     * 根据userId获取用户的角色列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<String> getRoles(Long userId) {
        List<Long> roleIds = userRoleMapper.selectList(
                new QueryWrapper<UserRole>().eq("user_id", userId)
        ).stream().map(UserRole::getRoleId).collect(Collectors.toList());
        return roleMapper.selectList(
                new QueryWrapper<Role>().in("id", roleIds)
        ).stream().map(Role::getRole).collect(Collectors.toList());
    }

    /**
     * 根据userId获取用户的权限列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<String> getAuthorities(Long userId) {
        List<Long> roleIds = userRoleMapper.selectList(
                new QueryWrapper<UserRole>().eq("user_id", userId)
        ).stream().map(UserRole::getRoleId).collect(Collectors.toList());
        List<Long> authorityIds = roleAuthorityMapper.selectList(
                new QueryWrapper<RoleAuthority>().in("role_id", roleIds)
        ).stream().map(RoleAuthority::getAuthorityId).collect(Collectors.toList());
        return authorityMapper.selectList(
                new QueryWrapper<Authority>().in("id", authorityIds)
        ).stream().map(Authority::getAuthority).collect(Collectors.toList());
    }

    /**
     * 根据username获取user对象
     *
     * @param username
     * @return
     */
    @Override
    public User getUser(String username) {
        return userMapper.selectOne(
                new QueryWrapper<User>().eq("username", username)
        );
    }
}
