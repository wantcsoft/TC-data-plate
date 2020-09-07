package com.tcsoft.sample.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;


/**
 * 从第三方接受测试结果信息
 * @author WMY
 */
@Data
@ToString
@TableName("WOR_InfoFromThird")
public class InfoFromThird {
    /**
     * 结果信息
     */
    @TableId(value = "SampleNo")
    private Integer sampleNo;		            //样本号（平台生成，唯一）
    @TableField(value = "TestItemCode")
    private String testItemCode;                // 测试样本代码
    @TableField(value = "ResultTxt")
    private String resultTxt;                   // 测试结果
    @TableField(value = "ResultNumeric")
    private Float resultNumeric;                // 测试数据
    @TableField(value = "RerunTimes")
    private Integer rerunTimes;                 //重做次数
    @TableField(value = "InstrumentName")
    private String instrumentName;              //仪器名称
    @TableField(value = "TestTime")
    private Date testTime;                      //测试时间
    @TableField(value = "ReagentSerialNo")
    private String reagentSerialNo;             //试剂序列
    @TableField(value = "ReagentLotNo")
    private String reagentLotNo;                //试剂批次号
    @TableField(value = "ChemCode")
    private String chemCode;                    //该项目的通道号
    @TableField(value = "DiluteFactor")
    private Float diluteFactor;                 // 稀释因子
    @TableField(value = "ResultRangeId")
    private Integer resultRangeId;              //结果范围配置ID
    @TableField(value = "IsMerged")
    private Boolean isMerged;                   //是否合并
    @TableField(value = "CalculatedResult")
    private String calculatedResult;            // 计算结果
    @TableField(value = "ResultTypeName")
    private String resultTypeName;	            //结果类别名称
    @TableField(value = "ResultUnit")
    private String resultUnit;                  //测试结果的单位
    @TableField(value = "ErrorInfo")
    private String errorInfo;                   // 错误信息

}
