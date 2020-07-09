package com.luyuze.allen.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
@TableName("role_authority")
public class RoleAuthority {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long roleId;

    private Long authorityId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    @TableField(select = false)
    @JsonIgnore
    private Integer isDelete;
}
