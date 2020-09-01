package com.tcsoft.setting.viewmodel;

import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class TestItemGroupItemViewModel {

    private Integer testItemGroupId;
    private Integer testItemId;

    private String groupName;
    private String testItemCode;

}
