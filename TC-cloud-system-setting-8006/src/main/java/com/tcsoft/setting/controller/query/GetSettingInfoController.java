package com.tcsoft.setting.controller.query;


import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.utils.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author WMY
 */
@RestController
public class GetSettingInfoController {

    @Resource
    private RedisUtil redisUtil;

//    =====================================基础配置与医院无关=============================================

    @GetMapping("/getAuditState")
    public ResultData<Map<Object, Object>> getAuditState(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("AuditState");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getComparisonType")
    public ResultData<Map<Object, Object>> getComparisonType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("ComparisonType");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getConfirmState")
    public ResultData<Map<Object, Object>> getConfirmState(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("ConfirmState");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getDataType")
    public ResultData<Map<Object, Object>> getDataType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("DataType");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getHospitalInfo")
    public ResultData<Map<Object, Object>> getHospitalInfo(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("HospitalInfo:hospitalId");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getInstrumentAlternateType")
    public ResultData<Map<Object, Object>> getInstrumentAlternateType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("InstrumentAlternateType");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getLineType")
    public ResultData<Map<Object, Object>> getLineType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("LineType");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getResultType")
    public ResultData<Map<Object, Object>> getResultType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("ResultType");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getRuleType")
    public ResultData<Map<Object, Object>> getRuleType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("RuleType");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getSampleEvent")
    public ResultData<Map<Object, Object>> getSampleEvent(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("RuleType");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getSampleState")
    public ResultData<Map<Object, Object>> getSampleState(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("RuleType");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getSampleStatus")
    public ResultData<Map<Object, Object>> getSampleStatus(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("SampleStatus");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getSexType")
    public ResultData<Map<Object, Object>> getSexType(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("SexType");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getRuleFunction")
    public ResultData<Map<Object, Object>> getRuleFunction(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("RuleFunction");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getRuleParam")
    public ResultData<Map<Object, Object>> getRuleParam(){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            Map<Object, Object> map = redisUtil.hmget("RuleParam");
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

//    ====================================跟医院相关====================================================

    @GetMapping("/getActionCode")
    public ResultData<Map<Object, Object>> getActionCode(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "ActionCode:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getAgeType")
    public ResultData<Map<Object, Object>> getAgeType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "AgeType:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getInstrumentGroup")
    public ResultData<Map<Object, Object>> getInstrumentGroup(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "InstrumentGroup:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getInstrumentType")
    public ResultData<Map<Object, Object>> getInstrumentType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "InstrumentType:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getPatientType")
    public ResultData<Map<Object, Object>> getPatientType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "PatientType:patientTypeId:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getPrepLinkAbortCode")
    public ResultData<Map<Object, Object>> getPrepLinkAbortCode(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "PrepLinkAbortCode:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getPrepLinkErrorCode")
    public ResultData<Map<Object, Object>> getPrepLinkErrorCode(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "PrepLinkErrorCode:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getResultRange")
    public ResultData<Map<Object, Object>> getResultRange(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "ResultRange:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getResultUnit")
    public ResultData<Map<Object, Object>> getResultUnit(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "ResultUnit:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getRuleGroup")
    public ResultData<Map<Object, Object>> getRuleGroup(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "RuleGroup:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getSampleType")
    public ResultData<Map<Object, Object>> getSampleType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "SampleType:sampleTypeId:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getTestItemType")
    public ResultData<Map<Object, Object>> getTestItemType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "TestItemType:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getTestType")
    public ResultData<Map<Object, Object>> getTestType(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "TestType:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getChemistryContrast")
    public ResultData<Map<Object, Object>> getChemistryContrast(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "ChemistryContrast:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getComparisonInfo")
    public ResultData<Map<Object, Object>> getComparisonInfo(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "ComparisonInfo:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getInstrument")
    public ResultData<Map<Object, Object>> getInstrument(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "Instrument:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getLotSet")
    public ResultData<Map<Object, Object>> getLotSet(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "LotSet:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getMaterial")
    public ResultData<Map<Object, Object>> getMaterial(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "Material:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getRule")
    public ResultData<Map<Object, Object>> getRule(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "Rule:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getTestItemDeltaCheck")
    public ResultData<Map<Object, Object>> getTestItemDeltaCheck(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "TestItemDeltaCheck:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getTestItemGroup")
    public ResultData<Map<Object, Object>> getTestItemGroup(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "TestItemGroup:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getTestItemGroupItem")
    public ResultData<Map<Object, Object>> getTestItemGroupItem(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "TestItemGroupItem:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/getTestItemInfo")
    public ResultData<Map<Object, Object>> getTestItemInfo(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<Map<Object, Object>> resultData = new ResultData<>();
        try {
            String key = "TestItemInfo:testItemId:hospitalId="+hospitalId;
            Map<Object, Object> map = redisUtil.hmget(key);
            resultData.setMessage("获取成功");
            resultData.setData(map);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

}
