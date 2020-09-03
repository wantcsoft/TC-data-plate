package com.tcsoft.sample.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author WMY
 * @since 2020-08-10
 */
@Data
@TableName("WOR_ProgItem")
public class ProgItemDao implements Serializable {

    @TableField("SampleNo")
    private Integer sampleNo;

    @TableField("TestItemID")
    private Integer testItemId;

    @TableField("ReplicateTimes")
    private Integer replicateTimes;

    @TableField("IsTested")
    private Boolean isTested;

    @TableField("ProgTime")
    private Date progTime;

    @TableField("ProgSendTime")
    private Date progSendTime;

    @TableField("OrdacTimes")
    private Integer ordacTimes;

    @TableField("RerunTimes")
    private Integer rerunTimes;

    @TableField("ReflexTimes")
    private Integer reflexTimes;

    @TableField("IsAliquot")
    private Boolean isAliquot;

    @TableField("SendFlag")
    private String sendFlag;

}
