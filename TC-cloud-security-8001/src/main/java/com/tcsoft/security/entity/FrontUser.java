package com.tcsoft.security.entity;

import lombok.Data;

/**
 * @author big_john
 */
@Data
public class FrontUser {

    private Integer userId;
    private String groupDescription;
    private String authorityDescription;
    private String username;
    private boolean accountNonLocked;
    private boolean enabled;

}
