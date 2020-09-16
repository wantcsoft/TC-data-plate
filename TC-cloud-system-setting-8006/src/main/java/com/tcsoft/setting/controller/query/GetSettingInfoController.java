package com.tcsoft.setting.controller.query;


import com.tcsoft.setting.dao.AuditStateDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.utils.RedisUtil;
import com.tcsoft.setting.viewmodel.ActionCodeViewModel;
import com.tcsoft.setting.viewmodel.AuditStateViewModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author WMY
 */
@RestController
public class GetSettingInfoController {

    @Resource
    private RedisUtil redisUtil;

//    =====================================基础配置与医院无关=============================================

    @GetMapping("/auditState")
    public ResultData<List<AuditStateViewModel>> getAuditState(){
        ResultData<List<AuditStateViewModel>> resultData = new ResultData<>();
        List<AuditStateViewModel> list = new ArrayList<>();
        try {
            redisUtil.hmget("AuditState").forEach((x,y) -> {
                list.add((AuditStateViewModel) y);
            });
            resultData.setMessage("获取成功");
            resultData.setData(list);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/comparisonType")
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

    @GetMapping("/confirmState")
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

    @GetMapping("/dataType")
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

    @GetMapping("/hospitalInfo")
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

    @GetMapping("/instrumentAlternateType")
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

    @GetMapping("/lineType")
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

    @GetMapping("/resultType")
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

    @GetMapping("/ruleType")
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

    @GetMapping("/sampleEvent")
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

    @GetMapping("/sampleState")
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

    @GetMapping("/sampleStatus")
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

    @GetMapping("/sexType")
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

    @GetMapping("/ruleFunction")
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

    @GetMapping("/ruleParam")
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

    @GetMapping("/actionCode")
    public ResultData<List<ActionCodeViewModel>> getActionCode(@RequestParam("hospitalId")Integer hospitalId){
        ResultData<List<ActionCodeViewModel>> resultData = new ResultData<>();
        List<ActionCodeViewModel> list = new ArrayList<>();
        try {
            String key = "ActionCode:hospitalId="+hospitalId;
            redisUtil.hmget(key).forEach((x,y) -> {
                list.add((ActionCodeViewModel) y);
            });
            resultData.setMessage("获取成功");
            resultData.setData(list);
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("获取失败");
        }
        return resultData;
    }

    @GetMapping("/ageType")
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

    @GetMapping("/instrumentGroup")
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

    @GetMapping("/instrumentType")
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

    @GetMapping("/patientType")
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

    @GetMapping("/prepLinkAbortCode")
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

    @GetMapping("/prepLinkErrorCode")
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

    @GetMapping("/resultRange")
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

    @GetMapping("/resultUnit")
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

    @GetMapping("/ruleGroup")
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

    @GetMapping("/sampleType")
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

    @GetMapping("/testItemType")
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

    @GetMapping("/testType")
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

    @GetMapping("/chemistryContrast")
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

    @GetMapping("/comparisonInfo")
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

    @GetMapping("/instrument")
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

    @GetMapping("/lotSet")
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

    @GetMapping("/material")
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

    @GetMapping("/rule")
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

    @GetMapping("/testItemDeltaCheck")
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

    @GetMapping("/testItemGroup")
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

    @GetMapping("/testItemGroupItem")
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

    @GetMapping("/testItemInfo")
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
