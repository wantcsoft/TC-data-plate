package com.tcsoft.security.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * 数据表UserAuthority的对象模型
 * @author WMY
 */
@Data
@ToString
@TableName("UserAuthority")
public class UserAuthorityDao {

    @TableId(value = "AuthorityID", type = IdType.AUTO)
    private Integer authorityId;

    @TableField(value = "Authority")
    private String authority;

    @TableField(value = "AuthorityDescription")
    private String authorityDescription;

}
