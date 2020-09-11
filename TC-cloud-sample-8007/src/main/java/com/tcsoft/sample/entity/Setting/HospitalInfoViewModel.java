package com.tcsoft.sample.entity.Setting;

import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class HospitalInfoViewModel {

    private Integer hospitalId;
    private String hospitalName;
    private String hospitalCode;
    private String location;
    private boolean isEnabled = true;

}
