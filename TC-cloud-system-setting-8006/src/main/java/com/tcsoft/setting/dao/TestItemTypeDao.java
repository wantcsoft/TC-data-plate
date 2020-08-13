package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author WMY
 */
@Data
@TableName("BSC_TestItemType")
public class TestItemTypeDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "TestItemTypeID", type = IdType.AUTO)
    private Integer testItemTypeId;

    @TableField(value = "TestItemTypeName")
    private String testItemTypeName;

}
