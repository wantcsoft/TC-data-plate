package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author WMY
 */
@Data
@TableName("BSC_TestItemGroupItem")
public class TestItemGroupItemDao {

    @TableId(value = "TestItemGroupID")
    private Integer testItemGroupId;

    @TableId(value = "TestItemID")
    private Integer testItemId;

}
