package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author WMY
 */
@Data
@TableName("BSC_SampleType")
public class SampleTypeDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "SampleTypeID", type = IdType.AUTO)
    private Integer sampleTypeId;

    @TableField(value = "SampleTypeName")
    private String sampleTypeName;

    @TableField(value = "IsPermitted")
    private boolean isPermitted = true;

    @TableField(value = "IsDeleted")
    private boolean isDeleted = false;

}
