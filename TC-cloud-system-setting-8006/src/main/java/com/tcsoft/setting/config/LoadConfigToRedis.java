package com.tcsoft.setting.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcsoft.setting.service.impl.*;
import com.tcsoft.setting.utils.RedisUtil;
import com.tcsoft.setting.viewmodel.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将所有的配置项加载到redis数据库中
 * @author WMY
 */
@Slf4j
@Component
public class LoadConfigToRedis {

    @Resource
    private RedisUtil redisUtil;
    private List<Integer> hospitalIdList = new ArrayList<>();

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
    @Resource
    private InstrumentTypeServiceImpl instrumentTypeService;
    @Resource
    private PatientTypeServiceImpl patientTypeService;
    @Resource
    private PrepLinkAbortCodeServiceImpl prepLinkAbortCodeService;
    @Resource
    private PrepLinkErrorCodeServiceImpl prepLinkErrorCodeService;
    @Resource
    private ResultRangeServiceImpl resultRangeService;
    @Resource
    private ResultUnitServiceImpl resultUnitService;
    @Resource
    private RuleGroupServiceImpl ruleGroupService;
    @Resource
    private SampleTypeServiceImpl sampleTypeService;
    @Resource
    private TestItemTypeServiceImpl testItemTypeService;
    @Resource
    private TestTypeServiceImpl testTypeService;
    @Resource
    private ChemistryContrastServiceImpl chemistryContrastService;
    @Resource
    private ComparisonInfoServiceImpl comparisonInfoService;
    @Resource
    private InstrumentServiceImpl instrumentService;
    @Resource
    private LotSetServiceImpl lotSetService;
    @Resource
    private MaterialServiceImpl materialService;
    @Resource
    private RuleServiceImpl ruleService;
    @Resource
    private TestItemDeltaCheckServiceImpl testItemDeltaCheckService;
    @Resource
    private TestItemGroupServiceImpl testItemGroupService;
    @Resource
    private TestItemGroupItemServiceImpl testItemGroupItemService;
    @Resource
    private TestItemInfoServiceImpl testItemInfoService;

    public void start(){
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
        loadInstrumentGroup();
        loadInstrumentType();
        loadPatientType();
        loadPrepLinkAbortCode();
        loadPrepLinkErrorCode();
        loadResultRange();
        loadResultUnit();
        loadRuleGroup();
        loadSampleType();
        loadTestItemType();
        loadTestType();
        loadChemistryContrast();
        loadComparisonInfo();
        loadInstrument();
        loadLotSet();
        loadMaterial();
        loadRule();
        loadTestItemDeltaCheck();
        loadTestItemGroup();
        loadTestItemGroupItem();
        loadTestItemInfo();
    }

//    ========================================与他任何配置项不关联=======================================

    /**
     * 加载AudiState到redis
     * @return
     */
    private void loadAuditState(){
        List<AuditStateViewModel> list = auditStateService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (AuditStateViewModel auditState:list) {
            try {
                String value = om.writeValueAsString(auditState);
                map.put("auditStateId="+auditState.getAuditStateId(), value);
            }catch (Exception e){
                log.error("auditState序列化失败");
            }
        }
        try {
            redisUtil.hmset("AuditState", map);
            log.info("AuditState 加载成功 ");
        }catch (Exception e){
            log.error("AuditState 加载失败 " + e);
        }
    }

    /**
     * 加载ComparisonType到redis
     * @param
     */
    private void loadComparisonType(){
        List<ComparisonTypeViewModel> list = comparisonTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (ComparisonTypeViewModel comparisonType:list) {
            try {
                String value = om.writeValueAsString(comparisonType);
                map.put("comparisonTypeId="+comparisonType.getComparisonTypeId(), value);
            }catch (Exception e){
                log.error("ComparisonType序列化失败");
            }
        }
        try {
            redisUtil.hmset("ComparisonType", map);
            log.info("comparisonType 加载成功 ");
        }catch (Exception e){
            log.error("comparisonType 加载失败 " + e);
        }
    }

    /**
     * 加载ConfirmState到redis
     * @param
     */
    private void loadConfirmState(){
        List<ConfirmStateViewModel> list = confirmStateService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (ConfirmStateViewModel confirmState:list) {
            try {
                String value = om.writeValueAsString(confirmState);
                map.put("confirmStateId="+confirmState.getConfirmStateId(), value);
            }catch (Exception e){
                log.error("ConfirmState序列化失败");
            }
        }
        try {
            redisUtil.hmset("ConfirmState", map);
            log.info("ConfirmState 加载成功 ");
        }catch (Exception e){
            log.error("ConfirmState 加载失败 " + e);
        }
    }

