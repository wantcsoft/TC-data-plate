package com.tcsoft.sample.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author WMY
 * @since 2020-08-10
 */
@Data
@TableName("WOR_SampleInfo")
public class SampleInfoDao implements Serializable {

    @TableField("HospitalID")
    private Integer hospitalId;

    @TableId(value = "SampleNo", type = IdType.AUTO)
    private Integer sampleNo;

    @TableField("SampleID")
    private String sampleId;

    @TableField("SampleTypeID")
    private Integer sampleTypeId;

    @TableField("TestTypeID")
    private Integer testTypeId;

    @TableField("SampleStatusID")
    private Integer sampleStatusId;

    @TableField("RackNo")
    private String rackNo;

    @TableField("CollectTime")
    private Date collectTime;

    @TableField("CupNo")
    private String cupNo;

    @TableField("ConfirmStateID")
    private Integer confirmStateId;

    @TableField("ResultErrroFlag")
    private Integer resultErrroFlag;

    @TableField("CheckerID")
    private Integer checkerId;

    @TableField("AffirmerID")
    private Integer affirmerId;

    @TableField("TestFree")
    private Float testFree;

    @TableField("PatientCardNo")
    private String patientCardNo;

    @TableField("OutInPatientID")
    private String outInPatientId;

    @TableField("PatientBedNo")
    private String patientBedNo;

    @TableField("PatientTypeID")
    private Integer patientTypeId;

    @TableField("PatientName")
    private String patientName;

    @TableField("PatientAge")
    private Integer patientAge;

    @TableField("AgeTypeID")
    private Integer ageTypeId;

    @TableField("SexTypeID")
    private Integer sexTypeId;

    @TableField("Diagnosis")
    private String diagnosis;

    @TableField("AuditStateID")
    private Integer auditStateId;

    @TableField("IsUpload")
    private Boolean isUpload;

    @TableField("IsDiluted")
    private Boolean isDiluted;

    @TableField("ParentSampleNo")
    private Integer parentSampleNo;

}
