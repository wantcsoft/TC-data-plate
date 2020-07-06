package com.tcsoft.security.dao;

import lombok.Data;

/**
 * @author big_john
 */
@Data
public class UserRoleDao {

    private Integer roleId;
    private String role;
    private String roleDescription;
    private Integer roleGrade;

}
