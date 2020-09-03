package com.tcsoft.sample.entity;

import com.tcsoft.sample.entity.basic.*;
import lombok.Data;
import lombok.ToString;



/**
 * 将医嘱信息下发给第三方
 * @author WMY
 */
@Data
@ToString
public class OrderToThird {

    private Integer indexId;                    //唯一ID
    private String sampleId;                    //样本号
    private String actionCode;                  //本医嘱对应的行动代码:NARC.
    private SampleInfoBean sampleInfoBean;      //XML   样本信息
    private PatientInfoBean patInfo;            //XML   患者信息
    private OrderInfoBean orderCC;              //XML   医嘱项目信息
    private AliquotInfoBean aliquotInfo;        //XML   分杯信息
    private ResultsInfoBean results;            //XML   结果信息

}
