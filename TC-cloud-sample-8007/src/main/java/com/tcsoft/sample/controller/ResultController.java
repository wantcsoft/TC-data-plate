//package com.tcsoft.sample.controller;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.tcsoft.sample.dao.ResultDao;
//import com.tcsoft.sample.entity.ResultData;
//import com.tcsoft.sample.service.impl.ResultServiceImpl;
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
//public class ResultController extends BaseController<ResultServiceImpl, ResultDao>{
//
//    public ResultController(ResultServiceImpl service) {
//        super(service);
//    }
//
//    @PostMapping("/result")
//    public ResultData<List<ResultDao>> result(@RequestBody ResultDao dao,
//                                                  @RequestParam String type){
//        Map<String, Object> deletedMap = new HashMap<>(2);
//        deletedMap.put("SampleNo", dao.getSampleNo());
//        deletedMap.put("TestItemID", dao.getTestItemId());
//        queryWrapper = new QueryWrapper<ResultDao>()
//                .eq("SampleNo", dao.getSampleNo())
//                .eq("TestItemID", dao.getTestItemId());
//        return handleRequest(dao, type, deletedMap);
//    }
//
//}
