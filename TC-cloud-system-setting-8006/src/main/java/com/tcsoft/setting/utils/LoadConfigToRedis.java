package com.tcsoft.setting.utils;

import com.tcsoft.setting.service.impl.*;
import com.tcsoft.setting.viewmodel.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WMY
 */
//@Component
@Slf4j
public class LoadConfigToRedis {

    @Resource
    private RedisUtil redisUtil;
    private List<Integer> hospitalIdList;

    //与其他配置无关，与医院也无关
    @Resource
    private AuditStateServiceImpl auditStateService;
    @Resource
    private ComparisonTypeServiceImpl comparisonTypeService;
    @Resource
    private ConfirmStateServiceImpl confirmStateService;
    @Resource
    private DataTypeServiceImpl dataTypeService;
    @Resource
    private HospitalInfoServiceImpl hospitalInfoService;
    @Resource
    private InstrumentAlternateTypeServiceImpl instrumentAlternateTypeService;
    @Resource
    private LineTypeServiceImpl lineTypeService;
    @Resource
    private ResultTypeServiceImpl resultTypeService;
    @Resource
    private RuleTypeServiceImpl ruleTypeService;
    @Resource
    private SampleEventServiceImpl sampleEventService;
    @Resource
    private SampleStateServiceImpl sampleStateService;
    @Resource
    private SexTypeServiceImpl sexTypeService;
    @Resource
    private SampleStatusServiceImpl sampleStatusService;
    //与其他配置有关但与医院无关
    @Resource
    private RuleFunctionServiceImpl ruleFunctionService;
    @Resource
    private RuleParamServiceImpl ruleParamService;
    //与其他配置无关，仅与医院有关
    @Resource
    private ActionCodeServiceImpl actionCodeService;
    @Resource
    private AgeTypeServiceImpl ageTypeService;
    @Resource
    private InstrumentGroupServiceImpl instrumentGroupService;
    private InstrumentTypeServiceImpl instrumentTypeService;
    private PatientTypeServiceImpl patientTypeService;
    private PrepLinkAbortCodeServiceImpl prepLinkAbortCodeService;
    private PrepLinkErrorCodeServiceImpl prepLinkErrorCodeService;
    private ResultRangeServiceImpl resultRangeService;




    public LoadConfigToRedis() {
        configLoadProxy();
    }

    public void configLoadProxy(){
        loadAuditState();
        loadComparisonType();
        loadConfirmState();
        loadDataType();
        loadHospitalInfo();
        loadInstrumentAlternateType();
        loadLineType();
        loadResultType();
        loadRuleType();
        loadSampleEvent();
        loadSampleState();
        loadSexType();
        loadSampleStatus();
        loadRuleFunction();
        loadRuleParam();

        loadActionCode();
        loadAgeType();

    }

//    ========================================与他任何配置项不关联=======================================

    /**
     * 加载AudiState到redis
     * @return
     */
    private void loadAuditState(){
        List<AuditStateViewModel> list = auditStateService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (AuditStateViewModel auditState:list) {
            map.put(auditState.getAuditStateId().toString(), auditState);
        }
        try {
            redisUtil.hmset("AuditState", map);
            log.info("AuditState load success ");
        }catch (Exception e){
            log.error("AuditState load fail " + e);
        }
    }

    /**
     * 加载ComparisonType到redis
     * @param
     */
    private void loadComparisonType(){
        List<ComparisonTypeViewModel> list = comparisonTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (ComparisonTypeViewModel comparisonType:list) {
            map.put(comparisonType.getComparisonTypeId().toString(), comparisonType);
        }
        try {
            redisUtil.hmset("ConfirmState", map);
            log.info("comparisonType load success ");
        }catch (Exception e){
            log.error("comparisonType load fail " + e);
        }
    }

    /**
     * 加载ConfirmState到redis
     * @param
     */
    private void loadConfirmState(){
        List<ConfirmStateViewModel> list = confirmStateService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (ConfirmStateViewModel confirmState:list) {
            map.put(confirmState.getConfirmStateId().toString(), confirmState);
        }
        try {
            redisUtil.hmset("ConfirmState", map);
            log.info("ConfirmState load success ");
        }catch (Exception e){
            log.error("ConfirmState load fail " + e);
        }
    }

    /**
     * 加载DataType到redis
     * @param
     */
    private void loadDataType(){
        List<DataTypeViewModel> list = dataTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (DataTypeViewModel dataType:list) {
            map.put(dataType.getDataTypeId().toString(), dataType);
        }
        try {
            redisUtil.hmset("DataType", map);
            log.info("DataType load success ");
        }catch (Exception e){
            log.error("DataType load fail " + e);
        }
    }

    /**
     * 加载HospitalInfo到redis
     * @param
     */
    private void loadHospitalInfo(){
        List<HospitalInfoViewModel> list = hospitalInfoService.listViewMode();
        //先清空hospitalIdList列表
        hospitalIdList.clear();
        Map<String, Object> map = new HashMap<>(list.size());
        for (HospitalInfoViewModel hospitalInfo:list) {
            map.put(hospitalInfo.getHospitalId().toString(), hospitalInfo);
            hospitalIdList.add(hospitalInfo.getHospitalId());
        }
        try {
            redisUtil.hmset("HospitalInfo", map);
            log.info("HospitalInfo load success ");
        }catch (Exception e){
            log.error("HospitalInfo load fail " + e);
        }
    }

