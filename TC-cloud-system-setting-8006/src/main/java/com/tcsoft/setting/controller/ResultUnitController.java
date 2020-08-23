package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.ResultUnitDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.ResultUnitServiceImpl;
import com.tcsoft.setting.viewmodel.ResultUnitViewModel;
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
public class ResultUnitController extends
        BaseController<ResultUnitServiceImpl, ResultUnitDao, ResultUnitViewModel>{

    private Integer hospitalId;

    public ResultUnitController(ResultUnitServiceImpl service){
        super(service);
    }

    @PostMapping("/resultUnit")
    public ResultData<List<ResultUnitViewModel>> resultUnit(@RequestBody ResultUnitDao dao,
                                                      @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("ResultUnitID", dao.getResultUnitId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<ResultUnitViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
