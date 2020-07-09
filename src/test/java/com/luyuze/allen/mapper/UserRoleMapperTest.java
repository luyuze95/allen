package com.luyuze.allen.mapper;

import com.luyuze.allen.entity.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRoleMapperTest {

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 给用户分配角色测试
     */
    @Test
    void createUserRoleTest() {
        UserRole userRole = new UserRole();
        userRole.setRoleId(3L);
        userRole.setUserId(1L);
        userRoleMapper.insert(userRole);
    }
}