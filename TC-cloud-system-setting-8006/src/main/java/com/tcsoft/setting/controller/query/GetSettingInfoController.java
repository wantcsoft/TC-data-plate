package com.tcsoft.setting.controller.query;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcsoft.setting.entity.ResultData;
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
    public ResultData<Map<Object, Object>> getAuditState(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("AuditState");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, AuditStateViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取AuditState信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * comparisonType配置获取接口
     * @return
     */
    @GetMapping("/comparisonType")
    public ResultData<Map<Object, Object>> getComparisonType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("ComparisonType");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, ComparisonInfoViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取ComparisonInfo信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * confirmState配置获取接口
     * @return
     */
    @GetMapping("/confirmState")
    public ResultData<Map<Object, Object>> getConfirmState(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("ConfirmState");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, ConfirmStateViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取ConfirmState信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * dataType配置获取接口
     * @return
     */
    @GetMapping("/dataType")
    public ResultData<Map<Object, Object>> getDataType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("DataType");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, DataTypeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取DataType信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * hospitalInfo配置获取接口
     * @return
     */
    @GetMapping("/hospitalInfo")
    public ResultData<Map<Object, Object>> getHospitalInfo(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("HospitalInfo:hospitalId");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, HospitalInfoViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取HospitalInfo信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * instrumentAlternateType配置获取接口
     * @return
     */
    @GetMapping("/instrumentAlternateType")
    public ResultData<Map<Object, Object>> getInstrumentAlternateType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("InstrumentAlternateType");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, InstrumentAlternateTypeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取InstrumentAlternateType信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * lineType配置获取接口
     * @return
     */
    @GetMapping("/lineType")
    public ResultData<Map<Object, Object>> getLineType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("LineType");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, LineTypeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取LineType信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * resultType配置获取接口
     * @return
     */
    @GetMapping("/resultType")
    public ResultData<Map<Object, Object>> getResultType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("ResultType");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, ResultTypeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取ResultType信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * ruleType配置获取接口
     * @return
     */
    @GetMapping("/ruleType")
    public ResultData<Map<Object, Object>> getRuleType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("RuleType");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, RuleTypeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取RuleType信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * sampleEvent配置获取接口
     * @return
     */
    @GetMapping("/sampleEvent")
    public ResultData<Map<Object, Object>> getSampleEvent(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("SampleEvent");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, SampleEventViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取SampleEvent信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * sampleState配置获取接口
     * @return
     */
    @GetMapping("/sampleState")
    public ResultData<Map<Object, Object>> getSampleState(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("SampleState");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, SampleStateViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取SampleState信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * sampleStatus配置获取接口
     * @return
     */
    @GetMapping("/sampleStatus")
    public ResultData<Map<Object, Object>> getSampleStatus(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("SampleStatus");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, SampleStatusViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取SampleStatus信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * sexType配置获取接口
     * @return
     */
    @GetMapping("/sexType")
    public ResultData<Map<Object, Object>> getSexType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("SexType");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, SexTypeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取SexType信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * ruleFunction配置获取接口
     * @return
     */
    @GetMapping("/ruleFunction")
    public ResultData<Map<Object, Object>> getRuleFunction(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("RuleFunction");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, RuleFunctionViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取RuleFunction信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * ruleParam配置获取接口
     * @return
     */
    @GetMapping("/ruleParam")
    public ResultData<Map<Object, Object>> getRuleParam(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("RuleParam");
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, RuleParamViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取RuleParam信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

//    ====================================跟医院相关====================================================

    /**
     * actionCode配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/actionCode")
    public ResultData<Map<Object, Object>> getActionCode(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "ActionCode:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, ActionCodeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取ActionCode信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * ageType配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/ageType")
    public ResultData<Map<Object, Object>> getAgeType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "AgeType:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, AgeTypeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取AgeType信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * instrumentGroup配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/instrumentGroup")
    public ResultData<Map<Object, Object>> getInstrumentGroup(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "InstrumentGroup:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, InstrumentGroupViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取 InstrumentGroup 信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * instrumentType配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/instrumentType")
    public ResultData<Map<Object, Object>> getInstrumentType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "InstrumentType:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, InstrumentTypeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取InstrumentType信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * patientType配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/patientType")
    public ResultData<Map<Object, Object>> getPatientType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "PatientType:patientTypeId:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, PatientTypeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取PatientType信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * prepLinkAbortCode配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/prepLinkAbortCode")
    public ResultData<Map<Object, Object>> getPrepLinkAbortCode(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "PrepLinkAbortCode:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, PrepLinkAbortCodeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取 PrepLinkAbortCode 信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * prepLinkErrorCode配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/prepLinkErrorCode")
    public ResultData<Map<Object, Object>> getPrepLinkErrorCode(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "PrepLinkErrorCode:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, PrepLinkErrorCodeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取 PrepLinkErrorCode 信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * resultRange配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/resultRange")
    public ResultData<Map<Object, Object>> getResultRange(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "ResultRange:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, ResultRangeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取ResultRange信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * resultUnit配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/resultUnit")
    public ResultData<Map<Object, Object>> getResultUnit(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "ResultUnit:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, ResultUnitViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取ResultUnit信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * ruleGroup配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/ruleGroup")
    public ResultData<Map<Object, Object>> getRuleGroup(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "RuleGroup:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, RuleGroupViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取RuleGroup信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * sampleType配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/sampleType")
    public ResultData<Map<Object, Object>> getSampleType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "SampleType:sampleTypeId:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, SampleTypeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取SampleType信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * testItemType配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/testItemType")
    public ResultData<Map<Object, Object>> getTestItemType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "TestItemType:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, TestItemTypeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取TestItemType信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * testType配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/testType")
    public ResultData<Map<Object, Object>> getTestType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "TestType:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, TestTypeViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取TestType信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * chemistryContrast配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/chemistryContrast")
    public ResultData<Map<Object, Object>> getChemistryContrast(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "ChemistryContrast:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, ChemistryContrastViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取ChemistryContrast信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * comparisonInfo配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/comparisonInfo")
    public ResultData<Map<Object, Object>> getComparisonInfo(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "ComparisonInfo:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, ComparisonInfoViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取ComparisonInfo信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * instrument配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/instrument")
    public ResultData<Map<Object, Object>> getInstrument(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "Instrument:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, InstrumentViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取Instrument信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * lotSet配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/lotSet")
    public ResultData<Map<Object, Object>> getLotSet(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "LotSet:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, LotSetViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取LotSet信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * material配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/material")
    public ResultData<Map<Object, Object>> getMaterial(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "Material:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, MaterialViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取Material信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * rule配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/rule")
    public ResultData<Map<Object, Object>> getRule(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "Rule:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, RuleViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取Rule信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * testItemDeltaCheck配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/testItemDeltaCheck")
    public ResultData<Map<Object, Object>> getTestItemDeltaCheck(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "TestItemDeltaCheck:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, TestItemDeltaCheckViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取TestItemDeltaCheck信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * testItemGroup配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/testItemGroup")
    public ResultData<Map<Object, Object>> getTestItemGroup(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "TestItemGroup:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, TestItemGroupViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取TestItemGroup信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * testItemGroupItem配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/testItemGroupItem")
    public ResultData<Map<Object, Object>> getTestItemGroupItem(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "TestItemGroupItem:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, TestItemGroupItemViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取TestItemGroupItem信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    /**
     * testItemInfo配置获取接口
     * @param hospitalId
     * @return
     */
    @GetMapping("/testItemInfo")
    public ResultData<Map<Object, Object>> getTestItemInfo(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "TestItemInfo:testItemId:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            ObjectMapper om = new ObjectMapper();
            map.forEach((x,y) -> {
                try {
                    map.put(x, om.readValue((String) y, TestItemInfoViewModel.class));
                } catch (JsonProcessingException e) {
                    log.error("从redis读取TestItemInfo信息失败" + e);
                }
            });
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

}
