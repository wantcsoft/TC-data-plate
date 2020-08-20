package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 基础配置信息，质控品设置
 * @author WMY
 */
@Data
@TableName("QC_Material")
@ToString
public class MaterialDao {

    @TableId(value = "MaterialID", type = IdType.AUTO)
    private Integer materialId;
    @TableField(value = "HospitalID")
    private Integer hospitalId;
    @TableField(value = "MaterialName")
    private String materialName;
    @TableField(value = "SampleTypeID")
    private Integer sampleTypeId;
    @TableField(value = "PeriodStart")
    private Date periodStart;
    @TableField(value = "PeriodEnd")
    private Date periodEnd;
    @TableField(value = "IsActive")
    private boolean isActive;

}
