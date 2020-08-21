package com.tcsoft.setting.viewmodel;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class LotSetViewModel {

    private Integer lotSetId;
    private Integer materialId;
    private String lotSetName;
    private Integer levelCount;
    private String level1Code;
    private String level2Code;
    private String level3Code;
    private boolean isActive;

}
