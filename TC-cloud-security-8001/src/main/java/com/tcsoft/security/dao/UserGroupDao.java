package com.tcsoft.security.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author big_john
 */
@Data
@TableName("UserGroup")
public class UserGroupDao {

    @TableField(value = "`GroupID`")
    @TableId(type = IdType.AUTO)
    private Integer groupId;

    @TableField(value = "`Group`")
    private String group;

    @TableField(value = "GroupDescription")
    private String groupDescription;

}
