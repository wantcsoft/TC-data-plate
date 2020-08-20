package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，样本流水线状态
 * @author WMY
 */
@Data
@TableName("BSC_SampleState")
@ToString
public class SampleStateDao {

    @TableId(value = "SampleStateID", type = IdType.AUTO)
    private Integer sampleStateId;
    @TableField(value = "ParentSampleState")
    private Integer parentSampleState;
    @TableField(value = "SampleStateName")
    private String sampleStateName;
    @TableField(value = "IsSamplePosition")
    private boolean isSamplePosition;
    @TableField(value = "InstrumentRelated")
    private boolean instrumentRelated;
    @TableField(value = "DisplayOrder")
    private Integer displayOrder;
    @TableField(value = "StateDisplayName")
    private String stateDisplayName;
    @TableField(value = "DefaultDisplayName")
    private String defaultDisplayName;
    @TableField(value = "BindInstrumentID")
    private Integer bindInstrumentId;

}
