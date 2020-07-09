package com.luyuze.allen.mapper;

import com.luyuze.allen.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void createRoleTest() {
        Role role = new Role();
        role.setRole("super");
        roleMapper.insert(role);
    }
}