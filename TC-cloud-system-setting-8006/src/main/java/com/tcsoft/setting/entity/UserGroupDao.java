package com.tcsoft.setting.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * @author big_john
 */
@Data
@ToString
@NoArgsConstructor
public class UserGroupDao {

    private Integer groupId;
    private String group;
    private String groupDescription;

}