    /**
     * 加载InstrumentAlternateType到redis
     * @param
     */
    private void loadInstrumentAlternateType(){
        List<InstrumentAlternateTypeViewModel> list = instrumentAlternateTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (InstrumentAlternateTypeViewModel instrumentAlternateType:list) {
            map.put(instrumentAlternateType.getInstrumentAlternateTypeId().toString(), instrumentAlternateType);
        }
        try {
            redisUtil.hmset("InstrumentAlternateType", map);
            log.info("InstrumentAlternateType load success ");
        }catch (Exception e){
            log.error("InstrumentAlternateType load fail " + e);
        }
    }

    /**
     * 加载LineType到redis
     * @param
     */
    private void loadLineType(){
        List<LineTypeViewModel> list = lineTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (LineTypeViewModel lineType:list) {
            map.put(lineType.getLineTypeId().toString(), lineType);
        }
        try {
            redisUtil.hmset("LineType", map);
            log.info("LineType load success ");
        }catch (Exception e){
            log.error("LineType load fail " + e);
        }
    }

    /**
     * 加载ResultType到redis
     * @param
     */
    private void loadResultType(){
        List<ResultTypeViewModel> list = resultTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (ResultTypeViewModel resultType:list) {
            map.put(resultType.getResultTypeId().toString(), resultType);
        }
        try {
            redisUtil.hmset("ResultType", map);
            log.info("ResultType load success ");
        }catch (Exception e){
            log.error("ResultType load fail " + e);
        }
    }

    /**
     * 加载RuleType到redis
     * @param
     */
    private void loadRuleType(){
        List<RuleTypeViewModel> list = ruleTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (RuleTypeViewModel ruleType:list) {
            map.put(ruleType.getRuleTypeId().toString(), ruleType);
        }
        try {
            redisUtil.hmset("RuleType", map);
            log.info("RuleType load success ");
        }catch (Exception e){
            log.error("RuleType load fail " + e);
        }
    }

    /**
     * 加载SampleEvent到redis
     * @param
     */
    private void loadSampleEvent(){
        List<SampleEventViewModel> list = sampleEventService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (SampleEventViewModel sampleEvent:list) {
            map.put(sampleEvent.getSampleEventId().toString(), sampleEvent);
        }
        try {
            redisUtil.hmset("SampleEvent", map);
            log.info("SampleEvent load success ");
        }catch (Exception e){
            log.error("SampleEvent load fail " + e);
        }
    }

    /**
     * 加载SampleState到redis
     * @param
     */
    private void loadSampleState(){
        List<SampleStateViewModel> list = sampleStateService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (SampleStateViewModel sampleState:list) {
            map.put(sampleState.getSampleStateId().toString(), sampleState);
        }
        try {
            redisUtil.hmset("SampleState", map);
            log.info("SampleState load success ");
        }catch (Exception e){
            log.error("SampleState load fail " + e);
        }
    }

    /**
     * 加载SampleStatus到redis
     * @param
     */
    private void loadSampleStatus(){
        List<SampleStatusViewModel> list = sampleStatusService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (SampleStatusViewModel sampleStatus:list) {
            map.put(sampleStatus.getSampleStatusId().toString(), sampleStatus);
        }
        try {
            redisUtil.hmset("SampleStatus", map);
            log.info("SampleStatus load success ");
        }catch (Exception e){
            log.error("SampleStatus load fail " + e);
        }
    }

    /**
     * 加载SexType到redis
     * @param
     */
    private void loadSexType(){
        List<SexTypeViewModel> list = sexTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (SexTypeViewModel sexType:list) {
            map.put(sexType.getSexTypeId().toString(), sexType);
        }
        try {
            redisUtil.hmset("SexType", map);
            log.info("SexType load success ");
        }catch (Exception e){
            log.error("SexType load fail " + e);
        }
    }

//    ========================================与医院无关但是与其他配置有关==================================

    /**
     * 加载RuleFunction到redis
     * @param
     */
    private void loadRuleFunction(){
        List<RuleFunctionViewModel> list = ruleFunctionService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (RuleFunctionViewModel ruleFunction:list) {
            map.put(ruleFunction.getRuleFunctionId().toString(), ruleFunction);
        }
        try {
            redisUtil.hmset("RuleFunction", map);
            log.info("RuleFunction load success ");
        }catch (Exception e){
            log.error("RuleFunction load fail " + e);
        }
    }

    /**
     * 加载RuleParam到redis
     * @param
     */
    private void loadRuleParam(){
        List<RuleParamViewModel> list = ruleParamService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        for (RuleParamViewModel ruleParam:list) {
            map.put(ruleParam.getRuleParamId().toString(), ruleParam);
        }
        try {
            redisUtil.hmset("RuleParam", map);
            log.info("RuleParam load success ");
        }catch (Exception e){
            log.error("RuleParam load fail " + e);
        }
    }

//    =========================================仅与医院有关的配置=========================================

