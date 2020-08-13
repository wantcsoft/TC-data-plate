package com.tcsoft.security.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author big_john
 */
@Data
@TableName("user_role")
public class UserRoleDao {

    @TableField(value = "role_id")
    @TableId(type = IdType.AUTO)
    private Integer roleId;

    @TableField(value = "role", insertStrategy = FieldStrategy.NOT_NULL)
    private String role;

    @TableField(value = "role_description", insertStrategy = FieldStrategy.NOT_NULL)
    private String roleDescription;

    @TableField(value = "role_grade", insertStrategy = FieldStrategy.NOT_NULL)
    private Integer roleGrade;

}
