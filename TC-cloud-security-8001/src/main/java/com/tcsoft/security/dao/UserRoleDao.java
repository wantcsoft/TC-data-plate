package com.tcsoft.security.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 数据表UserRole对象模型
 * @author big_john
 */
@Data
@TableName("UserRole")
public class UserRoleDao {

    @TableField(value = "`RoleID`")
    @TableId(type = IdType.AUTO)
    private Integer roleId;

    @TableField(value = "`Role`")
    private String role;

    @TableField(value = "RoleDescription")
    private String roleDescription;

}
