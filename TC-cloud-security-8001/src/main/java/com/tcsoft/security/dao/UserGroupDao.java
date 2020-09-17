package com.tcsoft.security.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author big_john
 */
@Data
@ToString
@NoArgsConstructor
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
