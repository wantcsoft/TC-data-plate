package com.tcsoft.security.entity;

import lombok.Data;

/**
 * 用户注册时的使用的Bean
 * @author big_john
 */
@Data
public class RegisterUserBean {

    private String groupDescription;
    private String roleDescription;
    private String username;
    private String password;
    private boolean accountNonLocked;
    private boolean enabled;

}
