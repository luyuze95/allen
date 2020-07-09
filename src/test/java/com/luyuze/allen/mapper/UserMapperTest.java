package com.luyuze.allen.mapper;

import com.luyuze.allen.entity.User;
import com.luyuze.allen.utils.EncryptUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 创建user测试
     * @throws Exception
     */
    @Test
    void insertTest() throws Exception {
        User user = new User();
        user.setUsername("test05");
        user.setPassword(EncryptUtil.generatePasswordHash("123456"));
        user.setPhone("13211112222");
        userMapper.insert(user);
    }

    /**
     * 查看user列表测试
     */
    @Test
    void getUserListTest() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 更新user信息测试
     */
    @Test
    void updateUserTest() {
        User user = userMapper.selectById(1);
        user.setPhone("13911112222");
        userMapper.updateById(user);
    }

    /**
     * 删除user测试
     */
    @Test
    void deleteUserTest() {
        userMapper.deleteById(1);
    }
}