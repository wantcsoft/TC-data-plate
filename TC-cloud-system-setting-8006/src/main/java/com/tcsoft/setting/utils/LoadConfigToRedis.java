package com.tcsoft.setting.utils;

import com.tcsoft.setting.service.impl.*;
import com.tcsoft.setting.viewmodel.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
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
        for (AuditStateViewModel auditState:list) {
            map.put("auditStateId="+auditState.getAuditStateId(), auditState);
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
            map.put("comparisonTypeId="+comparisonType.getComparisonTypeId(), comparisonType);
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
            map.put("confirmStateId="+confirmState.getConfirmStateId(), confirmState);
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
            map.put("dataTypeId="+dataType.getDataTypeId(), dataType);
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
            map.put("hospitalId="+hospitalInfo.getHospitalId(), hospitalInfo);
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
            map.put("instrumentAlternateTypeId="+instrumentAlternateType.getInstrumentAlternateTypeId(), instrumentAlternateType);
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
            map.put("lineTypeId="+lineType.getLineTypeId(), lineType);
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
            map.put("ResultTypeId="+resultType.getResultTypeId(), resultType);
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
            map.put("ruleTypeId="+ruleType.getRuleTypeId(), ruleType);
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
            map.put("sampleEventId="+sampleEvent.getSampleEventId(), sampleEvent);
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
            map.put("sampleStateId="+sampleState.getSampleStateId(), sampleState);
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
            map.put("sampleStatusId="+sampleStatus.getSampleStatusId(), sampleStatus);
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
            map.put("sexTypeId="+sexType.getSexTypeId(), sexType);
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
            map.put("ruleFunctionId="+ruleFunction.getRuleFunctionId(), ruleFunction);
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
            map.put("ruleParamId="+ruleParam.getRuleParamId(), ruleParam);
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
                map.put("actionCode="+actionCode.getActionId(), actionCode);
            }
            try {
                redisUtil.hmset("ActionCode:hospitalId="+hospitalId, map);
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
                map.put("ageType="+ageType.getAgeTypeId(), ageType);
            }
            try {
                redisUtil.hmset("AgeType:hospitalId="+hospitalId, map);
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
                map.put("instrumentGroupId="+instrumentGroup.getInstrumentGroupId(), instrumentGroup);
            }
            try {
                redisUtil.hmset("InstrumentGroup:hospitalId="+hospitalId, map);
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
                map.put("instrumentTypeId="+instrumentType.getInstrumentTypeId(), instrumentType);
            }
            try {
                redisUtil.hmset("InstrumentType:hospitalId="+hospitalId, map);
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
                map.put("patientTypeId="+patientType.getPatientTypeId(), patientType);
            }
            try {
                redisUtil.hmset("PatientType:hospitalId="+hospitalId, map);
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
                map.put("abortId="+prepLinkAbortCode.getAbortId(), prepLinkAbortCode);
            }
            try {
                redisUtil.hmset("PrepLinkAbortCode:hospitalId="+hospitalId, map);
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
                map.put("errorId="+prepLinkErrorCode.getErrorId(), prepLinkErrorCode);
            }
            try {
                redisUtil.hmset("PrepLinkErrorCode:hospitalId="+hospitalId, map);
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
                map.put("resultRange="+resultRange.getResultRangeId(), resultRange);
            }
            try {
                redisUtil.hmset("ResultRange:hospitalId="+hospitalId, map);
                log.info("ResultRange load success ");
            }catch (Exception e){
                log.error("ResultRange load fail " + e);
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
            for (ResultUnitViewModel resultUnit:list) {
                map.put("resultUnitId="+resultUnit.getResultUnitId(), resultUnit);
            }
            try {
                redisUtil.hmset("ResultUnit:hospitalId="+hospitalId, map);
                log.info("ResultUnit load success ");
            }catch (Exception e){
                log.error("ResultUnit load fail " + e);
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
            for (RuleGroupViewModel ruleGroup:list) {
                map.put("ruleGroupId="+ruleGroup.getRuleGroupId(), ruleGroup);
            }
            try {
                redisUtil.hmset("RuleGroup:hospitalId="+hospitalId, map);
                log.info("RuleGroup load success ");
            }catch (Exception e){
                log.error("RuleGroup load fail " + e);
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
            Map<String, Object> map = new HashMap<>(list.size());
            for (SampleTypeViewModel sampleType:list) {
                map.put("sampleTypeId="+sampleType.getSampleTypeId(), sampleType);
            }
            try {
                redisUtil.hmset("SampleType:hospitalId="+hospitalId, map);
                log.info("SampleType load success ");
            }catch (Exception e){
                log.error("SampleType load fail " + e);
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
            for (TestItemTypeViewModel testItemType:list) {
                map.put("testItemTypeId="+testItemType.getTestItemTypeId(), testItemType);
            }
            try {
                redisUtil.hmset("TestItemType:hospitalId="+hospitalId, map);
                log.info("TestItemType load success ");
            }catch (Exception e){
                log.error("TestItemType load fail " + e);
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
            for (TestTypeViewModel testType:list) {
                map.put("testTypeId="+testType.getTestTypeId(), testType);
            }
            try {
                redisUtil.hmset("TestType:hospitalId="+hospitalId, map);
                log.info("TestType load success ");
            }catch (Exception e){
                log.error("TestType load fail " + e);
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
            for (ChemistryContrastViewModel chemistryContrast:list) {
                map.put("testItemId="+chemistryContrast.getTestItemId()+
                        ":sampleTypeId="+chemistryContrast.getSampleTypeId()+
                        ":instrumentId="+chemistryContrast.getInstrumentId(), chemistryContrast);
            }
            try {
                redisUtil.hmset("ChemistryContrast:hospitalId="+hospitalId, map);
                log.info("ChemistryContrast load success ");
            }catch (Exception e){
                log.error("ChemistryContrast load fail " + e);
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
            for (ComparisonInfoViewModel comparisonInfo:list) {
                map.put("instrumentTypeId="+comparisonInfo.getInstrumentTypeId()+
                        ":comparisonTypeId="+comparisonInfo.getComparisonTypeId()+
                        ":instrumentInfo="+comparisonInfo.getInstrumentInfo(), comparisonInfo);
            }
            try {
                redisUtil.hmset("ComparisonInfo:hospitalId="+hospitalId, map);
                log.info("ComparisonInfo load success ");
            }catch (Exception e){
                log.error("ComparisonInfo load fail " + e);
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
            for (InstrumentViewModel instrument:list) {
                map.put("instrumentId="+instrument.getInstrumentId()+
                        ":instrumentGroupId="+instrument.getInstrumentGroupId()+
                        ":instrumentTypeId="+instrument.getInstrumentTypeId(), instrument);
            }
            try {
                redisUtil.hmset("Instrument:hospitalId="+hospitalId, map);
                log.info("Instrument load success ");
            }catch (Exception e){
                log.error("Instrument load fail " + e);
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
            for (LotSetViewModel lotSet:list) {
                map.put("lotSetId="+lotSet.getLotSetId()+
                        ":materialId="+lotSet.getMaterialId(), lotSet);
            }
            try {
                redisUtil.hmset("LotSet:hospitalId="+hospitalId, map);
                log.info("LotSet load success ");
            }catch (Exception e){
                log.error("LotSet load fail " + e);
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
            for (MaterialViewModel material:list) {
                map.put("materialId="+material.getMaterialId(), material);
            }
            try {
                redisUtil.hmset("Material:hospitalId="+hospitalId, map);
                log.info("Material load success ");
            }catch (Exception e){
                log.error("Material load fail " + e);
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
            for (RuleViewModel rule:list) {
                map.put("ruleId="+rule.getRuleId()+
                        ":ruleGroupId="+rule.getRuleGroupId()+
                        ":ruleType="+rule.getRuleTypeId(), rule);
            }
            try {
                redisUtil.hmset("Rule:hospitalId="+hospitalId, map);
                log.info("Rule load success ");
            }catch (Exception e){
                log.error("Rule load fail " + e);
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
            for (TestItemDeltaCheckViewModel testItemDeltaCheck:list) {
                map.put("TestItemId="+testItemDeltaCheck.getTestItemId(), testItemDeltaCheck);
            }
            try {
                redisUtil.hmset("TestItemDeltaCheck:hospitalId="+hospitalId, map);
                log.info("TestItemDeltaCheck load success ");
            }catch (Exception e){
                log.error("TestItemDeltaCheck load fail " + e);
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
            for (TestItemGroupViewModel testItemGroup:list) {
                map.put("TestItemGroupId="+testItemGroup.getTestItemGroupId(), testItemGroup);
            }
            try {
                redisUtil.hmset("TestItemGroup:hospitalId="+hospitalId, map);
                log.info("TestItemGroup load success ");
            }catch (Exception e){
                log.error("TestItemGroup load fail " + e);
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
            for (TestItemGroupItemViewModel testItemGroupItem:list) {
                map.put("TestItemId"+testItemGroupItem.getTestItemId()+
                        "TestItemGroupId="+testItemGroupItem.getTestItemGroupId(), testItemGroupItem);
            }
            try {
                redisUtil.hmset("TestItemGroupItem:hospitalId="+hospitalId, map);
                log.info("TestItemGroupItem load success ");
            }catch (Exception e){
                log.error("TestItemGroupItem load fail " + e);
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
            Map<String, Object> map = new HashMap<>(list.size());
            for (TestItemInfoViewModel testItemInfo:list) {
                map.put("TestItemId"+testItemInfo.getTestItemId(), testItemInfo);
            }
            try {
                redisUtil.hmset("TestItemInfo:hospitalId="+hospitalId, map);
                log.info("TestItemInfo load success ");
            }catch (Exception e){
                log.error("TestItemInfo load fail " + e);
            }
        }
    }

}
