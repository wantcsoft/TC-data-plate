package com.tcsoft.sample.entity.Setting;

import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class TestItemTypeViewModel {

    private Integer hospitalId;
    private Integer testItemTypeId;
    private String testItemTypeName;

}
