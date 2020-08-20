package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 基础配置信息，测试项目进行DeltaCheck的公式
 * @author WMY
 */
@Data
@TableName("BSC_TestItemDeltaCheck")
public class TestItemDeltaCheckDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "TestItemID", type = IdType.AUTO)
    private Integer testItemId;

    @TableField(value = "Formula")
    private String formula;

    @TableField(value = "DayRange")
    private Integer dayRange;

}
