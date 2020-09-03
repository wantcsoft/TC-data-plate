package com.tcsoft.sample.entity.basic;


import lombok.Data;
import lombok.ToString;

import java.util.Date;


/**
 * @author WMY
 */
@Data
@ToString
public class OrderInfoBean {

    private Integer indexId;        	//主键	记录序号
    private Integer deviceGroupId;      //默认0	  工作组编号
    private String sampleId;		    //样本号.用于仪器交互的样本标示关键字
    private Integer pushMode;	        //默认0	  "0:不推给仪器，等待仪器Query,1:按条码号Push给仪器，2:按标本号Push给仪器. SampleID调整逻辑在Lis4Proxy.exe中已经实现"
    private String LISCode;	            //默认('')	用于区分该样本来自哪个LabBox服务器
    private Long sampleNo;              //默认0	样本流水号,LIS4专有字段.在LabBox范围内标示一个样本.
    private String SID;		            //LabBox样本号(通常位5位以内的数字)
    private String barCodeId;		    //条码号
    private String testDate;		    //测试日期 YYYY-MM-DD
    private String requestTime;		    //医嘱创建时间YYYY-MM-DD hh:mm:ss
    private String drawDate;		    //采样时间YYYY-MM-DD hh:mm:ss
    private String drawTime;		    //等价与RequestTime
    private Integer orderState;	        //医嘱所属样本的当前状态,对应LabBox的SampleState字段
    private String actionCode;	        //默认('')	行动代码A,N,C等
    private String sampleType;		    //样本类型
    private String priority;		    //诊断优先级
    private String patientId; 		    //病历号,患者标识
    private String patTypeId;		    //LabBox患者类别代码(对应住院,门诊,体检,急诊等)
    private String patientName;		    //患者姓名,可能包含以''^''分割的多个字段
    private String birthDay;	        //默认('')	YYYY-MM-DD hh:mm:ss
    private String patientAge;		    //患者年龄,一般为一个浮点数
    private String ageTypeId;		    //年龄单位(Y,M,W,D,h等)
    private String sexId;		        //性别(M,F,U,O等)
    private String location;		    //就诊科室
    private String diagnosis;		    //临床诊断信息
    private String checkerId;		    //标本核收人ID
    private Integer isManual;		    //是否手工标本(备用)
    private String diluteFactor;		//样本级自动稀释系数空或0表示不稀释;>=表示稀释
    private String xmlData;			    //复合字段,用于扩展患者信息)具体内容依照配置生成.
    private String orederNo;		    //医嘱编号=RequestID=受付番号
    private String requestDoctor;		//申请医生,可能包含以''^''分割的多个字段
    private String requestWard1;		//诊疗科,可能包含以''^''分割的多个字段
    private String requestWard2;		//病楼,可能包含以''^''分割的多个字段
    private boolean isSend;		        //是否已经发送给仪器(备用,无效)
    private Date createTime;		    //记录创建时间

}
