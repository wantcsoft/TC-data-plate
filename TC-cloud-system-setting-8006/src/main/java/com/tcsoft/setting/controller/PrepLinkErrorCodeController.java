package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.PrepLinkAbortCodeDao;
import com.tcsoft.setting.dao.PrepLinkErrorCodeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.PrepLinkErrorCodeServiceImpl;
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
public class PrepLinkErrorCodeController extends BaseController<PrepLinkErrorCodeServiceImpl, PrepLinkErrorCodeDao>{

    public PrepLinkErrorCodeController(PrepLinkErrorCodeServiceImpl service){
        super(service);
    }

    @PostMapping("/prepLinkErrorCode")
    public ResultData<List<PrepLinkErrorCodeDao>> prepLinkErrorCode(@RequestBody PrepLinkErrorCodeDao dao,
                                                                    @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("ErrorID", dao.getErrorId());
        queryWrapper = new QueryWrapper<PrepLinkErrorCodeDao>().eq("HospitalID", dao.getHospitalId());
        return handleRequest(dao, type, deletedMap);
    }

}