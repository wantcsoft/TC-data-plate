package com.tcsoft.sample.entity.Setting;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class TestItemGroupViewModel {

    private Integer hospitalId;
    private Integer testItemGroupId;
    private String groupName;
    private Integer instrumentGroupId;

    private String instrumentGroupName;
    private String comment;
    private boolean isEnabled;

}
