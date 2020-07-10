package com.luyuze.allen.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserWithAddressVO {

    private Long id;

    private String username;

    private String phone;

    private Date createTime;

    private Date updateTime;

    private List<AddressVO> addressList;
}
