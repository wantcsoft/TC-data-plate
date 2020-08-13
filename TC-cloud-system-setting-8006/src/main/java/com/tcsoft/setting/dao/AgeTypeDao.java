package com.tcsoft.setting.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@TableName("BSC_AgeType")
@ToString
public class AgeTypeDao {

    @TableId(value = "AgeTypeID", type = IdType.AUTO)
    private Integer ageTypeId;

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableField(value = "AgeTypeName")
    private String ageTypeName;

    @TableField(value = "IsPermitted")
    private boolean isPermitted = true;

    @TableField(value = "IsDeleted")
    @TableLogic
    private boolean isDeleted = false;

}
