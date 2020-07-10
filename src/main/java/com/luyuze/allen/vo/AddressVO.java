package com.luyuze.allen.vo;

import lombok.Data;

import java.util.Date;

@Data
public class AddressVO {

    private Long id;

    private String address;

    private Long userId;

    private Date createTime;

    private Date updateTime;
}
