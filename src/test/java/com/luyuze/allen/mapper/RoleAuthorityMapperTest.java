package com.luyuze.allen.mapper;

import com.luyuze.allen.entity.RoleAuthority;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleAuthorityMapperTest {

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    /**
     * 给角色分配权限测试
     */
    @Test
    void createRoleAuthorityTest() {
        RoleAuthority roleAuthority = new RoleAuthority();
        roleAuthority.setAuthorityId(6L);
        roleAuthority.setRoleId(3L);
        roleAuthorityMapper.insert(roleAuthority);
    }
}