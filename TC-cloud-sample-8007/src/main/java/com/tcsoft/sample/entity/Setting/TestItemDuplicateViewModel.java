package com.tcsoft.sample.entity.Setting;

import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class TestItemDuplicateViewModel {

    private Integer hospitalId;
    private Integer sourceTestItemId;
    private Integer duplicateTestItemId;

}
