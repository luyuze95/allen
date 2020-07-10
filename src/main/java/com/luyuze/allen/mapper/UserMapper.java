package com.luyuze.allen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luyuze.allen.entity.User;
import com.luyuze.allen.vo.UserWithAddressVO;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<UserWithAddressVO> getUserListWithAddress();
}
