package com.tcsoft.security.entity;


import lombok.Data;

import java.util.Date;

/**
 * @author big_john
 */
@Data
public class QueryUserBean {

    private Integer userId;
    private String groupDescription;
    private String roleDescription;
    private String username;
    private Date lastPasswordResetDate;
    private boolean accountNonLocked;
    private boolean enabled;

}
