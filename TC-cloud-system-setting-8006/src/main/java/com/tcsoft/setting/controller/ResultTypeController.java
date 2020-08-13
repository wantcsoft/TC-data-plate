package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.ResultTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.ResultTypeServiceImpl;
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
public class ResultTypeController extends BaseController<ResultTypeServiceImpl, ResultTypeDao>{

    public ResultTypeController(ResultTypeServiceImpl service){
        super(service);
    }

    @PostMapping("/resultType")
    public ResultData<List<ResultTypeDao>> resultType(@RequestBody ResultTypeDao dao,
                                                      @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("ResultTypeID", dao.getResultTypeId());
        return handleRequest(dao, type, deletedMap);
    }

}
