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
@TableName("BSC_ComparisonType")
public class ComparisonTypeDao {

    @TableId(value = "ComparisonTypeID", type = IdType.AUTO)
    private Integer comparisonTypeId;

    @TableField(value = "ComparisonTypeName")
    private String comparisonTypeName;

    @TableField(value = "ComparisonTableName")
    private String comparisonTableName;

}
