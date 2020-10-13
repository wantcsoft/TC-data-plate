package com.tcsoft.setting.controller.query;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.enums.ResultCode;
import com.tcsoft.setting.utils.RedisUtil;
import com.tcsoft.setting.viewmodel.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 所有的配置项获取接口
 * @author WMY
 */
@RestController
@Slf4j
public class GetSettingInfoController {

    @Resource
    private RedisUtil redisUtil;

//    =====================================基础配置与医院无关=============================================

    /**
     * auditState配置获取接口
     * @return
     */
    @GetMapping("/auditState")
    public ResultData<List<AuditStateViewModel>> getAuditState(){
        ResultData<List<AuditStateViewModel>> resultData = new ResultData<>();
        List<AuditStateViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("AuditState");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, AuditStateViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取AuditState信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);        return resultData;
    }

    /**
     * comparisonType配置获取接口
     * @return
     */
    @GetMapping("/comparisonType")
    public ResultData<List<ComparisonTypeViewModel>> getComparisonType(){
        ResultData<List<ComparisonTypeViewModel>> resultData = new ResultData<>();
        List<ComparisonTypeViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("ComparisonType");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, ComparisonTypeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取ComparisonType信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);        return resultData;
    }

    /**
     * confirmState配置获取接口
     * @return
     */
    @GetMapping("/confirmState")
    public ResultData<List<ConfirmStateViewModel>> getConfirmState(){
        ResultData<List<ConfirmStateViewModel>> resultData = new ResultData<>();
        List<ConfirmStateViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("ConfirmState");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, ConfirmStateViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取ConfirmState信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);        return resultData;
    }

    /**
     * dataType配置获取接口
     * @return
     */
    @GetMapping("/dataType")
    public ResultData<List<DataTypeViewModel>> getDataType(){
        ResultData<List<DataTypeViewModel>> resultData = new ResultData<>();
        List<DataTypeViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("DataType");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, DataTypeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取DataType信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);        return resultData;
    }

    /**
     * hospitalInfo配置获取接口
     * @return
     */
    @GetMapping("/hospitalInfo")
    public ResultData<List<HospitalInfoViewModel>> getHospitalInfo(){
        ResultData<List<HospitalInfoViewModel>> resultData = new ResultData<>();
        List<HospitalInfoViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("HospitalInfo:hospitalId");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, HospitalInfoViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取HospitalInfo信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);        return resultData;
    }

    /**
     * instrumentAlternateType配置获取接口
     * @return
     */
    @GetMapping("/instrumentAlternateType")
    public ResultData<List<InstrumentAlternateTypeViewModel>> getInstrumentAlternateType(){
        ResultData<List<InstrumentAlternateTypeViewModel>> resultData = new ResultData<>();
        List<InstrumentAlternateTypeViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("InstrumentAlternateType");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, InstrumentAlternateTypeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取InstrumentAlternateType信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * lineType配置获取接口
     * @return
     */
    @GetMapping("/lineType")
    public ResultData<List<LineTypeViewModel>> getLineType(){
        ResultData<List<LineTypeViewModel>> resultData = new ResultData<>();
        List<LineTypeViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("LineType");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, LineTypeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取LineType信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * resultType配置获取接口
     * @return
     */
    @GetMapping("/resultType")
    public ResultData<List<ResultTypeViewModel>> getResultType(){
        ResultData<List<ResultTypeViewModel>> resultData = new ResultData<>();
        List<ResultTypeViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("ResultType");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, ResultTypeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取ResultType信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * ruleType配置获取接口
     * @return
     */
    @GetMapping("/ruleType")
    public ResultData<List<RuleTypeViewModel>> getRuleType(){
        ResultData<List<RuleTypeViewModel>> resultData = new ResultData<>();
        List<RuleTypeViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("RuleType");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, RuleTypeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取RuleType信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * sampleEvent配置获取接口
     * @return
     */
    @GetMapping("/sampleEvent")
    public ResultData<List<SampleEventViewModel>> getSampleEvent(){
        ResultData<List<SampleEventViewModel>> resultData = new ResultData<>();
        List<SampleEventViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("SampleEvent");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, SampleEventViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取SampleEvent信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * sampleState配置获取接口
     * @return
     */
    @GetMapping("/sampleState")
    public ResultData<List<SampleStateViewModel>> getSampleState(){
        ResultData<List<SampleStateViewModel>> resultData = new ResultData<>();
        List<SampleStateViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("SampleState");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, SampleStateViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取SampleState信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * sampleStatus配置获取接口
     * @return
     */
    @GetMapping("/sampleStatus")
    public ResultData<List<SampleStatusViewModel>> getSampleStatus(){
        ResultData<List<SampleStatusViewModel>> resultData = new ResultData<>();
        List<SampleStatusViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("SampleStatus");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, SampleStatusViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取SampleStatus信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * sexType配置获取接口
     * @return
     */
    @GetMapping("/sexType")
    public ResultData<List<SexTypeViewModel>> getSexType(){
        ResultData<List<SexTypeViewModel>> resultData = new ResultData<>();
        List<SexTypeViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("SexType");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, SexTypeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取SexType信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * ruleFunction配置获取接口
     * @return
     */
    @GetMapping("/ruleFunction")
    public ResultData<List<RuleFunctionViewModel>> getRuleFunction(){
        ResultData<List<RuleFunctionViewModel>> resultData = new ResultData<>();
        List<RuleFunctionViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("RuleFunction");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, RuleFunctionViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取RuleFunction信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * ruleParam配置获取接口
     * @return
     */
    @GetMapping("/ruleParam")
    public ResultData<List<RuleParamViewModel>> getRuleParam(){
        ResultData<List<RuleParamViewModel>> resultData = new ResultData<>();
        List<RuleParamViewModel> list = new ArrayList<>();
        Map<Object, Object> map = redisUtil.hmget("RuleParam");
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, RuleParamViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取RuleParam信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

//    ====================================跟医院相关====================================================

    /**
     * actionCode配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/actionCode")
    public ResultData<List<ActionCodeViewModel>> getActionCode(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<ActionCodeViewModel>> resultData = new ResultData<>();
        List<ActionCodeViewModel> list = new ArrayList<>();
        String key = "ActionCode:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, ActionCodeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取ActionCode信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * ageType配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/ageType")
    public ResultData<List<AgeTypeViewModel>> getAgeType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<AgeTypeViewModel>> resultData = new ResultData<>();
        List<AgeTypeViewModel> list = new ArrayList<>();
        String key = "AgeType:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, AgeTypeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取AgeType信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * instrumentGroup配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/instrumentGroup")
    public ResultData<List<InstrumentGroupViewModel>> getInstrumentGroup(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<InstrumentGroupViewModel>> resultData = new ResultData<>();
        List<InstrumentGroupViewModel> list = new ArrayList<>();
        String key = "InstrumentGroup:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, InstrumentGroupViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取 InstrumentGroup 信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * instrumentType配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/instrumentType")
    public ResultData<List<InstrumentTypeViewModel>> getInstrumentType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<InstrumentTypeViewModel>> resultData = new ResultData<>();
        List<InstrumentTypeViewModel> list = new ArrayList<>();
        String key = "InstrumentType:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, InstrumentTypeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取InstrumentType信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * patientType配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/patientType")
    public ResultData<List<PatientTypeViewModel>> getPatientType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<PatientTypeViewModel>> resultData = new ResultData<>();
        List<PatientTypeViewModel> list = new ArrayList<>();
        String key = "PatientType:patientTypeId:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, PatientTypeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取PatientType信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * prepLinkAbortCode配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/prepLinkAbortCode")
    public ResultData<List<PrepLinkAbortCodeViewModel>> getPrepLinkAbortCode(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<PrepLinkAbortCodeViewModel>> resultData = new ResultData<>();
        List<PrepLinkAbortCodeViewModel> list = new ArrayList<>();
        String key = "PrepLinkAbortCode:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, PrepLinkAbortCodeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取 PrepLinkAbortCode 信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * prepLinkErrorCode配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/prepLinkErrorCode")
    public ResultData<List<PrepLinkErrorCodeViewModel>> getPrepLinkErrorCode(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<PrepLinkErrorCodeViewModel>> resultData = new ResultData<>();
        List<PrepLinkErrorCodeViewModel> list = new ArrayList<>();
        String key = "PrepLinkErrorCode:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, PrepLinkErrorCodeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取 PrepLinkErrorCode 信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * resultRange配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/resultRange")
    public ResultData<List<ResultRangeViewModel>> getResultRange(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<ResultRangeViewModel>> resultData = new ResultData<>();
        List<ResultRangeViewModel> list = new ArrayList<>();
        String key = "ResultRange:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, ResultRangeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取ResultRange信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * resultUnit配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/resultUnit")
    public ResultData<List<ResultUnitViewModel>> getResultUnit(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<ResultUnitViewModel>> resultData = new ResultData<>();
        List<ResultUnitViewModel> list = new ArrayList<>();
        String key = "ResultUnit:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, ResultUnitViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取ResultUnit信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * ruleGroup配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/ruleGroup")
    public ResultData<List<RuleGroupViewModel>> getRuleGroup(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<RuleGroupViewModel>> resultData = new ResultData<>();
        List<RuleGroupViewModel> list = new ArrayList<>();
        String key = "RuleGroup:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, RuleGroupViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取RuleGroup信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * sampleType配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/sampleType")
    public ResultData<List<SampleTypeViewModel>> getSampleType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<SampleTypeViewModel>> resultData = new ResultData<>();
        List<SampleTypeViewModel> list = new ArrayList<>();
        String key = "SampleType:sampleTypeId:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, SampleTypeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取SampleType信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * testItemType配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/testItemType")
    public ResultData<List<TestItemTypeViewModel>> getTestItemType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<TestItemTypeViewModel>> resultData = new ResultData<>();
        List<TestItemTypeViewModel> list = new ArrayList<>();
        String key = "TestItemType:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, TestItemTypeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取TestItemType信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * testType配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/testType")
    public ResultData<List<TestTypeViewModel>> getTestType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<TestTypeViewModel>> resultData = new ResultData<>();
        List<TestTypeViewModel> list = new ArrayList<>();
        String key = "TestType:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, TestTypeViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取TestType信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * chemistryContrast配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/chemistryContrast")
    public ResultData<List<ChemistryContrastViewModel>> getChemistryContrast(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<ChemistryContrastViewModel>> resultData = new ResultData<>();
        List<ChemistryContrastViewModel> list = new ArrayList<>();
        String key = "ChemistryContrast:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, ChemistryContrastViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取ChemistryContrast信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * comparisonInfo配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/comparisonInfo")
    public ResultData<List<ComparisonInfoViewModel>> getComparisonInfo(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<ComparisonInfoViewModel>> resultData = new ResultData<>();
        List<ComparisonInfoViewModel> list = new ArrayList<>();
        String key = "ComparisonInfo:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, ComparisonInfoViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取ComparisonInfo信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * instrument配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/instrument")
    public ResultData<List<InstrumentViewModel>> getInstrument(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<InstrumentViewModel>> resultData = new ResultData<>();
        List<InstrumentViewModel> list = new ArrayList<>();
        String key = "Instrument:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, InstrumentViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取Instrument信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * lotSet配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/lotSet")
    public ResultData<List<LotSetViewModel>> getLotSet(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<LotSetViewModel>> resultData = new ResultData<>();
        List<LotSetViewModel> list = new ArrayList<>();
        String key = "LotSet:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, LotSetViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取LotSet信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * material配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/material")
    public ResultData<List<MaterialViewModel>> getMaterial(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<MaterialViewModel>> resultData = new ResultData<>();
        List<MaterialViewModel> list = new ArrayList<>();
        String key = "Material:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, MaterialViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取Material信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * rule配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/rule")
    public ResultData<List<RuleViewModel>> getRule(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<RuleViewModel>> resultData = new ResultData<>();
        List<RuleViewModel> list = new ArrayList<>();
        String key = "Rule:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, RuleViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取Rule信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * testItemDeltaCheck配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/testItemDeltaCheck")
    public ResultData<List<TestItemDeltaCheckViewModel>> getTestItemDeltaCheck(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<TestItemDeltaCheckViewModel>> resultData = new ResultData<>();
        List<TestItemDeltaCheckViewModel> list = new ArrayList<>();
        String key = "TestItemDeltaCheck:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, TestItemDeltaCheckViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取TestItemDeltaCheck信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * testItemGroup配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/testItemGroup")
    public ResultData<List<TestItemGroupViewModel>> getTestItemGroup(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<TestItemGroupViewModel>> resultData = new ResultData<>();
        List<TestItemGroupViewModel> list = new ArrayList<>();
        String key = "TestItemGroup:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, TestItemGroupViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取TestItemGroup信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * testItemGroupItem配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/testItemGroupItem")
    public ResultData<List<TestItemGroupItemViewModel>> getTestItemGroupItem(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<TestItemGroupItemViewModel>> resultData = new ResultData<>();
        List<TestItemGroupItemViewModel> list = new ArrayList<>();
        String key = "TestItemGroupItem:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, TestItemGroupItemViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取TestItemGroupItem信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * testItemInfo配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/testItemInfo")
    public ResultData<List<TestItemInfoViewModel>> getTestItemInfo(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<TestItemInfoViewModel>> resultData = new ResultData<>();
        List<TestItemInfoViewModel> list = new ArrayList<>();
        String key = "TestItemInfo:testItemId:hospitalId="+hospitalId;
        Map<Object, Object> map = redisUtil.hmget(key);
        ObjectMapper om = new ObjectMapper();
        map.forEach((x,y) -> {
            try {
                list.add(om.readValue((String) y, TestItemInfoViewModel.class));
            } catch (JsonProcessingException e) {
                log.error("从redis读取TestItemInfo信息失败" + e);
            }
        });
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

}
