package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 基础配置信息，测试项目基础信息
 * @author WMY
 */
@Data
@TableName("BSC_TestItemInfo")
public class TestItemInfoDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "TestItemID", type = IdType.AUTO)
    private Integer testItemId;

    @TableField(value = "TestItemCode")
    private String testItemCode;

    @TableField(value = "TestItemName")
    private String testItemName;

    @TableField(value = "PrintOrder")
    private Integer printOrder;

    @TableField(value = "IsQCItem")
    private boolean isQCItem = false;

    @TableField(value = "Accuracy")
    private float accuracy = 0.01f;

    @TableField(value = "IsAgeRelated")
    private boolean isAgeRelated;

    @TableField(value = "IsSexRelated")
    private boolean isSexRelated;

    @TableField(value = "IsSampleTypeRelated")
    private boolean isSampleTypeRelated;

    @TableField(value = "UnitID")
    private Integer unitId;

    @TableField(value = "IsOrdac")
    private boolean isOrdac;

    @TableField(value = "TestItemTypeID")
    private Integer testItemTypeId;

    @TableField(value = "ResultTypeID")
    private Integer resultTypeId;

    @TableField(value = "IsProgrammed")
    private boolean isProgrammed = false;

    @TableField(value = "IsEnabled")
    private boolean isEnabled = true;

    @TableField(value = "IsDeleted")
    @TableLogic
    private boolean isDeleted = false;

}
