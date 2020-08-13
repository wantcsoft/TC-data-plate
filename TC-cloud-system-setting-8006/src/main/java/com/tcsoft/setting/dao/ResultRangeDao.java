package com.tcsoft.setting.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author WMY
 */
@Data
@TableName("BSC_ResultRange")
public class ResultRangeDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "ResultRangeID", type = IdType.AUTO)
    private Integer resultRangeId;

    @TableField(value = "LowerAge")
    private Integer lowerAge;

    @TableField(value = "UpperAge")
    private Integer upperAge;

    @TableField(value = "AgeTypeID")
    private Integer ageTypeId;

    @TableField(value = "RefLowerValue")
    private float refLowerValue;

    @TableField(value = "RefUpperValue")
    private float refUpperValue;

    @TableField(value = "SampleTypeID")
    private Integer sampleTypeId;

    @TableField(value = "AffirmLowerValue")
    private float affirmLowerValue;

    @TableField(value = "AffirmUpperValue")
    private float affirmUpperValue;

    @TableField(value = "ReportLowerValue")
    private float reportLowerValue;

    @TableField(value = "ReportUpperValue")
    private float reportUpperValue;

    @TableField(value = "IsDefault")
    private boolean isDefault;

    @TableField(value = "IsEnabled")
    private boolean isEnabled = true;

    @TableField(value = "IsDeleted")
    private boolean isDeleted = false;

}
