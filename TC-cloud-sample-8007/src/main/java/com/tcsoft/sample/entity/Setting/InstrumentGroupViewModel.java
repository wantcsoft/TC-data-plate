package com.tcsoft.sample.entity.Setting;

import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class InstrumentGroupViewModel {

    private Integer hospitalId;
    private Integer instrumentGroupId;
    private String instrumentGroupName;

}
