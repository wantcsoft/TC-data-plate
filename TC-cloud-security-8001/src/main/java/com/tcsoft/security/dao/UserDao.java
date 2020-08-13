package com.tcsoft.security.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;


/**
 * 数据库的映射对象
 * @author big_john
 */
@Data
@TableName(value = "user")
public class UserDao {

    @TableField(value = "user_id")
    @TableId(type = IdType.AUTO)
    private Integer userId;

    @TableField(value = "group_id", insertStrategy = FieldStrategy.NOT_NULL)
    private Integer groupId;

    @TableField(value = "role_id", insertStrategy = FieldStrategy.NOT_NULL)
    private Integer roleId;

    @TableField(value = "user_name", insertStrategy = FieldStrategy.NOT_NULL)
    private String username;

    @TableField(value = "password", insertStrategy = FieldStrategy.NOT_NULL)
    private String password;

    @TableField(value = "last_password_reset_date", insertStrategy = FieldStrategy.NOT_NULL)
    private Date lastPasswordResetDate;

    @TableField(value = "account_non_locked")
    private boolean accountNonLocked;

    @TableField(value = "account_non_expired")
    private boolean accountNonExpired;

    @TableField(value = "credentials_non_expired")
    private boolean credentialsNonExpired;

    @TableField(value = "enabled")
    private boolean enabled;

}
