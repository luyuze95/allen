package com.luyuze.allen.service.impl;

import com.luyuze.allen.entity.User;
import com.luyuze.allen.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    /**
     * 根据userId获取角色列表
     */
    @Test
    void getRolesByUserIdTest() {
        List<String> roles = userService.getRoles(3L);
        System.out.println(roles);
    }

    /**
     * 根据userId获取权限列表
     */
    @Test
    void getAuthoritiesByUserIdTest() {
        List<String> authorities = userService.getAuthorities(3L);
        System.out.println(authorities);
    }

    /**
     * 根据username查询一个user测试
     */
    @Test
    void selectOneUserTest() {
        User user = userService.getUser("zhangsa");
        System.out.println(user);
    }
}