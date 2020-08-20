package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 基础配置信息，映射类型，例如ComparisonTypeID =1 表示映射年龄，2表示映射样本类型
 * @author WMY
 */
@Data
@TableName("BSC_ComparisonType")
public class ComparisonTypeDao {

    @TableId(value = "ComparisonTypeID", type = IdType.AUTO)
    private Integer comparisonTypeId;

    @TableField(value = "ComparisonTypeName")
    private String comparisonTypeName;

    @TableField(value = "ComparisonTableName")
    private String comparisonTableName;

}
