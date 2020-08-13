package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
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
