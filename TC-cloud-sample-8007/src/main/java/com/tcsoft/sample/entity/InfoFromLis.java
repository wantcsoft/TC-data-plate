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
public class InfoFromLis {
    /**
     * 样本信息
     */
    private String hospitalId;        //医院代码
    private String sampleId;            //样本条码号
    private Integer sampleTypeId;        //样本类型名称
    private Date collectTime;           //样本采集时间
    private String rackNo;              //样本位置信息：架号
    private String cupNo;               //样本位置信息：杯号
    /**
     * 病人信息
     */
    private Integer parentSampleNo;
    private Integer patientId;          // 病人ID
    private String patientCardNo;       // 病人身份证号
    private String patientBedNo;        // 病人床号
    private Integer patientTypeId;      // 病人类型名称
    private String patientName;         // 病人姓名
    private Integer patientAge;         // 病人年龄
    private Date patientBirthday;       // 病人出生日期
    private Integer ageTypeId;          // 年龄类型ID
    private Integer sexTypeId;          // 性别类型名称
    private String diagnosis;           // 诊断
    /**
     * 编程信息
     */
    private Integer testItemId;         // 测试项目代码
    private Integer testTypeId;         // 测试类型ID
    private Integer replicateTimes;     // 复制次数
    private Date progTime;              // 编程信息
    private Boolean isAliquot;          // 是否等分

}
