package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author WMY
 */
@Data
@TableName("BSC_PatientType")
public class PatientTypeDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "PatientTypeID", type = IdType.AUTO)
    private Integer patientTypeId;

    @TableField(value = "PatientTypeName")
    private String patientTypeName;

    @TableField(value = "Comment")
    private String comment;

    @TableField(value = "IsEnabled")
    private boolean isEnabled = true;

    @TableField(value = "IsDeleted")
    @TableLogic
    private boolean isDeleted = false;

}
