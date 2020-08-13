package com.tcsoft.sample.entity;


import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author WMY
 */
@Data
@ToString
public class ReceiveOrder {

    private String hospitalCode;//医院代码
    private String sampleId;//样本条码号
    private String sampleTypeCode;//样本类型代码
    private String testTypeCode;//测试类型代码
    private Date collectTime;//样本采集时间
    private Integer patientId;//病人ID
    private String patientTypeCode;//病人类型代码
    private String patientName;//病人姓名
    private Integer patientAge;//病人年龄
    private String patientBirthDay;//病人出生日期
    private String ageTypeCode;//年龄类型代码
    private String sexTypeCode;//性别类型代码
    private String requestWardCode;//就诊科室
    private String rackNo;//样本位置信息
    private String cupNo;//样本位置信息
    private String comment;//医嘱信息
    private String chemCode;//通道号，需要做那些测试项目
    private String priority;//是否优先操作
    private String actionCode;//操作代码

    private List<ProgramOrder> programOrderList;

}
