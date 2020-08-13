package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.ResultRangeDao;
import com.tcsoft.setting.dao.ResultUnitDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.ResultUnitServiceImpl;
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
public class ResultUnitController extends BaseController<ResultUnitServiceImpl, ResultUnitDao>{

    public ResultUnitController(ResultUnitServiceImpl service){
        super(service);
    }

    @PostMapping("/resultUnit")
    public ResultData<List<ResultUnitDao>> resultUnit(@RequestBody ResultUnitDao dao,
                                                      @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("ResultUnitID", dao.getResultUnitId());
        queryWrapper = new QueryWrapper<ResultUnitDao>().eq("HospitalID", dao.getHospitalId());
        return handleRequest(dao, type, deletedMap);
    }

}
