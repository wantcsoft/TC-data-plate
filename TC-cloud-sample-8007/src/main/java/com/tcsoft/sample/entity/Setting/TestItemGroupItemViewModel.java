package com.tcsoft.sample.entity.Setting;

import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class TestItemGroupItemViewModel {

    private Integer hospitalId;
    private Integer testItemGroupId;
    private Integer testItemId;

    private String groupName;
    private String testItemName;

}
