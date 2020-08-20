package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.LotSetDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.LotSetServiceImpl;
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
public class LotSetController extends BaseController<LotSetServiceImpl, LotSetDao>{

    public LotSetController(LotSetServiceImpl service) {
        super(service);
    }

    @PostMapping("/lotSet")
    public ResultData<List<LotSetDao>> lotSet(@RequestBody LotSetDao dao,
                                              @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("LotSetID", dao.getLotSetId());
        return handleRequest(dao, type, deletedMap);
    }
}
