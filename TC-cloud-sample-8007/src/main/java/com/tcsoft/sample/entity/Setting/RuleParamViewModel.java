package com.tcsoft.sample.entity.Setting;


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
    private Integer dataTypeId;

    private String dataTypeName;

}
