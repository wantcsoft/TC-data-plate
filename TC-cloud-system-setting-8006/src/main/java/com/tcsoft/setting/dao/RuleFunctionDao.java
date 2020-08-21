package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，规则所支持的函数
 * @author WMY
 */
@Data
@ToString
@TableName("BSC_RuleFunction")
public class RuleFunctionDao {

    @TableId(value = "RuleFunctionID", type = IdType.AUTO)
    private Integer ruleFunctionId;

    @TableField(value = "RuleFunctionName")
    private String ruleFunctionName;

    @TableField(value = "ParamCount")
    private Integer paramCount;

    @TableField(value = "FirstParamDataType")
    private Integer firstParamDataType;

    @TableField(value = "SecondParamDataType")
    private Integer secondParamDataType;

    @TableField(value = "Comment")
    private String comment;

}
