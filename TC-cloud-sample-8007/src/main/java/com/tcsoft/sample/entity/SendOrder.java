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
public class SendOrder {

    private String hospitalName;//医院名称
    private String hospitalCode;//医院代码
    private String location;//医院位置
    private Integer sampleNo;//样本ID
    private String sampleId;//样本条码号
    private String sampleTypeName;;//样本类型名称
    private String testTypeName;//测试类型名称
    private Integer resultStatMinutes;
    private String sampleStatusName;//样本状态名称
    private String statusFlag;//样本状态标志
    private boolean instrumentRelated = false;//是否仪器相关
    private String rackNo;//样本位置信息
    private String cupNo;//样本位置信息
    private Date collectTime;//样本采集时间
    private Integer confirmStateId;//确认状态ID
    private Integer resultErrorFlag;//结果错误标志
    private Integer checkerId;//检查人员ID
    private Integer affirmerId;//确认者ID
    private Float testFree;//
    private String patientTypeName;//病人类型名称
    private String comment;//备注信息
    private Integer patientAge;//病人年龄
    private String ageTypeName;//年龄类型名称
    private String sexTypeName;//性别类型名称
    private String diagnosis;//医嘱信息
    private Integer auditStateId;//审核状态ID
    private Boolean isUpload;//是否更新
    private Boolean isDiluted;//是否稀释
    private Integer parentSampleNo;//样本号

}
