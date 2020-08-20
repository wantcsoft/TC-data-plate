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

    @TableField(value = "userId")
    @TableId(type = IdType.AUTO)
    private Integer userId;

    @TableField(value = "groupId")
    private Integer groupId;

    @TableField(value = "roleId")
    private Integer roleId;

    @TableField(value = "userName")
    private String username;

    @TableField(value = "password")
    private String password;

    @TableField(value = "lastPasswordResetDate")
    private Date lastPasswordResetDate;

    @TableField(value = "accountNonLocked")
    private boolean accountNonLocked;

    @TableField(value = "accountNonExpired")
    private boolean accountNonExpired;

    @TableField(value = "credentialsNonExpired")
    private boolean credentialsNonExpired;

    @TableField(value = "enabled")
    private boolean enabled;

}
