package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，数据类型，针对规则方法参数类型、规则参数类型及结果数据类型
 * @author WMY
 */
@Data
@ToString
@TableName("BSC_DataType")
public class DataTypeDao {

    @TableId(value = "DataTypeID", type = IdType.AUTO)
    private Integer dataTypeId;

    @TableField(value = "DataTypeName")
    private String dataTypeName;
}
