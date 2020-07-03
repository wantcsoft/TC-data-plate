package com.tcsoft.security.dao;

import lombok.Data;

/**
 * @author big_john
 */
@Data
public class UserAuthorityDao {

    private Integer authorityId;
    private String authority;
    private String authorityDescription;
    private Integer authorityGrade;

}
