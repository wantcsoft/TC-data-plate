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
@TableName("BSC_SampleEvent")
public class SampleEventDao {

    @TableId(value = "SampleEventID", type = IdType.AUTO)
    private Integer sampleEventId;

    @TableField(value = "EventDesc")
    private String eventDesc;

    @TableField(value = "EventDisplay")
    private String eventDisplay;

}
