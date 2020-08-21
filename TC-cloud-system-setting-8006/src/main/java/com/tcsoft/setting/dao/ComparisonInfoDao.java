package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，对照信息，根据不同的设备类型、设备代码对应到不同的基础数据信息
 * @author WMY
 */
@Data
@TableName("BSC_ComparisonInfo")
@ToString
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
