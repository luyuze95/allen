package com.luyuze.allen.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class Address {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String address;

    private Long userId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    @TableField(select = false)
    @JsonIgnore
    private Integer isDelete;
}
