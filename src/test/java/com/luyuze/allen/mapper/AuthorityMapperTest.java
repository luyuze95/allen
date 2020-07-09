package com.luyuze.allen.mapper;

import com.luyuze.allen.entity.Authority;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorityMapperTest {

    @Autowired
    private AuthorityMapper authorityMapper;

    @Test
    void createAuthorityTest() {
        Authority authority = new Authority();
        authority.setAuthority("p6");
        authorityMapper.insert(authority);
    }
}