    /**
     * 加载ActionCode到redis
     * @param
     */
    private void loadActionCode(){
        for (int hospitalId:hospitalIdList){
            List<ActionCodeViewModel> list = actionCodeService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            for (ActionCodeViewModel actionCode:list) {
                map.put(actionCode.getActionId().toString(), actionCode);
            }
            try {
                redisUtil.hmset("ActionCode:"+hospitalId, map);
                log.info("ActionCode load success ");
            }catch (Exception e){
                log.error("ActionCode load fail " + e);
            }
        }
    }

    /**
     * 加载AgeType到redis
     * @param
     */
    private void loadAgeType(){
        for (int hospitalId:hospitalIdList){
            List<AgeTypeViewModel> list = ageTypeService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            for (AgeTypeViewModel ageType:list) {
                map.put(ageType.getAgeTypeId().toString(), ageType);
            }
            try {
                redisUtil.hmset("AgeType:"+hospitalId, map);
                log.info("AgeType load success ");
            }catch (Exception e){
                log.error("AgeType load fail " + e);
            }
        }
    }

    /**
     * 加载InstrumentGroup到redis
     * @param
     */
    private void loadInstrumentGroup(){
        for (int hospitalId:hospitalIdList){
            List<InstrumentGroupViewModel> list = instrumentGroupService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            for (InstrumentGroupViewModel instrumentGroup:list) {
                map.put(instrumentGroup.getInstrumentGroupId().toString(), instrumentGroup);
            }
            try {
                redisUtil.hmset("InstrumentGroup:"+hospitalId, map);
                log.info("InstrumentGroup load success ");
            }catch (Exception e){
                log.error("InstrumentGroup load fail " + e);
            }
        }
    }

    /**
     * 加载InstrumentType到redis
     * @param
     */
    private void loadInstrumentType(){
        for (int hospitalId:hospitalIdList){
            List<InstrumentTypeViewModel> list = instrumentTypeService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            for (InstrumentTypeViewModel instrumentType:list) {
                map.put(instrumentType.getInstrumentTypeId().toString(), instrumentType);
            }
            try {
                redisUtil.hmset("InstrumentType:"+hospitalId, map);
                log.info("InstrumentType load success ");
            }catch (Exception e){
                log.error("InstrumentType load fail " + e);
            }
        }
    }

    /**
     * 加载PatientType到redis
     * @param
     */
    private void loadPatientType(){
        for (int hospitalId:hospitalIdList){
            List<PatientTypeViewModel> list = patientTypeService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            for (PatientTypeViewModel patientType:list) {
                map.put(patientType.getPatientTypeId().toString(), patientType);
            }
            try {
                redisUtil.hmset("PatientType:"+hospitalId, map);
                log.info("PatientType load success ");
            }catch (Exception e){
                log.error("PatientType load fail " + e);
            }
        }
    }

    /**
     * 加载PrepLinkAbortCode到redis
     * @param
     */
    private void loadPrepLinkAbortCode(){
        for (int hospitalId:hospitalIdList){
            List<PrepLinkAbortCodeViewModel> list = prepLinkAbortCodeService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            for (PrepLinkAbortCodeViewModel prepLinkAbortCode:list) {
                map.put(prepLinkAbortCode.getAbortId().toString(), prepLinkAbortCode);
            }
            try {
                redisUtil.hmset("PrepLinkAbortCode:"+hospitalId, map);
                log.info("PrepLinkAbortCode load success ");
            }catch (Exception e){
                log.error("PrepLinkAbortCode load fail " + e);
            }
        }
    }

    /**
     * 加载PrepLinkErrorCode到redis
     * @param
     */
    private void loadPrepLinkErrorCode(){
        for (int hospitalId:hospitalIdList){
            List<PrepLinkErrorCodeViewModel> list = prepLinkErrorCodeService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            for (PrepLinkErrorCodeViewModel prepLinkErrorCode:list) {
                map.put(prepLinkErrorCode.getErrorId().toString(), prepLinkErrorCode);
            }
            try {
                redisUtil.hmset("PrepLinkErrorCode:"+hospitalId, map);
                log.info("PrepLinkErrorCode load success ");
            }catch (Exception e){
                log.error("PrepLinkErrorCode load fail " + e);
            }
        }
    }

    /**
     * 加载ResultRange到redis
     * @param
     */
    private void loadResultRange(){
        for (int hospitalId:hospitalIdList){
            List<ResultRangeViewModel> list = resultRangeService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            for (ResultRangeViewModel resultRange:list) {
                map.put(resultRange.getResultRangeId().toString(), resultRange);
            }
            try {
                redisUtil.hmset("ResultRange:"+hospitalId, map);
                log.info("ResultRange load success ");
            }catch (Exception e){
                log.error("ResultRange load fail " + e);
            }
        }
    }






}
