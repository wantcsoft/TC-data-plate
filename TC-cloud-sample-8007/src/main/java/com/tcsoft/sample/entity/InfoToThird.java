package com.tcsoft.sample.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;


/**
 * 将医嘱信息下发给第三方
 * @author WMY
 */
@Data
@ToString
public class InfoToThird {
    /**
     * 样本信息
     */
    private Integer sampleNo;                   //样本号（平台生成，唯一）
    private String sampleTypeName;              //样本类型名称
    private String testTypeName;                //测试类型名称
    private Date collectTime;           //样本采集时间
    private String rackNo;              //样本位置信息：架号
    private String cupNo;               //样本位置信息：杯号
    /**
     * 病人信息
     */
    private Integer patientId;          //病人ID
    private String patientTypeName;     //病人类型名称
    private String patientName;         //病人姓名
    private Integer patientAge;         //病人年龄
    private Date patientBirthday;     //病人出生日期
    private String ageTypeName;         //年龄类型名称
    private String sexTypeName;         //性别类型名称
    /**
     * 医嘱信息
     */
    private String comment;             //医嘱信息
    private String chemCode;            //通道号，需要做那些测试项目
    private String priority;            //是否优先操作
    private String actionFlag;          //医嘱对应的行动代码
    /**
     * 分杯信息
     */
    private Boolean isAliquot;

}
