package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 基础配置信息，测试项目分组，例如肝功五项
 * @author WMY
 */
@Data
@TableName("BSC_TestItemGroup")
public class TestItemGroupDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "TestItemGroupID", type = IdType.AUTO)
    private Integer testItemGroupId;

    @TableField(value = "GroupName")
    private String groupName;

    @TableField(value = "InstrumentGroupID")
    private Integer instrumentGroupId;

    @TableField(value = "`Comment`")
    private String comment;

    @TableField(value = "IsEnabled")
    private boolean isEnabled;

}
