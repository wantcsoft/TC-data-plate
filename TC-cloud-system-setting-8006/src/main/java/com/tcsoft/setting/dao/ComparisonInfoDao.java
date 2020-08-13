package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author WMY
 */
@Data
@TableName("BSC_ComparisonInfo")
public class ComparisonInfoDao {

    @TableId(value = "InstrumentTypeID")
    private Integer instrumentTypeId;

    @TableId(value = "ComparisonTypeID")
    private Integer comparisonTypeId;

    @TableId(value = "InstrumentInfo")
    private String instrumentInfo;

    @TableField(value = "ComparedTypeID")
    private Integer comparedTypeId;

}