    /**
     * 加载DataType到redis
     * @param
     */
    private void loadDataType(){
        List<DataTypeViewModel> list = dataTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (DataTypeViewModel dataType:list) {
            try {
                String value = om.writeValueAsString(dataType);
                map.put("dataTypeId="+dataType.getDataTypeId(), value);
            }catch (Exception e){
                log.error("DataType序列化失败");
            }
        }
        try {
            redisUtil.hmset("DataType", map);
            log.info("DataType 加载成功 ");
        }catch (Exception e){
            log.error("DataType 加载失败 " + e);
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
        Map<String, Object> hospitalIdMap = new HashMap<>(list.size());
        Map<String, Object> hospitalCodeMap = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (HospitalInfoViewModel hospitalInfo:list) {
            hospitalIdList.add(hospitalInfo.getHospitalId());
            try {
                String value = om.writeValueAsString(hospitalInfo);
                hospitalIdMap.put("hospitalId="+hospitalInfo.getHospitalId(), value);
                hospitalCodeMap.put("hospitalCode="+hospitalInfo.getHospitalCode(), value);
            }catch (Exception e){
                log.error("HospitalInfo序列化失败");
            }
        }
        try {
            redisUtil.hmset("HospitalInfo:hospitalId", hospitalIdMap);
            redisUtil.hmset("HospitalInfo:hospitalCode", hospitalCodeMap);
            log.info("HospitalInfo 加载成功 ");
        }catch (Exception e){
            log.error("HospitalInfo 加载失败 " + e);
        }
    }

    /**
     * 加载InstrumentAlternateType到redis
     * @param
     */
    private void loadInstrumentAlternateType(){
        List<InstrumentAlternateTypeViewModel> list = instrumentAlternateTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (InstrumentAlternateTypeViewModel instrumentAlternateType:list) {
            try {
                String value = om.writeValueAsString(instrumentAlternateType);
                map.put("instrumentAlternateTypeId="+instrumentAlternateType.getInstrumentAlternateTypeId(), value);
            }catch (Exception e){
                log.error("InstrumentAlternateType序列化失败");
            }
        }
        try {
            redisUtil.hmset("InstrumentAlternateType", map);
            log.info("InstrumentAlternateType 加载成功 ");
        }catch (Exception e){
            log.error("InstrumentAlternateType 加载失败 " + e);
        }
    }

    /**
     * 加载LineType到redis
     * @param
     */
    private void loadLineType(){
        List<LineTypeViewModel> list = lineTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (LineTypeViewModel lineType:list) {
            try {
                String value = om.writeValueAsString(lineType);
                map.put("lineTypeId="+lineType.getLineTypeId(), value);
            }catch (Exception e){
                log.error("LineType 序列化失败");
            }
        }
        try {
            redisUtil.hmset("LineType", map);
            log.info("LineType 加载成功 ");
        }catch (Exception e){
            log.error("LineType 加载失败 " + e);
        }
    }

    /**
     * 加载ResultType到redis
     * @param
     */
    private void loadResultType(){
        List<ResultTypeViewModel> list = resultTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (ResultTypeViewModel resultType:list) {
            try {
                String value = om.writeValueAsString(resultType);
                map.put("ResultTypeId="+resultType.getResultTypeId(), value);
            }catch (Exception e){
                log.error("ResultType 序列化失败");
            }
        }
        try {
            redisUtil.hmset("ResultType", map);
            log.info("ResultType 加载成功 ");
        }catch (Exception e){
            log.error("ResultType 加载失败 " + e);
        }
    }

    /**
     * 加载RuleType到redis
     * @param
     */
    private void loadRuleType(){
        List<RuleTypeViewModel> list = ruleTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (RuleTypeViewModel ruleType:list) {
            try {
                String value = om.writeValueAsString(ruleType);
                map.put("ruleTypeId="+ruleType.getRuleTypeId(), value);
            }catch (Exception e){
                log.error("RuleType 序列化失败");
            }
        }
        try {
            redisUtil.hmset("RuleType", map);
            log.info("RuleType 加载成功 ");
        }catch (Exception e){
            log.error("RuleType 加载失败 " + e);
        }
    }

    /**
     * 加载SampleEvent到redis
     * @param
     */
    private void loadSampleEvent(){
        List<SampleEventViewModel> list = sampleEventService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (SampleEventViewModel sampleEvent:list) {
            try {
                String value = om.writeValueAsString(sampleEvent);
                map.put("sampleEventId="+sampleEvent.getSampleEventId(), value);
            }catch (Exception e){
                log.error("SampleEvent 序列化失败");
            }
        }
        try {
            redisUtil.hmset("SampleEvent", map);
            log.info("SampleEvent 加载成功 ");
        }catch (Exception e){
            log.error("SampleEvent 加载失败 " + e);
        }
    }

    /**
     * 加载SampleState到redis
     * @param
     */
    private void loadSampleState(){
        List<SampleStateViewModel> list = sampleStateService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (SampleStateViewModel sampleState:list) {
            try {
                String value = om.writeValueAsString(sampleState);
                map.put("sampleStateId="+sampleState.getSampleStateId(), value);
            }catch (Exception e){
                log.error("SampleState 序列化失败");
            }
        }
        try {
            redisUtil.hmset("SampleState", map);
            log.info("SampleState 加载成功 ");
        }catch (Exception e){
            log.error("SampleState 加载失败 " + e);
        }
    }

    /**
     * 加载SampleStatus到redis
     * @param
     */
    private void loadSampleStatus(){
        List<SampleStatusViewModel> list = sampleStatusService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (SampleStatusViewModel sampleStatus:list) {
            try {
                String value = om.writeValueAsString(sampleStatus);
                map.put("sampleStatusId="+sampleStatus.getSampleStatusId(), value);
            }catch (Exception e){
                log.error("SampleStatus 序列化失败");
            }
        }
        try {
            redisUtil.hmset("SampleStatus", map);
            log.info("SampleStatus 加载成功 ");
        }catch (Exception e){
            log.error("SampleStatus 加载失败 " + e);
        }
    }

    /**
     * 加载SexType到redis
     * @param
     */
    private void loadSexType(){
        List<SexTypeViewModel> list = sexTypeService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (SexTypeViewModel sexType:list) {
            try {
                String value = om.writeValueAsString(sexType);
                map.put("sexTypeId="+sexType.getSexTypeId(), value);
            }catch (Exception e){
                log.error("SexType 序列化失败");
            }
        }
        try {
            redisUtil.hmset("SexType", map);
            log.info("SexType 加载成功 ");
        }catch (Exception e){
            log.error("SexType 加载失败 " + e);
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
        ObjectMapper om = new ObjectMapper();
        for (RuleFunctionViewModel ruleFunction:list) {
            try {
                String value = om.writeValueAsString(ruleFunction);
                map.put("ruleFunctionId="+ruleFunction.getRuleFunctionId(), value);
            }catch (Exception e){
                log.error("RuleFunction 序列化失败");
            }
        }
        try {
            redisUtil.hmset("RuleFunction", map);
            log.info("RuleFunction 加载成功 ");
        }catch (Exception e){
            log.error("RuleFunction 加载失败 " + e);
        }
    }

    /**
     * 加载RuleParam到redis
     * @param
     */
    private void loadRuleParam(){
        List<RuleParamViewModel> list = ruleParamService.listViewModel();
        Map<String, Object> map = new HashMap<>(list.size());
        ObjectMapper om = new ObjectMapper();
        for (RuleParamViewModel ruleParam:list) {
            try {
                String value = om.writeValueAsString(ruleParam);
                map.put("ruleParamId="+ruleParam.getRuleParamId(), value);
            }catch (Exception e){
                log.error("RuleParam 序列化失败");
            }
        }
        try {
            redisUtil.hmset("RuleParam", map);
            log.info("RuleParam 加载成功 ");
        }catch (Exception e){
            log.error("RuleParam 加载失败 " + e);
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
            ObjectMapper om = new ObjectMapper();
            for (ActionCodeViewModel actionCode:list) {
                try {
                    String value = om.writeValueAsString(actionCode);
                    map.put("actionCode="+actionCode.getActionId(), value);
                }catch (Exception e){
                    log.error("ActionCode 序列化失败");
                }
            }
            try {
                redisUtil.hmset("ActionCode:hospitalId="+hospitalId, map);
                log.info("ActionCode 加载成功 ");
            }catch (Exception e){
                log.error("ActionCode 加载失败 " + e);
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
            ObjectMapper om = new ObjectMapper();
            for (AgeTypeViewModel ageType:list) {
                try {
                    String value = om.writeValueAsString(ageType);
                    map.put("ageType="+ageType.getAgeTypeId(), value);
                }catch (Exception e){
                    log.error("AgeType 序列化失败");
                }
            }
            try {
                redisUtil.hmset("AgeType:hospitalId="+hospitalId, map);
                log.info("AgeType 加载成功 ");
            }catch (Exception e){
                log.error("AgeType 加载失败 " + e);
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
            ObjectMapper om = new ObjectMapper();
            for (InstrumentGroupViewModel instrumentGroup:list) {
                try {
                    String value = om.writeValueAsString(instrumentGroup);
                    map.put("instrumentGroupId="+instrumentGroup.getInstrumentGroupId(), value);
                }catch (Exception e){
                    log.error("InstrumentGroup 序列化失败");
                }
            }
            try {
                redisUtil.hmset("InstrumentGroup:hospitalId="+hospitalId, map);
                log.info("InstrumentGroup 加载成功 ");
            }catch (Exception e){
                log.error("InstrumentGroup 加载失败 " + e);
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
            ObjectMapper om = new ObjectMapper();
            for (InstrumentTypeViewModel instrumentType:list) {
                try {
                    String value = om.writeValueAsString(instrumentType);
                    map.put("instrumentTypeId="+instrumentType.getInstrumentTypeId(), value);
                }catch (Exception e){
                    log.error("InstrumentType 序列化失败");
                }
            }
            try {
                redisUtil.hmset("InstrumentType:hospitalId="+hospitalId, map);
                log.info("InstrumentType 加载成功 ");
            }catch (Exception e){
                log.error("InstrumentType 加载失败 " + e);
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
            Map<String, Object> patientTypeIdMap = new HashMap<>(list.size());
            Map<String, Object> patientTypeNameMap = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (PatientTypeViewModel patientType:list) {
                try {
                    String value = om.writeValueAsString(patientType);
                    patientTypeIdMap.put("patientTypeId="+patientType.getPatientTypeId(), value);
                    patientTypeNameMap.put("patientTypeName="+patientType.getPatientTypeName(), value);
                }catch (Exception e){
                    log.error("PatientType 序列化失败");
                }
            }
            try {
                redisUtil.hmset("PatientType:patientTypeId:hospitalId="+hospitalId, patientTypeIdMap);
                redisUtil.hmset("PatientType:patientTypeName:hospitalId="+hospitalId, patientTypeNameMap);
                log.info("PatientType 加载成功 ");
            }catch (Exception e){
                log.error("PatientType 加载失败 " + e);
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
            ObjectMapper om = new ObjectMapper();
            for (PrepLinkAbortCodeViewModel prepLinkAbortCode:list) {
                try {
                    String value = om.writeValueAsString(prepLinkAbortCode);
                    map.put("abortId="+prepLinkAbortCode.getAbortId(), value);
                }catch (Exception e){
                    log.error("PrepLinkAbortCode 序列化失败");
                }
            }
            try {
                redisUtil.hmset("PrepLinkAbortCode:hospitalId="+hospitalId, map);
                log.info("PrepLinkAbortCode 加载成功 ");
            }catch (Exception e){
                log.error("PrepLinkAbortCode 加载失败 " + e);
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
            ObjectMapper om = new ObjectMapper();
            for (PrepLinkErrorCodeViewModel prepLinkErrorCode:list) {
                try {
                    String value = om.writeValueAsString(prepLinkErrorCode);
                    map.put("errorId="+prepLinkErrorCode.getErrorId(), value);
                }catch (Exception e){
                    log.error("PrepLinkErrorCode 序列化失败");
                }
            }
            try {
                redisUtil.hmset("PrepLinkErrorCode:hospitalId="+hospitalId, map);
                log.info("PrepLinkErrorCode 加载成功 ");
            }catch (Exception e){
                log.error("PrepLinkErrorCode 加载失败 " + e);
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
            ObjectMapper om = new ObjectMapper();
            for (ResultRangeViewModel resultRange:list) {
                try {
                    String value = om.writeValueAsString(resultRange);
                    map.put("resultRange="+resultRange.getResultRangeId(), value);
                }catch (Exception e){
                    log.error("ResultRange 序列化失败");
                }
            }
            try {
                redisUtil.hmset("ResultRange:hospitalId="+hospitalId, map);
                log.info("ResultRange 加载成功 ");
            }catch (Exception e){
                log.error("ResultRange 加载失败 " + e);
            }
        }
    }

    /**
     * 加载ResultUnit到redis
     * @param
     */
    private void loadResultUnit(){
        for (int hospitalId:hospitalIdList){
            List<ResultUnitViewModel> list = resultUnitService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (ResultUnitViewModel resultUnit:list) {
                try {
                    String value = om.writeValueAsString(resultUnit);
                    map.put("resultUnitId="+resultUnit.getResultUnitId(), value);
                }catch (Exception e){
                    log.error("ResultUnit 序列化失败");
                }
            }
            try {
                redisUtil.hmset("ResultUnit:hospitalId="+hospitalId, map);
                log.info("ResultUnit 加载成功 ");
            }catch (Exception e){
                log.error("ResultUnit 加载失败 " + e);
            }
        }
    }

    /**
     * 加载RuleGroup到redis
     * @param
     */
    private void loadRuleGroup(){
        for (int hospitalId:hospitalIdList){
            List<RuleGroupViewModel> list = ruleGroupService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (RuleGroupViewModel ruleGroup:list) {
                try {
                    String value = om.writeValueAsString(ruleGroup);
                    map.put("ruleGroupId="+ruleGroup.getRuleGroupId(), value);
                }catch (Exception e){
                    log.error("RuleGroup 序列化失败");
                }
            }
            try {
                redisUtil.hmset("RuleGroup:hospitalId="+hospitalId, map);
                log.info("RuleGroup 加载成功 ");
            }catch (Exception e){
                log.error("RuleGroup 加载失败 " + e);
            }
        }
    }

    /**
     * 加载SampleType到redis
     * @param
     */
    private void loadSampleType(){
        for (int hospitalId:hospitalIdList){
            List<SampleTypeViewModel> list = sampleTypeService.listViewModel(hospitalId);
            Map<String, Object> sampleTypeIdMap = new HashMap<>(list.size());
            Map<String, Object> sampleTypeNameMap = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (SampleTypeViewModel sampleType:list) {
                try {
                    String value = om.writeValueAsString(sampleType);
                    sampleTypeIdMap.put("sampleTypeId="+sampleType.getSampleTypeId(), value);
                    sampleTypeNameMap.put("sampleTypeName="+sampleType.getSampleTypeName(), value);
                }catch (Exception e){
                    log.error("SampleType 序列化失败");
                }
            }
            try {
                redisUtil.hmset("SampleType:sampleTypeId:hospitalId="+hospitalId, sampleTypeIdMap);
                redisUtil.hmset("SampleType:sampleTypeName:hospitalId="+hospitalId, sampleTypeNameMap);
                log.info("SampleType 加载成功 ");
            }catch (Exception e){
                log.error("SampleType 加载失败 " + e);
            }
        }
    }

    /**
     * 加载TestItemType到redis
     * @param
     */
    private void loadTestItemType(){
        for (int hospitalId:hospitalIdList){
            List<TestItemTypeViewModel> list = testItemTypeService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (TestItemTypeViewModel testItemType:list) {
                try {
                    String value = om.writeValueAsString(testItemType);
                    map.put("testItemTypeId="+testItemType.getTestItemTypeId(), value);
                }catch (Exception e){
                    log.error("TestItemType 序列化失败");
                }
            }
            try {
                redisUtil.hmset("TestItemType:hospitalId="+hospitalId, map);
                log.info("TestItemType 加载成功 ");
            }catch (Exception e){
                log.error("TestItemType 加载失败 " + e);
            }
        }
    }

    /**
     * 加载TestType到redis
     * @param
     */
    private void loadTestType(){
        for (int hospitalId:hospitalIdList){
            List<TestTypeViewModel> list = testTypeService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (TestTypeViewModel testType:list) {
                try {
                    String value = om.writeValueAsString(testType);
                    map.put("testTypeId="+testType.getTestTypeId(), value);
                }catch (Exception e){
                    log.error("TestType 序列化失败");
                }
            }
            try {
                redisUtil.hmset("TestType:hospitalId="+hospitalId, map);
                log.info("TestType 加载成功 ");
            }catch (Exception e){
                log.error("TestType 加载失败 " + e);
            }
        }
    }

//    =========================================与医院有关也与其他基础配置项有关================================

    /**
     * 加载ChemistryContrast到redis
     * @param
     */
    private void loadChemistryContrast(){
        for (int hospitalId:hospitalIdList){
            List<ChemistryContrastViewModel> list = chemistryContrastService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (ChemistryContrastViewModel chemistryContrast:list) {
                try {
                    String value = om.writeValueAsString(chemistryContrast);
                    map.put("testItemId="+chemistryContrast.getTestItemId()+
                            ":sampleTypeId="+chemistryContrast.getSampleTypeId()+
                            ":instrumentId="+chemistryContrast.getInstrumentId(), value);
                }catch (Exception e){
                    log.error("ChemistryContrast 序列化失败");
                }
            }
            try {
                redisUtil.hmset("ChemistryContrast:hospitalId="+hospitalId, map);
                log.info("ChemistryContrast 加载成功 ");
            }catch (Exception e){
                log.error("ChemistryContrast 加载失败 " + e);
            }
        }
    }

    /**
     * 加载ComparisonInfo到redis
     * @param
     */
    private void loadComparisonInfo(){
        for (int hospitalId:hospitalIdList){
            List<ComparisonInfoViewModel> list = comparisonInfoService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (ComparisonInfoViewModel comparisonInfo:list) {
                try {
                    String value = om.writeValueAsString(comparisonInfo);
                    map.put("instrumentTypeId="+comparisonInfo.getInstrumentTypeId()+
                            ":comparisonTypeId="+comparisonInfo.getComparisonTypeId()+
                            ":instrumentInfo="+comparisonInfo.getInstrumentInfo(), value);
                }catch (Exception e){
                    log.error("ComparisonInfo 序列化失败");
                }

            }
            try {
                redisUtil.hmset("ComparisonInfo:hospitalId="+hospitalId, map);
                log.info("ComparisonInfo 加载成功 ");
            }catch (Exception e){
                log.error("ComparisonInfo 加载失败 " + e);
            }
        }
    }

    /**
     * 加载Instrument到redis
     * @param
     */
    private void loadInstrument(){
        for (int hospitalId:hospitalIdList){
            List<InstrumentViewModel> list = instrumentService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (InstrumentViewModel instrument:list) {
                try {
                    String value = om.writeValueAsString(instrument);
                    map.put("instrumentId="+instrument.getInstrumentId()+
                            ":instrumentGroupId="+instrument.getInstrumentGroupId()+
                            ":instrumentTypeId="+instrument.getInstrumentTypeId(), value);
                }catch (Exception e){
                    log.error("Instrument 序列化失败");
                }
            }
            try {
                redisUtil.hmset("Instrument:hospitalId="+hospitalId, map);
                log.info("Instrument 加载成功 ");
            }catch (Exception e){
                log.error("Instrument 加载失败 " + e);
            }
        }
    }

    /**
     * 加载LotSet到redis
     * @param
     */
    private void loadLotSet(){
        for (int hospitalId:hospitalIdList){
            List<LotSetViewModel> list = lotSetService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (LotSetViewModel lotSet:list) {
                try {
                    String value = om.writeValueAsString(lotSet);
                    map.put("lotSetId="+lotSet.getLotSetId(), value);
                }catch (Exception e){
                    log.error("LotSet 序列化失败");
                }
            }
            try {
                redisUtil.hmset("LotSet:hospitalId="+hospitalId, map);
                log.info("LotSet 加载成功 ");
            }catch (Exception e){
                log.error("LotSet 加载失败 " + e);
            }
        }
    }

    /**
     * 加载Material到redis
     * @param
     */
    private void loadMaterial(){
        for (int hospitalId:hospitalIdList){
            List<MaterialViewModel> list = materialService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (MaterialViewModel material:list) {
                try {
                    String value = om.writeValueAsString(material);
                    map.put("materialId="+material.getMaterialId(), value);
                }catch (Exception e){
                    log.error("Material 序列化失败");
                }
            }
            try {
                redisUtil.hmset("Material:hospitalId="+hospitalId, map);
                log.info("Material 加载成功 ");
            }catch (Exception e){
                log.error("Material 加载失败 " + e);
            }
        }
    }

    /**
     * 加载Rule到redis
     * @param
     */
    private void loadRule(){
        for (int hospitalId:hospitalIdList){
            List<RuleViewModel> list = ruleService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (RuleViewModel rule:list) {
                try {
                    String value = om.writeValueAsString(rule);
                    map.put("ruleId="+rule.getRuleId()+
                            ":ruleGroupId="+rule.getRuleGroupId()+
                            ":ruleType="+rule.getRuleTypeId(), value);
                }catch (Exception e){
                    log.error("Rule 序列化失败");
                }
            }
            try {
                redisUtil.hmset("Rule:hospitalId="+hospitalId, map);
                log.info("Rule 加载成功 ");
            }catch (Exception e){
                log.error("Rule 加载失败 " + e);
            }
        }
    }

    /**
     * 加载TestItemDeltaCheck到redis
     * @param
     */
    private void loadTestItemDeltaCheck(){
        for (int hospitalId:hospitalIdList){
            List<TestItemDeltaCheckViewModel> list = testItemDeltaCheckService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (TestItemDeltaCheckViewModel testItemDeltaCheck:list) {
                try {
                    String value = om.writeValueAsString(testItemDeltaCheck);
                    map.put("TestItemId="+testItemDeltaCheck.getTestItemId(), value);
                }catch (Exception e){
                    log.error("TestItemDeltaCheck 序列化失败");
                }
            }
            try {
                redisUtil.hmset("TestItemDeltaCheck:hospitalId="+hospitalId, map);
                log.info("TestItemDeltaCheck 加载成功 ");
            }catch (Exception e){
                log.error("TestItemDeltaCheck 加载失败 " + e);
            }
        }
    }

    /**
     * 加载TestItemGroup到redis
     * @param
     */
    private void loadTestItemGroup(){
        for (int hospitalId:hospitalIdList){
            List<TestItemGroupViewModel> list = testItemGroupService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (TestItemGroupViewModel testItemGroup:list) {
                try {
                    String value = om.writeValueAsString(testItemGroup);
                    map.put("TestItemGroupId="+testItemGroup.getTestItemGroupId(), value);
                }catch (Exception e){
                    log.error("TestItemGroup 序列化失败");
                }
            }
            try {
                redisUtil.hmset("TestItemGroup:hospitalId="+hospitalId, map);
                log.info("TestItemGroup 加载成功 ");
            }catch (Exception e){
                log.error("TestItemGroup 加载失败 " + e);
            }
        }
    }

    /**
     * 加载TestItemGroupItem到redis
     * @param
     */
    private void loadTestItemGroupItem(){
        for (int hospitalId:hospitalIdList){
            List<TestItemGroupItemViewModel> list = testItemGroupItemService.listViewModel(hospitalId);
            Map<String, Object> map = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (TestItemGroupItemViewModel testItemGroupItem:list) {
                try {
                    String value = om.writeValueAsString(testItemGroupItem);
                    map.put("TestItemId"+testItemGroupItem.getTestItemId()+
                            "TestItemGroupId="+testItemGroupItem.getTestItemGroupId(), value);
                }catch (Exception e){
                    log.error("TestItemGroupItem 序列化失败");
                }
            }
            try {
                redisUtil.hmset("TestItemGroupItem:hospitalId="+hospitalId, map);
                log.info("TestItemGroupItem 加载成功 ");
            }catch (Exception e){
                log.error("TestItemGroupItem 加载失败 " + e);
            }
        }
    }

    /**
     * 加载TestItemInfo到redis
     * @param
     */
    private void loadTestItemInfo(){
        for (int hospitalId:hospitalIdList){
            List<TestItemInfoViewModel> list = testItemInfoService.listViewModel(hospitalId);
            Map<String, Object> testItemIdMap = new HashMap<>(list.size());
            Map<String, Object> testItemNameMap = new HashMap<>(list.size());
            ObjectMapper om = new ObjectMapper();
            for (TestItemInfoViewModel testItemInfo:list) {
                try {
                    String value = om.writeValueAsString(testItemIdMap);
                    testItemIdMap.put("TestItemId"+testItemInfo.getTestItemId(), value);
                    testItemNameMap.put("TestItemName"+testItemInfo.getTestItemName(), value);
                }catch (Exception e){
                    log.error("TestItemInfo 序列化失败");
                }
            }
            try {
                redisUtil.hmset("TestItemInfo:testItemId:hospitalId="+hospitalId, testItemIdMap);
                redisUtil.hmset("TestItemInfo:testItemName:hospitalId="+hospitalId, testItemNameMap);
                log.info("TestItemInfo 加载成功 ");
            }catch (Exception e){
                log.error("TestItemInfo 加载失败 " + e);
            }
        }
    }

}
