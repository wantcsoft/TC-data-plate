package com.tcsoft.security.entity;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class UserAuthorityBean {

    private Integer userId;
    private String userName;
    private Integer groupId;

}
