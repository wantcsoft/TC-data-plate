package com.tcsoft.sample.entity;


import com.tcsoft.sample.dao.ResultDao;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author WMY
 */
@Data
@ToString
public class ReceiveTest {
    //sample 参数
    private Integer hospitalId;
    private Integer sampleNo;
    private String sampleId;
    private Integer sampleTypeId;
    private Integer testTypeId;
    private Integer sampleStatusId;
    private String rackNo;
    private Date collectTime;
    private String cupNo;
    private Integer confirmStateId;
    private Integer resultErrorFlag;
    private Integer checkerId;
    private Integer affirmerId;
    private Float testFree;
    private String patientCardNo;
    private String outInPatientId;
    private String patientBedNo;
    private Integer patientTypeId;
    private String patientName;
    private Integer patientAge;
    private Integer ageTypeId;
    private Integer sexTypeId;
    private String diagnosis;
    private Integer auditStateId;
    private Boolean isUpload;
    private Boolean isDiluted;
    private Integer parentSampleNo;

    private List<ResultDao> resultDaoList;

    //result参数
//    private Integer sampleNo;
//    private Integer testItemId;
//    private String resultTxt;
//    private Float resultNumeric;
//    private Integer rerunTimes;
//    //    private Integer confirmStateId;
//    private Integer instrumentId;
//    private Date testTime;
//    private String reagentSerialNo;
//    private String reagentLotNo;
//    private String chemCode;
//    //    private Integer auditStateId;
//    private String errorInfo;
//    //    private Boolean isUpload;
//    private Float diluteFactor;
//    private Integer resultRangeId;
//    private Boolean isOrdac;
//    private Boolean isMerged;
//    private String calculatedResult;
//    private Integer replicateNo;
//    private Integer unitId;

}
