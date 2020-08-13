package com.tcsoft.setting.controller;

import com.tcsoft.setting.dao.RuleFunctionDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.RuleFunctionServiceImpl;
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
public class RuleFunctionController extends BaseController<RuleFunctionServiceImpl, RuleFunctionDao>{

    public RuleFunctionController(RuleFunctionServiceImpl service){
        super(service);
    }

    @PostMapping("/ruleFunction")
    public ResultData<List<RuleFunctionDao>> ruleFunction(@RequestBody RuleFunctionDao dao,
                                          @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("RuleFunctionID", dao.getRuleFunctionId());
        return handleRequest(dao, type, deletedMap);
    }

}
