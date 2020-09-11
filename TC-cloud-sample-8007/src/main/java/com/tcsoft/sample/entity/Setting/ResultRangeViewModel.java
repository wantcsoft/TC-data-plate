package com.tcsoft.sample.entity.Setting;

import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，测试项目结果的范围值，用于结果的审核、规则判断等
 * @author WMY
 */
@Data
@ToString
public class ResultRangeViewModel {

    private String ageTypeName;
    private String sampleTypeName;

    private Integer hospitalId;
    private Integer resultRangeId;
    private Integer lowerAge;
    private Integer upperAge;
    private Integer ageTypeId;
    private float refLowerValue;
    private float refUpperValue;
    private Integer sampleTypeId;
    private float affirmLowerValue;
    private float affirmUpperValue;
    private float reportLowerValue;
    private float reportUpperValue;
    private boolean isDefault;
    private boolean isEnabled = true;

}
