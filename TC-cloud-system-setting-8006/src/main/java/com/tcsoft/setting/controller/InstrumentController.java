package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.AgeTypeDao;
import com.tcsoft.setting.dao.InstrumentDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.InstrumentServiceImpl;
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
public class InstrumentController extends BaseController<InstrumentServiceImpl, InstrumentDao> {

    public InstrumentController(InstrumentServiceImpl service){
        super(service);
    }

    @PostMapping("/instrument")
    public ResultData<List<InstrumentDao>> instrument(@RequestBody InstrumentDao dao,
                                                        @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("InstrumentID", dao.getInstrumentId());
        queryWrapper = new QueryWrapper<InstrumentDao>().eq("HospitalID", dao.getHospitalId());
        return handleRequest(dao, type, deletedMap);
    }

}
