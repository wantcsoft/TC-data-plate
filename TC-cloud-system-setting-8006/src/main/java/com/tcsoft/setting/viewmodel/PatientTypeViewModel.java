package com.tcsoft.setting.viewmodel;

import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class PatientTypeViewModel {

    private Integer hospitalId;
    private Integer patientTypeId;
    private String patientTypeName;
    private String comment;
    private boolean isEnabled = true;

}
