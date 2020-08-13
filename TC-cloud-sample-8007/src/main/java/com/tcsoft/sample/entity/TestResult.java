package com.tcsoft.sample.entity;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author WMY
 */
@Data
@ToString
public class TestResult {

    private Integer sampleNo;// 样本号
    private String testItemCode;// 样本测试编码
    private String testItemName;// 样本测试名称
    private String resultTxt;// 测试结果
    private Float resultNumeric;// 测试数据
    private Integer rerunTimes;// 重新检测次数
    private Integer confirmStateId;// 确认状态ID
    private Integer instrumentId;// 仪器ID
    private Date testTime;// 测试时间
    private String reagentSerialNo;// 试剂序列号
    private String reagentLotNo;//
    private String chemCode;// 化学代码
    private Integer auditStateId;// 审核状态ID
    private String errorInfo;// 错误信息
    private Boolean isUpload;// 是否上传
    private Float diluteFactor;// 稀释因子
    private Integer resultRangeId;
    private Integer lowerAge;
    private Integer upperAge;
    private float refLowerValue;
    private float refUpperValue;
    private float affirmLowerValue;
    private float affirmUpperValue;
    private float reportLowerValue;
    private float reportUpperValue;
    private boolean isDefault;

    private Boolean isOrdac;//
    private Boolean isMerged;// 是否合并
    private String calculatedResult;// 计算结果
    private Integer replicateNo;//
    private Integer unitId;//

}
