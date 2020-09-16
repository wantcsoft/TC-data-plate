package com.tcsoft.security.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;


/**
 * 数据库的映射对象
 * @author big_john
 */
@Data
@TableName(value = "User")
public class UserDao {

    @TableField(value = "`UserID`")
    @TableId(type = IdType.AUTO)
    private Integer userId;

    @TableField(value = "`GroupID`")
    private Integer groupId;

    @TableField(value = "`RoleID`")
    private Integer roleId;

    @TableField(value = "UserName")
    private String username;

    @TableField(value = "Password")
    private String password;

    @TableField(value = "LastPasswordResetDate")
    private Date lastPasswordResetDate;

    @TableField(value = "AccountNonLocked")
    private boolean accountNonLocked;

    @TableField(value = "AccountNonExpired")
    private boolean accountNonExpired;

    @TableField(value = "CredentialsNonExpired")
    private boolean credentialsNonExpired;

    @TableField(value = "IsEnabled")
    private boolean enabled;

}
