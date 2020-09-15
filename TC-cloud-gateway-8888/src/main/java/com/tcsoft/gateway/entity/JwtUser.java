package com.tcsoft.gateway.entity;


import lombok.Data;

import java.util.Date;


/**
 * @author big_john
 */
@Data
public class JwtUser {

    private Integer userId;
    private String username;
    private String password;
    private Integer groupId;
    private Date lastPasswordResetDate;
    private boolean accountNonLocked;
    private boolean enabled;

}
