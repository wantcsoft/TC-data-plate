package com.tcsoft.security.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author big_john
 */
@Data
@TableName("userGroup")
public class UserGroupDao {

    @TableField(value = "groupId")
    @TableId(type = IdType.AUTO)
    private Integer groupId;

    @TableField(value = "`group`")
    private String group;

    @TableField(value = "groupDescription")
    private String groupDescription;

}
