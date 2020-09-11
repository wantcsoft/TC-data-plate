package com.tcsoft.sample.entity.Setting;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class RuleFunctionViewModel {

    private String firstParam;
    private String secondParam;

    private Integer ruleFunctionId;
    private String ruleFunctionName;
    private Integer paramCount;
    private Integer firstParamDataType;
    private Integer secondParamDataType;
    private String comment;

}
