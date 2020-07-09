package com.luyuze.allen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luyuze.allen.entity.Authority;
import com.luyuze.allen.entity.Role;
import com.luyuze.allen.entity.RoleAuthority;
import com.luyuze.allen.entity.UserRole;
import com.luyuze.allen.mapper.AuthorityMapper;
import com.luyuze.allen.mapper.RoleAuthorityMapper;
import com.luyuze.allen.mapper.RoleMapper;
import com.luyuze.allen.mapper.UserRoleMapper;
import com.luyuze.allen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

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
}
