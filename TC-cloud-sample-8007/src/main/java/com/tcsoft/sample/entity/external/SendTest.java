package com.tcsoft.sample.entity.external;

import lombok.Data;
import lombok.ToString;
import java.util.List;

/**
 * 发送给流水线的样本信息和编程测试信息
 * @author WMY
 */
@Data
@ToString
public class SendTest {

    private String hospitalCode;//医院代码
    private String sampleId;//样本条码号
    private String rackNo;//样本位置信息
    private String cupNo;//样本位置信息
    private Integer resultErrorFlag;//结果错误标志
    private String diagnosis;//医嘱信息

    private List<ProgramTest> programTests;//编程项目列表

}

