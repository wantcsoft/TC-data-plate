package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 基础配置信息，测试项目结果的单位
 * @author WMY
 */
@Data
@TableName("BSC_ResultUnit")
public class ResultUnitDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "ResultUnitID", type = IdType.AUTO)
    private Integer resultUnitId;

    @TableField(value = "ResultUnit")
    private String resultUnit;

    @TableField(value = "IsPermitted")
    private boolean isPermitted = true;

    @TableField(value = "IsDeleted")
    @TableLogic
    private boolean isDeleted = false;

}
