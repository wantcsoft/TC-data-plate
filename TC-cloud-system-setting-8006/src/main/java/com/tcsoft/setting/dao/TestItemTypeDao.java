package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，测试项目类型，例如生化、免疫、血球等
 * @author WMY
 */
@Data
@ToString
@TableName("BSC_TestItemType")
public class TestItemTypeDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "TestItemTypeID", type = IdType.AUTO)
    private Integer testItemTypeId;

    @TableField(value = "TestItemTypeName")
    private String testItemTypeName;

}
