package com.tcsoft.sample.entity.Setting;

import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class PrepLinkErrorCodeViewModel {

    private Integer hospitalId;
    private Integer errorId;
    private String errorCode;

}
