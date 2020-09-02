package com.tcsoft.setting.viewmodel;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class LotSetViewModel {

    private String materialName;

    private Integer lotSetId;
    private Integer materialId;
    private Integer hospitalId;
    private String lotSetName;
    private Integer levelCount;
    private String level1Code;
    private String level2Code;
    private String level3Code;
    private boolean isActive;

}
