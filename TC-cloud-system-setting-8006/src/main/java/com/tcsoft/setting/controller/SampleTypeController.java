package com.tcsoft.setting.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.RuleDao;
import com.tcsoft.setting.dao.SampleTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.SampleTypeServiceImpl;
import com.tcsoft.setting.viewmodel.SampleTypeViewModel;
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
public class SampleTypeController extends
        BaseController<SampleTypeServiceImpl, SampleTypeDao, SampleTypeViewModel>{

    private Integer hospitalId;

    public SampleTypeController(SampleTypeServiceImpl service) {
        super(service);
    }

    @PostMapping("/sampleType")
    public ResultData<List<SampleTypeViewModel>> sampleType(@RequestBody SampleTypeDao dao,
                                                          @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("SampleTypeID", dao.getSampleTypeId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<SampleTypeViewModel> query(){
        return service.listViewMode(hospitalId);
    }

}
