package com.tcsoft.security.dao;

import lombok.Data;

import java.util.Date;


/**
 * 数据库的映射对象
 * @author big_john
 */
@Data
public class UserDao {
    private Integer userId;
    private Integer groupId;
    private String username;
    private String password;
    private Integer authorityId;
    private Date lastPasswordResetDate;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
