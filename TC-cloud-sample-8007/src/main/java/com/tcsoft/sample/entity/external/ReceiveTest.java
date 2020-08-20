package com.tcsoft.sample.entity.external;


import lombok.Data;
import lombok.ToString;
import java.util.List;

/**
 * 从流水线之类的那边接收到结果的相关字段
 * @author WMY
 */
@Data
@ToString
public class ReceiveTest {

    private String hospitalCode;//医院代码
    private String sampleId;// 样本条码号
    private Integer resultErrorFlag;// 结果错误标志
    private String comment;// 备注信息

    private List<TestResult> testResults;

}
