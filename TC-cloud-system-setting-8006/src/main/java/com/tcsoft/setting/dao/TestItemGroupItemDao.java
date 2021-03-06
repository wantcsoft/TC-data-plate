package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，测试项目分组所包含的测试项目
 * @author WMY
 */
@Data
@ToString
@TableName("BSC_TestItemGroupItem")
public class TestItemGroupItemDao {
    @TableId(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "TestItemGroupID")
    private Integer testItemGroupId;

    @TableId(value = "TestItemID")
    private Integer testItemId;

}
