package com.tcsoft.setting.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 基础配置信息，设备分组设置，可对应多条流水线
 * @author WMY
 */
@Data
@TableName("BSC_InstrumentGroup")
public class InstrumentGroupDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "InstrumentGroupID", type = IdType.AUTO)
    private Integer instrumentGroupId;

    @TableField(value = "InstrumentGroupName")
    private String instrumentGroupName;

}
