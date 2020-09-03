package com.tcsoft.sample.entity;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 从Lis接受到的数据
 * @author WMY
 */
@Data
@ToString
public class OrderFromLis {

    private String hospitalCode;        //医院代码
    private String sampleId;            //样本条码号
    private String sampleTypeName;      //样本类型名称
    private String testTypeName;        //测试类型名称
    private Date collectTime;           //样本采集时间
    private Integer patientId;          //病人ID
    private String patientTypeName;     //病人类型名称
    private String patientName;         //病人姓名
    private Integer patientAge;         //病人年龄
    private String patientBirthDay;     //病人出生日期
    private String ageTypeName;         //年龄类型名称
    private String sexTypeName;         //性别类型名称
    private String requestWardCode;     //就诊科室
    private String rackNo;              //样本位置信息：架号
    private String cupNo;               //样本位置信息：杯号
    private String comment;             //医嘱信息
    private String chemCode;            //通道号，需要做那些测试项目
    private String priority;            //是否优先操作
    private String actionCode;          //操作代码

}