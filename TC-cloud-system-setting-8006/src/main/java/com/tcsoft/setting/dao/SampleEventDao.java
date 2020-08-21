package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，样本的基础事件定义
 * @author WMY
 */
@Data
@ToString
@TableName("BSC_SampleEvent")
public class SampleEventDao {

    @TableId(value = "SampleEventID", type = IdType.AUTO)
    private Integer sampleEventId;

    @TableField(value = "EventDesc")
    private String eventDesc;

    @TableField(value = "EventDisplay")
    private String eventDisplay;

}
