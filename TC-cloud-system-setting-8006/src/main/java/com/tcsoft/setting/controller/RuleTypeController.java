package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.RuleTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.RuleTypeServiceImpl;
import com.tcsoft.setting.viewmodel.RuleTypeViewModel;
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
public class RuleTypeController extends
        BaseController<RuleTypeServiceImpl, RuleTypeDao, RuleTypeViewModel>{

    public RuleTypeController(RuleTypeServiceImpl service) {
        super(service);
    }

    @PostMapping("/ruleType")
    public ResultData<List<RuleTypeViewModel>> ruleType(@RequestBody RuleTypeDao dao,
                                          @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("RuleTypeID", dao.getRuleTypeId());
        return handleRequest(dao, type, deletedMap);
    }

}
