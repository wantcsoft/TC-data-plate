//package com.tcsoft.sample.controller;
//
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.tcsoft.sample.dao.SampleInfoDao;
//import com.tcsoft.sample.entity.ResultData;
//import com.tcsoft.sample.service.impl.SampleInfoServiceImpl;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author WMY
// */
//@RestController
//public class SampleInfoController extends BaseController<SampleInfoServiceImpl, SampleInfoDao>{
//
//    public SampleInfoController(SampleInfoServiceImpl sampleInfoService) {
//        super(sampleInfoService);
//    }
//
//    @PostMapping("/sampleInfo")
//    public ResultData<List<SampleInfoDao>> sampleInfo(@RequestBody SampleInfoDao dao,
//                                                     @RequestParam String type){
//        Map<String, Object> deletedMap = new HashMap<>(1);
//        deletedMap.put("SampleNo", dao.getSampleNo());
//        queryWrapper = new QueryWrapper<SampleInfoDao>()
//                .eq("SampleNo", dao.getSampleNo());
//        return handleRequest(dao, type, deletedMap);
//    }
//
//}
