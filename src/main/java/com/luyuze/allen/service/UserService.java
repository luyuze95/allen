package com.luyuze.allen.service;

import com.luyuze.allen.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 根据userId获取用户的角色列表
     * @param userId
     * @return
     */
    List<String> getRoles(Long userId);

    /**
     * 根据userId获取用户的权限列表
     * @param userId
     * @return
     */
    List<String> getAuthorities(Long userId);

    /**
     * 根据username获取user对象
     * @param username
     * @return
     */
    User getUser(String username);
}
