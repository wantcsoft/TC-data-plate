package com.tcsoft.sample.entity;

import com.tcsoft.sample.entity.basic.ResultsInfoBean;
import com.tcsoft.sample.entity.basic.SampleInfoBean;
import lombok.Data;
import lombok.ToString;

import java.util.Date;


/**
 * 从第三方接受测试结果信息
 * @author WMY
 */
@Data
@ToString
public class ResultFromThird {

    private Integer sampleNo;		            //样本号（平台生成，唯一）
    private String sampleTypeName;              //样本类型名称
    private String testItemName;                // 样本测试名称
    private String resultTxt;                   // 测试结果
    private Float resultNumeric;                // 测试数据
    private Integer resultTypeName;	            //结果类别名称
    private String resultUnit;                  //测试结果的单位
    private String errorInfo;                   // 错误信息
    private Float diluteFactor;                 // 稀释因子
    private String calculatedResult;            // 计算结果

    private Date testTime;// 测试时间

}
