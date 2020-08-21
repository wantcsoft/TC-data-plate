package com.tcsoft.setting.viewmodel;

import lombok.Data;
import lombok.ToString;


/**
 * @author WMY
 */
@Data
@ToString
public class ActionCodeViewModel {

    private Integer hospitalId;
    private Integer actionId;
    private String actionFlag;
    private boolean isEnabled = true;

}
