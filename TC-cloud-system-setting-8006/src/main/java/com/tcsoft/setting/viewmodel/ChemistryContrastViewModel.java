package com.tcsoft.setting.viewmodel;

import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class ChemistryContrastViewModel {

    private Integer hospitalId;
    private Integer testItemId;
    private Integer sampleTypeId;
    private Integer instrumentId;

    private String testItemName;
    private String sampleTypeName;
    private String instrumentName;
    private String chemCode;
    private boolean isProgrammed;

}
