package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author WMY
 */
@Data
@TableName("BSC_InstrumentType")
public class InstrumentTypeDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "InstrumentTypeID", type = IdType.AUTO)
    private Integer instrumentTypeId;

    @TableField(value = "InstrumentTypeName")
    private String instrumentTypeName;

    @TableField(value = "IsGraphSupport")
    private boolean isGraphSupport = false;

    @TableField(value = "IsEnabled")
    private boolean isEnabled = true;

}
