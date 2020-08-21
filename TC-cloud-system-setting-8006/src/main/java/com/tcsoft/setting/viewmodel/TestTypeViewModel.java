package com.tcsoft.setting.viewmodel;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class TestTypeViewModel {

    private Integer hospitalId;
    private Integer testTypeId;
    private String testTypeName;
    private Integer resultStatMinutes;
    private boolean isPermitted;

}
