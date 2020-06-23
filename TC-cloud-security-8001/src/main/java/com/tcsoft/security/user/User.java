package com.tcsoft.security.user;

import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * 数据库的映射对象
 */
@Data
public class User {
    private String id;
    private String name;
    private String password;
    private String phone;
    private Date lastPasswordResetDate;
    private List<String> roles;
//    private List<String> roles;
}
