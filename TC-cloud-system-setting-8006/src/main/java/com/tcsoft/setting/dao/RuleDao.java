package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@TableName("BSC_Rule")
@ToString
public class RuleDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableField(value = "RuleGroupID")
    private Integer ruleGroupId;

    @TableId(value = "RuleID", type = IdType.AUTO)
    private Integer ruleId;

    @TableField(value = "RuleName")
    private String ruleName;

    @TableField(value = "InstrumentGroupID")
    private Integer instrumentGroupId;

    @TableField(value = "RuleTypeID")
    private Integer ruleTypeId;

    @TableField(value = "`Condition`")
    private String condition;

    @TableField(value = "ActionTrue")
    private String actionTrue;

    @TableField(value = "ActionFalse")
    private String actionFalse;

    @TableField(value = "`Comment`")
    private String comment;

    @TableField(value = "RuleOrder")
    private Integer ruleOrder;

    @TableField(value = "IsVisible")
    private boolean isVisible = true;

    @TableField(value = "IsRuleOnly")
    private boolean isRuleOnly = false;

}
