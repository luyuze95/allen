package com.luyuze.allen.service;

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
}
