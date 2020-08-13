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
@TableName("BSC_InstrumentAlternateType")
public class InstrumentAlternateTypeDao {

    @TableId(value = "InstrumentAlternateTypeID", type = IdType.AUTO)
    private Integer instrumentAlternateTypeId;

    @TableField(value = "InstrumentAlternateTypeName")
    private String instrumentAlternateTypeName;

}
