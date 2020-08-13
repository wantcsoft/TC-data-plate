package com.tcsoft.sample.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("WOR_Result")
public class ResultDao implements Serializable {

    @TableId(value = "SampleNo")
    private Integer sampleNo;

    @TableId("TestItemID")
    private Integer testItemId;

    @TableField("ResultTxt")
    private String resultTxt;

    @TableField("ResultNumeric")
    private Float resultNumeric;

    @TableField("RerunTimes")
    private Integer rerunTimes;

    @TableField("ConfirmStateID")
    private Integer confirmStateId;

    @TableField("InstrumentID")
    private Integer instrumentId;

    @TableField("TestTime")
    private Date testTime;

    @TableField("ReagentSerialNo")
    private String reagentSerialNo;

    @TableField("ReagentLotNo")
    private String reagentLotNo;

    @TableField("ChemCode")
    private String chemCode;

    @TableField("AuditStateID")
    private Integer auditStateId;

    @TableField("ErrorInfo")
    private String errorInfo;

    @TableField("IsUpload")
    private Boolean isUpload;

    @TableField("DiluteFactor")
    private Float diluteFactor;

    @TableField("ResultRangeID")
    private Integer resultRangeId;

    @TableField("IsOrdac")
    private Boolean isOrdac;

    @TableField("IsMerged")
    private Boolean isMerged;

    @TableField("CalculatedResult")
    private String calculatedResult;

    @TableField("ReplicateNo")
    private Integer replicateNo;

    @TableField("UnitID")
    private Integer unitId;


}
