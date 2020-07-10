package com.luyuze.allen.mapper;

import com.luyuze.allen.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressMapperTest {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void test01() {
        Address address = new Address();
        address.setAddress("ccc");
        address.setUserId(3L);
        addressMapper.insert(address);
    }

}