package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 基础配置信息，测试项目映射表，针对一些特定的测试项目，例如LIH测试项目实际运行时将会以三个测试项目代替
 * @author WMY
 */
@Data
@TableName("BSC_TestItemDuplicate")
public class TestItemDuplicateDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableField(value = "SourceTestItemID")
    private Integer sourceTestItemId;

    @TableId(value = "DuplicateTestItemID", type = IdType.AUTO)
    private Integer duplicateTestItemId;

}
