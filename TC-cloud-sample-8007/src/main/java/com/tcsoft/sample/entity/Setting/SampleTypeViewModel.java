package com.tcsoft.sample.entity.Setting;


import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，样本类型
 * @author WMY
 */
@Data
@ToString
public class SampleTypeViewModel {

    private Integer hospitalId;
    private Integer sampleTypeId;
    private String sampleTypeName;
    private boolean isPermitted = true;

}
