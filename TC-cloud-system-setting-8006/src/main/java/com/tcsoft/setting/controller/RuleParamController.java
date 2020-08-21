package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.RuleParamDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.RuleParamServiceImpl;
import com.tcsoft.setting.viewmodel.RuleParamViewModel;
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
public class RuleParamController extends
        BaseController<RuleParamServiceImpl, RuleParamDao, RuleParamViewModel>{

    public RuleParamController(RuleParamServiceImpl service) {
        super(service);
    }

    @PostMapping("/ruleParam")
    public ResultData<List<RuleParamViewModel>> ruleParam(@RequestBody RuleParamDao dao,
                                          @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("RuleParamID", dao.getRuleParamId());
        return handleRequest(dao, type, deletedMap);
    }

}
