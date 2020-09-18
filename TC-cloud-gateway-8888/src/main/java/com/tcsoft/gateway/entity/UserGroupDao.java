package com.tcsoft.gateway.entity;

import lombok.Data;

/**
 * 从redis中反序列化出group对象
 * @author big_john
 */
@Data
public class UserGroupDao {

    private Integer groupId;
    private String group;
    private String groupDescription;

}
