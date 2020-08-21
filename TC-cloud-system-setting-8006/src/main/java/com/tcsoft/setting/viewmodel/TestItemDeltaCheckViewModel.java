package com.tcsoft.setting.viewmodel;


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
    private String formula;
    private Integer dayRange;

}
