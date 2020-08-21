package com.tcsoft.setting.viewmodel;

import lombok.Data;
import lombok.ToString;


/**
 * @author WMY
 */
@Data
@ToString
public class AgeTypeViewModel {

    private Integer ageTypeId;
    private Integer hospitalId;
    private String ageTypeName;
    private boolean isPermitted = true;

}
