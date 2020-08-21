package com.tcsoft.setting.viewmodel;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class InstrumentTypeViewModel {

    private Integer hospitalId;
    private Integer instrumentTypeId;
    private String instrumentTypeName;
    private boolean isGraphSupport = false;
    private boolean isEnabled = true;

}
