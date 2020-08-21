package com.tcsoft.setting.viewmodel;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class RuleGroupViewModel {

    private Integer hospitalId;
    private Integer ruleGroupId;
    private String ruleGroupName;
    private boolean isDefault = false;

}
