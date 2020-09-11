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
public class InfoFromLis {
    private Integer sampleNo;
    private String hospitalId;        //医院代码
    /**
     * 样本信息
     */
    private String sampleId;            //样本条码号
    private Integer sampleTypeId;        //样本类型名称
    private Date collectTime;           //样本采集时间
    private String rackNo;              //样本位置信息：架号
    private String cupNo;               //样本位置信息：杯号
    /**
     * 病人信息
     */
    private Integer patientId;          //病人ID
    private String patientCardNo;       //病人身份证号
    private String patientBedNo;        //病人床号
    private Integer patientTypeId;     //病人类型名称
    private String patientName;         //病人姓名
    private Integer patientAge;         //病人年龄
    private Integer ageTypeId;
    private Date patientBirthday;       //病人出生日期
    private String ageTypeName;         //年龄类型名称
    private Integer sexTypeId;         //性别类型名称
    private String requestWardCode;     //就诊科室
    /**
     * 编程信息
     */
    private Integer testItemId;        //测试项目代码
    private Integer testTypeId;        //测试类型名称
    private Integer replicateTimes;     //复制次数
    /**
     * 其他信息
     */
    private Integer parentSampleNo;
    private String comment;             //医嘱信息
    private String chemCode;            //通道号，需要做那些测试项目
    private String priority;            //是否优先操作
    private String actionFlag;          //操作代码

}
