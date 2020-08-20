package com.tcsoft.security.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author WMY
 */
@Data
@ToString
public class UserServiceBean implements Serializable {

    private Integer userId;
    private Integer groupId;
    private Integer roleId;
    private String username;
    private String password;
    private boolean accountNonLocked = false;
    private boolean accountNonExpired = false;
    private boolean credentialsNonExpired = false;
    private boolean enabled = true;

    private String groupDescription;

    private String role;
    private String roleDescription;
    private Integer roleGrade;
    /**
     * 用户访问凭证
     */
    private String token;

    private QueryConditionBean condition;

}
