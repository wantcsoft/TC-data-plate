package com.tcsoft.setting.viewmodel;

import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class PrepLinkAbortCodeViewModel {

    private Integer hospitalId;
    private Integer abortId;
    private String abortCode;

}
