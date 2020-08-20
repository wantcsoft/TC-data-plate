package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 基础配置信息，测试类型，包括常规、指控等
 * @author WMY
 */
@Data
@TableName("BSC_TestType")
public class TestTypeDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;
    @TableId(value = "TestTypeID", type = IdType.AUTO)
    private Integer testTypeId;
    @TableField(value = "TestTypeName")
    private String testTypeName;
    @TableField(value = "ResultStatMinutes")
    private Integer resultStatMinutes;
    @TableField(value = "IsPermitted")
    private boolean isPermitted;
    @TableField(value = "IsDeleted")
    @TableLogic
    private boolean isDeleted = false;

}
