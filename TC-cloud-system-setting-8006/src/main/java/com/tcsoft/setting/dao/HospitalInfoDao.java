package com.tcsoft.setting.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，医院信息
 * @author WMY
 */
@Data
@TableName("BSC_HospitalInfo")
@ToString
public class HospitalInfoDao {

    @TableId(value = "HospitalID", type = IdType.AUTO)
    private Integer hospitalId;

    @TableField(value = "HospitalName")
    private String hospitalName;

    @TableField(value = "HospitalCode")
    private String hospitalCode;

    @TableField(value = "Location")
    private String location;

    @TableField(value = "IsEnabled")
    private boolean isEnabled = true;

    @TableField(value = "IsDeleted")
    @TableLogic
    private boolean isDeleted = false;

}
