//package com.tcsoft.sample.controller;
//
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.tcsoft.sample.dao.ResultDao;
//import com.tcsoft.sample.dao.ResultrerunDao;
//import com.tcsoft.sample.entity.ResultData;
//import com.tcsoft.sample.service.impl.ResultrerunServiceImpl;
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
//public class ResultrerunController extends BaseController<ResultrerunServiceImpl, ResultrerunDao>{
//
//    public ResultrerunController(ResultrerunServiceImpl resultrerunService) {
//        super(resultrerunService);
//    }
//
//    @PostMapping("/resultrerun")
//    public ResultData<List<ResultrerunDao>> resultrerun(@RequestBody ResultrerunDao dao,
//                                                  @RequestParam String type){
//        Map<String, Object> deletedMap = new HashMap<>(3);
//        deletedMap.put("SampleNo", dao.getSampleNo());
//        deletedMap.put("TestItemID", dao.getTestItemId());
//        deletedMap.put("RerunTimes", dao.getRerunTimes());
//        queryWrapper = new QueryWrapper<ResultrerunDao>()
//                .eq("SampleNo", dao.getSampleNo())
//                .eq("TestItemID", dao.getTestItemId())
//                .eq("RerunTimes", dao.getRerunTimes());
//        return handleRequest(dao, type, deletedMap);
//    }
//}
