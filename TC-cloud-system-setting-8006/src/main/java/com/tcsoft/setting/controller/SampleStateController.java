package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.SampleStateDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.SampleStateServiceImpl;
import com.tcsoft.setting.viewmodel.SampleStateViewModel;
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
public class SampleStateController extends
        BaseController<SampleStateServiceImpl, SampleStateDao, SampleStateViewModel>{

    public SampleStateController(SampleStateServiceImpl service) {
        super(service);
    }

    @PostMapping("/sampleState")
    public ResultData<List<SampleStateViewModel>> sampleState(@RequestBody SampleStateDao dao,
                                                        @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("SampleStateID", dao.getSampleStateId());
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<SampleStateViewModel> query(){
        return service.listViewModel();
    }
}
