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
@TableName("BSC_DataType")
public class DataTypeDao {

    @TableId(value = "DataTypeID", type = IdType.AUTO)
    private Integer dataTypeId;

    @TableField(value = "DataTypeName")
    private String dataTypeName;
}
