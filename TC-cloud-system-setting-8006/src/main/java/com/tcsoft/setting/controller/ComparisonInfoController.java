package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.ComparisonInfoDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.ComparisonInfoServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WMY
 */
@RestController
public class ComparisonInfoController extends BaseController<ComparisonInfoServiceImpl, ComparisonInfoDao> {

    public ComparisonInfoController(ComparisonInfoServiceImpl service){
        super(service);
    }

    @PostMapping("/comparisonInfo")
    public ResultData<List<ComparisonInfoDao>> comparisonInfo(@RequestBody ComparisonInfoDao dao,
                                                       @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(3);
        deletedMap.put("InstrumentTypeID", dao.getInstrumentTypeId());
        deletedMap.put("ComparisonTypeID", dao.getComparisonTypeId());
        deletedMap.put("InstrumentInfo", dao.getInstrumentInfo());
        System.out.println(dao);
        return handleRequest(dao, type, deletedMap);
    }

}
