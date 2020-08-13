//package com.tcsoft.sample.controller;
//
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.tcsoft.sample.dao.ProgItemDao;
//import com.tcsoft.sample.entity.ResultData;
//import com.tcsoft.sample.service.impl.ProgItemServiceImpl;
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
//public class ProgItemController extends BaseController<ProgItemServiceImpl, ProgItemDao>{
//
//    public ProgItemController(ProgItemServiceImpl service) {
//        super(service);
//    }
//
//    @PostMapping("/progItem")
//    public ResultData<List<ProgItemDao>> progItem(@RequestBody ProgItemDao dao,
//                                     @RequestParam String type){
////        Map<String, Object> deletedMap = new HashMap<>(1);
////        deletedMap.put("ActionID", dao.getActionId());
////        queryWrapper = new QueryWrapper<ProgItemDao>().eq("HospitalID", dao.getHospitalId());
//        return null;
//    }
//}
