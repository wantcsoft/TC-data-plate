package com.tcsoft.sample.entity.Setting;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class TestItemDeltaCheckViewModel {

    private Integer hospitalId;
    private Integer testItemId;

    private String testItemName;

    private String formula;
    private Integer dayRange;

}
