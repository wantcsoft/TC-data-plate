package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author WMY
 */
@Data
@TableName("BSC_RuleGroup")
public class RuleGroupDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "RuleGroupID", type = IdType.AUTO)
    private Integer ruleGroupId;

    @TableField(value = "RuleGroupName")
    private String ruleGroupName;

    @TableField(value = "IsDefault")
    private boolean isDefault = false;

}
