package com.tcsoft.setting.viewmodel;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class TestItemInfoViewModel {

    private String testItemTypeName;
    private String dataTypeName;
    private String resultUnit;

    private Integer hospitalId;
    private Integer testItemId;
    private String testItemCode;
    private String testItemName;
    private Integer printOrder;
    private boolean isQcItem = false;
    private float accuracy = 0.01f;
    private boolean isAgeRelated;
    private boolean isSexRelated;
    private boolean isSampleTypeRelated;
    private Integer unitId;
    private boolean isOrdac;
    private Integer testItemTypeId;
    private Integer dataTypeId;
    private boolean isProgrammed = false;
    private boolean isEnabled = true;

}
