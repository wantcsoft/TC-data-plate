package com.tcsoft.setting.viewmodel;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class RuleFunctionViewModel {

    private Integer ruleFunctionId;
    private String ruleFunctionName;
    private Integer paramCount;
    private Integer firstParamDataType;
    private Integer secondParamDataType;
    private String comment;

}
