package com.tcsoft.setting.viewmodel;


import lombok.Data;
import lombok.ToString;


/**
 * @author WMY
 */
@Data
@ToString
public class RuleViewModel {

    private Integer hospitalId;
    private Integer ruleGroupId;
    private Integer ruleId;
    private String ruleName;
    private Integer instrumentGroupId;
    private Integer ruleTypeId;
    private String condition;
    private String actionTrue;
    private String actionFalse;
    private String comment;
    private Integer ruleOrder;
    private boolean isVisible = true;
    private boolean isRuleOnly = false;

}
