package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.HospitalInfoDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.HospitalInfoServiceImpl;
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
public class HospitalInfoController extends BaseController<HospitalInfoServiceImpl, HospitalInfoDao> {

    public HospitalInfoController(HospitalInfoServiceImpl service){
        super(service);
    }

    @PostMapping("/hospitalInfo")
    public ResultData<List<HospitalInfoDao>> hospitalInfo(@RequestBody HospitalInfoDao dao,
                                                      @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("HospitalID", dao.getHospitalId());
        return handleRequest(dao, type, deletedMap);
    }

}