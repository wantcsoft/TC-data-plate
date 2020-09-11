package com.tcsoft.sample.entity.Setting;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class ResultUnitViewModel {

    private Integer hospitalId;
    private Integer resultUnitId;
    private String resultUnit;
    private boolean isPermitted = true;

}
