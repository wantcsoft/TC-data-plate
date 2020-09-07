package com.tcsoft.sample.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 从Lis接受到的数据
 * @author WMY
 */
@Data
@ToString
@TableName("WOR_InfoFromLis")
public class InfoFromLis {
    @TableId(value = "SampleNo", type = IdType.AUTO)
    private Integer sampleNo;
    @TableField(value = "HospitalCode")
    private String hospitalCode;        //医院代码
    /**
     * 样本信息
     */
    @TableField(value = "SampleID")
    private String sampleId;            //样本条码号
    @TableField(value = "SampleTypeName")
    private String sampleTypeName;      //样本类型名称
    @TableField(value = "CollectTime")
    private Date collectTime;           //样本采集时间
    @TableField(value = "RackNo")
    private String rackNo;              //样本位置信息：架号
    @TableField(value = "CupNo")
    private String cupNo;               //样本位置信息：杯号
    /**
     * 病人信息
     */
    @TableField(value = "PatientID")
    private Integer patientId;          //病人ID
    @TableField(value = "PatientTypeName")
    private String patientTypeName;     //病人类型名称
    @TableField(value = "PatientName")
    private String patientName;         //病人姓名
    @TableField(value = "PatientAge")
    private Integer patientAge;         //病人年龄
    @TableField(value = "PatientBirthday")
    private Date patientBirthday;       //病人出生日期
    @TableField(value = "AgeTypeName")
    private String ageTypeName;         //年龄类型名称
    @TableField(value = "SexTypeName")
    private String sexTypeName;         //性别类型名称
    @TableField(value = "RequestWardCode")
    private String requestWardCode;     //就诊科室
    /**
     * 编程信息
     */
    @TableField(value = "TestItemCode")
    private String testItemCode;        //测试项目代码
    @TableField(value = "TestTypeName")
    private String testTypeName;        //测试类型名称
    @TableField(value = "ReplicateTimes")
    private Integer replicateTimes;     //复制次数
    /**
     * 其他信息
     */
    @TableField(value = "Comment")
    private String comment;             //医嘱信息
    @TableField(value = "ChemCode")
    private String chemCode;            //通道号，需要做那些测试项目
    @TableField(value = "Priority")
    private String priority;            //是否优先操作
    @TableField(value = "ActionFlag")
    private String actionFlag;          //操作代码

}
