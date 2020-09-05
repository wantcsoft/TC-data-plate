package com.tcsoft.security.dao;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
@TableName("Authority")
public class AuthorityDao {

    @TableId(value = "AuthorityID")
    private Integer authorityId;

    @TableField(value = "Authority")
    private String authority;

    @TableField(value = "AuthorityDescription")
    private String authorityDescription;

}
