package com.tcsoft.setting.viewmodel;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class RuleParamViewModel {

    private Integer ruleParamId;
    private String paramCode;
    private String paramDesc;
    private String dataTypeId;

}
