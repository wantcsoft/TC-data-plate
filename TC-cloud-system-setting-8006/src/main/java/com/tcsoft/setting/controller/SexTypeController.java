package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.SexTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.SexTypeServiceImpl;
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
public class SexTypeController extends BaseController<SexTypeServiceImpl, SexTypeDao>{

    public SexTypeController(SexTypeServiceImpl service) {
        super(service);
    }

    @PostMapping("/sexType")
    public ResultData<List<SexTypeDao>> sexType(@RequestBody SexTypeDao dao,
                                                      @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("SexTypeID", dao.getSexTypeId());
        return handleRequest(dao, type, deletedMap);
    }

}