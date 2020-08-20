package com.tcsoft.sample.entity.external;


import lombok.Data;
import lombok.ToString;
import java.util.List;

/**
 * 发送给lis的order结果数据
 * @author WMY
 */
@Data
@ToString
public class SendOrder {

    private String hospitalCode;//医院代码
    private String sampleId;//样本条码号
    private Integer resultErrorFlag;//结果错误标志

    private List<TestResult> testResults;

}
