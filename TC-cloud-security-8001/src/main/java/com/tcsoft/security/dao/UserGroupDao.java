package com.tcsoft.security.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author big_john
 */
@Data
@TableName("user_group")
public class UserGroupDao {

    @TableField(value = "group_id")
    @TableId(type = IdType.AUTO)
    private Integer groupId;

    @TableField(value = "group_description", insertStrategy = FieldStrategy.NOT_NULL)
    private String groupDescription;

}
