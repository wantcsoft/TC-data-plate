package com.tcsoft.security.entity;


import lombok.Data;

/**
 * 修改用户信息时需要用的bean
 * @author big_john
 */
@Data
public class ModifyUserBean {

    private Integer userId;
    private String groupDescription;
    private String roleDescription;
    private String username;
    private String password;
    private boolean accountNonLocked;
    private boolean enabled;

}
