package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.AgeTypeDao;
import com.tcsoft.setting.dao.InstrumentGroupDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.InstrumentGroupServiceImpl;
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
public class InstrumentGroupController extends BaseController<InstrumentGroupServiceImpl, InstrumentGroupDao>{

    public InstrumentGroupController(InstrumentGroupServiceImpl service){
        super(service);
    }

    @PostMapping("/instrumentGroup")
    public ResultData<List<InstrumentGroupDao>> instrumentGroup(@RequestBody InstrumentGroupDao dao,
                                                             @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("InstrumentGroupID", dao.getInstrumentGroupId());
        queryWrapper = new QueryWrapper<InstrumentGroupDao>().eq("HospitalID", dao.getHospitalId());
        return handleRequest(dao, type, deletedMap);
    }

}
