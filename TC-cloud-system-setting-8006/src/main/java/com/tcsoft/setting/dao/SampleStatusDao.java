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
@TableName("BSC_SampleStatus")
public class SampleStatusDao {

    @TableId(value = "SampleStatusID", type = IdType.AUTO)
    private Integer sampleStatusId;

    @TableField(value = "SampleStatusName")
    private String sampleStatusName;

    @TableField(value = "StatusFlag")
    private String statusFlag;

    @TableField(value = "ParentStatusID")
    private Integer parentStatusId;

    @TableField(value = "InstrumentRelated")
    private boolean instrumentRelated;

}
