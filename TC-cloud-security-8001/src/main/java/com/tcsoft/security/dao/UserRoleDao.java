package com.tcsoft.security.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author big_john
 */
@Data
@TableName("userRole")
public class UserRoleDao {

    @TableField(value = "roleId")
    @TableId(type = IdType.AUTO)
    private Integer roleId;

    @TableField(value = "`role`")
    private String role;

    @TableField(value = "roleDescription")
    private String roleDescription;

    @TableField(value = "roleGrade")
    private Integer roleGrade;

}
