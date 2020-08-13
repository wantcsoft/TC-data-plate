package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author WMY
 */
@Data
@TableName("BSC_RuleType")
public class RuleTypeDao {

    @TableId(value = "RuleTypeID", type = IdType.AUTO)
    private Integer ruleTypeId;

    @TableField(value = "RuleTypeName")
    private String ruleTypeName;

}
