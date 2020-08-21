package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，规则分组设置
 * 一家医院可以设置多组规则，其中IsDefault为True的规则组是运行规则，IsActive忽略
 * 其他的规则为模拟规则，不会对运行数据产生影响
 * @author WMY
 */
@Data
@ToString
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
