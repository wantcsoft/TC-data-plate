package com.tcsoft.gateway.entity;


import lombok.Data;
import java.util.Date;


/**
 * @author big_john
 */
@Data
public class JwtUser {

    private final Integer userId;
    private final String username;
    private final String password;
    private final Integer groupId;
    private final Date lastPasswordResetDate;
    private final boolean accountNonLocked;
    private final boolean enabled;

}
