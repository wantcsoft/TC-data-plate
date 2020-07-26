package com.tcsoft.security.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author WMY
 */
@Data
@ToString
public class UserServiceBean {

    private String type;
    private Integer userId;
    private Integer groupId;
    private Integer roleId;
    private String username;
    private String password;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean enabled;

    private String groupDescription;

    private String role;
    private String roleDescription;
    private Integer roleGrade;
    /**
     * 用户访问凭证
     */
    private String token;

}
