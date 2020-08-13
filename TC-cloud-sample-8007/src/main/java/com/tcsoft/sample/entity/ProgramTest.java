package com.tcsoft.sample.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author WMY
 */
@Data
@ToString
public class ProgramTest{

    private String testItemName;//样本测试名称
    private boolean isQCItem = false;//是否是QC样本
    private float accuracy = 0.01f;//测试准确性
    private boolean isAgeRelated;//是否是年龄相关
    private boolean isSexRelated;//是否是性别相关
    private boolean isSampleTypeRelated;//是否是样本类型相关
    private Integer unitId;//单元ID
    private boolean isOrdac;
    private String testItemTypeName;//测试类型名称
    private String resultTypeName;//测试结果名称
    private boolean isProgrammed = false;//是否已编程

    private Integer replicateTimes;//
    private Boolean isTested;//是否测试过
    private Date progTime;//编程时间
    private Date progSendTime;//编程信息发送时间
    private Integer ordacTimes;//
    private Integer rerunTimes;//重新运行次数
    private Integer reflexTimes;//
    private Boolean isAliquot;//是否等分
    private String sendFlag;//发送标志

}
