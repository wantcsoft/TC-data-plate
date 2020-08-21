package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，样本类型
 * @author WMY
 */
@Data
@ToString
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

    @TableLogic
    @TableField(value = "IsDeleted")
    private boolean isDeleted = false;

}
