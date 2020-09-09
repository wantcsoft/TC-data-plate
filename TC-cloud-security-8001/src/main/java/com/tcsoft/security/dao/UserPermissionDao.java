package com.tcsoft.security.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
@TableName("UserPermission")
public class UserPermissionDao {

    @TableId(value = "UserID")
    private Integer userId;
    @TableId(value = "AuthorityID")
    private Integer authorityId;

}
