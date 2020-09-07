package com.tcsoft.sample.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author WMY
 */
@Data
@ToString
public class InfoToLis {

    private String hospitalCode;                //医院代码
    /**
     * 样本信息
     */
    private String sampleId;                    //样本条码号
    private Integer sampleNo;		            //样本号（平台生成，唯一）
    /**
     * 结果信息
     */
    private String testItemCode;                // 测试样本代码
    private String resultTxt;                   // 测试结果
    private Float resultNumeric;                // 测试数据
    private Integer rerunTimes;                 //重做次数
    private Integer instrumentName;             //仪器ID
    private Date testTime;                      //测试时间
    private String reagentSerialNo;             //试剂序列
    private String reagentLotNo;                //试剂批次号
    private String chemCode;                    //该项目的通道号
    private Float diluteFactor;                 // 稀释因子
    private Integer resultRangeId;              //结果范围配置ID
    private Boolean isMerged;                   //是否合并
    private String calculatedResult;            // 计算结果
    private Integer resultTypeName;	            //结果类别名称
    private String resultUnit;                  //测试结果的单位
    private String errorInfo;                   // 错误信息

}
