package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，测试项目进行DeltaCheck的公式
 * @author WMY
 */
@Data
@ToString
@TableName("BSC_TestItemDeltaCheck")
public class TestItemDeltaCheckDao {

    @TableId(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "TestItemID")
    private Integer testItemId;

    @TableField(value = "Formula")
    private String formula;

    @TableField(value = "DayRange")
    private Integer dayRange;

}
