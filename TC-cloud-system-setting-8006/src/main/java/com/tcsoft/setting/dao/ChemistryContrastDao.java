package com.tcsoft.setting.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，通道号设置，在通讯的时候与接收、发送的通道号、设备进行对应，映射为对应的测试项目
 * @author WMY
 */
@Data
@TableName("BSC_ChemistryContrast")
@ToString
public class ChemistryContrastDao {

    @TableId(value = "HospitalID")
    private Integer hospitalId;
    @TableId(value = "TestItemID")
    private Integer testItemId;
    @TableId(value = "SampleTypeID")
    private Integer sampleTypeId;
    @TableId(value = "InstrumentID")
    private Integer instrumentId;
    @TableField(value = "ChemCode")
    private String chemCode;
    @TableField(value = "IsProgrammed")
    private boolean isProgrammed;
    @TableField(value = "IsEnabled")
    private boolean isEnabled = true;

}
