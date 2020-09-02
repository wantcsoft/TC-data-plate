package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，质控品批次设置
 * @author WMY
 */
@Data
@TableName("QC_LotSet")
@ToString
public class LotSetDao {

    @TableId(value = "LotSetID", type = IdType.AUTO)
    private Integer lotSetId;
    @TableField(value = "MaterialID")
    private Integer materialId;
    @TableField(value = "HospitalID")
    private Integer hospitalId;
    @TableField(value = "LotSetName")
    private String lotSetName;
    @TableField(value = "LevelCount")
    private Integer levelCount;
    @TableField(value = "Level1Code")
    private String level1Code;
    @TableField(value = "Level2Code")
    private String level2Code;
    @TableField(value = "Level3Code")
    private String level3Code;
    @TableField(value = "IsActive")
    private boolean isActive;

}
