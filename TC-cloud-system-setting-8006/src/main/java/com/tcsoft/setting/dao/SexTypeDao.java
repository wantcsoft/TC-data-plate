package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，性别类型
 * @author WMY
 */
@Data
@ToString
@TableName("BSC_SexType")
public class SexTypeDao {

    @TableId(value = "SexTypeID", type = IdType.AUTO)
    private Integer sexTypeId;

    @TableField(value = "SexTypeName")
    private String sexTypeName;

    @TableField(value = "IsDeleted")
    @TableLogic
    private boolean isDeleted = false;

}
