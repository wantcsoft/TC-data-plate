package com.tcsoft.setting.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.PatientTypeDao;
import com.tcsoft.setting.dao.PrepLinkAbortCodeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.PrepLinkAbortCodeServiceImpl;
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
public class PrepLinkAbortCodeController extends BaseController<PrepLinkAbortCodeServiceImpl, PrepLinkAbortCodeDao>{

    public PrepLinkAbortCodeController(PrepLinkAbortCodeServiceImpl service){
        super(service);
    }

    @PostMapping("/prepLinkAbortCode")
    public ResultData<List<PrepLinkAbortCodeDao>> prepLinkAbortCode(@RequestBody PrepLinkAbortCodeDao dao,
                                                                    @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("AbortID", dao.getAbortId());
        queryWrapper = new QueryWrapper<PrepLinkAbortCodeDao>().eq("HospitalID", dao.getHospitalId());
        return handleRequest(dao, type, deletedMap);
    }

}
