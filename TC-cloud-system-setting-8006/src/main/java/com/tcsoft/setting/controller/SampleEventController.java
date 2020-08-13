package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.SampleEventDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.SampleEventServiceImpl;
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
public class SampleEventController extends BaseController<SampleEventServiceImpl, SampleEventDao>{

    public SampleEventController(SampleEventServiceImpl service) {
        super(service);
    }

    @PostMapping("/sampleEvent")
    public ResultData<List<SampleEventDao>> sampleEvent(@RequestBody SampleEventDao dao,
                                                  @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("SampleEventID", dao.getSampleEventId());
        return handleRequest(dao, type, deletedMap);
    }

}
