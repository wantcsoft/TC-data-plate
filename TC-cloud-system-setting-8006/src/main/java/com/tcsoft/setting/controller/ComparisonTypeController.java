package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.ComparisonTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.ComparisonTypeServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WMY
 */
@RestController
public class ComparisonTypeController extends BaseController<ComparisonTypeServiceImpl, ComparisonTypeDao> {

    public ComparisonTypeController(ComparisonTypeServiceImpl service){
        super(service);
    }

    @PostMapping("/comparisonType")
    public ResultData<List<ComparisonTypeDao>> comparisonType(@RequestBody ComparisonTypeDao dao,
                                                       @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("ComparisonTypeID", dao.getComparisonTypeId());
        return handleRequest(dao, type, deletedMap);
    }

}
