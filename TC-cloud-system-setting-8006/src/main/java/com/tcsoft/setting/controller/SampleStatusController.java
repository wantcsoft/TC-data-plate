package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.SampleStatusDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.SampleStatusServiceImpl;
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
public class SampleStatusController extends BaseController<SampleStatusServiceImpl, SampleStatusDao>{

    public SampleStatusController(SampleStatusServiceImpl service) {
        super(service);
    }

    @PostMapping("/sampleStatus")
    public ResultData<List<SampleStatusDao>> sampleStatus(@RequestBody SampleStatusDao dao,
                                                     @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("SampleStatusID", dao.getSampleStatusId());
        return handleRequest(dao, type, deletedMap);
    }

}
