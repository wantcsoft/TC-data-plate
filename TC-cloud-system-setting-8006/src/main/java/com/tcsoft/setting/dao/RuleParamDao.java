package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 基础配置信息，规则的参数，在传递参数的时候需要对参数的类型域规则方法参数的类型进行匹配，如果不一致，则无法设置
 * @author WMY
 */
@Data
@TableName("BSC_RuleParam")
public class RuleParamDao {

    @TableId(value = "RuleParamID", type = IdType.AUTO)
    private Integer ruleParamId;

    @TableField(value = "ParamCode")
    private String paramCode;

    @TableField(value = "ParamDesc")
    private String paramDesc;

    @TableField(value = "DataTypeID")
    private String dataTypeId;

}
