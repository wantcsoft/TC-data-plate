package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
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
