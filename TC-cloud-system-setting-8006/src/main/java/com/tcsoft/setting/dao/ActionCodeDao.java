package com.tcsoft.setting.dao;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，医嘱下载的操作代码对照表
 * 通常情况下使用 A--Add, C--Clear, R--Rerun
 * @author WMY
 */
@Data
@TableName("BSC_ActionCode")
@ToString
public class ActionCodeDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "ActionID", type = IdType.AUTO)
    private Integer actionId;

    @TableField(value = "ActionFlag")
    private String actionFlag;

    @TableField(value = "IsEnabled")
    private boolean isEnabled = true;

    @TableField(value = "IsDeleted")
    @TableLogic
    private boolean isDeleted = false;

}
