package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，规则的类型，例如LIS-IN规则，DataUpdate规则等
 * @author WMY
 */
@Data
@ToString
@TableName("BSC_RuleType")
public class RuleTypeDao {

    @TableId(value = "RuleTypeID", type = IdType.AUTO)
    private Integer ruleTypeId;

    @TableField(value = "RuleTypeName")
    private String ruleTypeName;

}
