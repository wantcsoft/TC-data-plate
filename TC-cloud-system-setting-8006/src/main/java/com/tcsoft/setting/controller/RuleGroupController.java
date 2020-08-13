package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.RuleDao;
import com.tcsoft.setting.dao.RuleGroupDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.RuleGroupServiceImpl;
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
public class RuleGroupController extends BaseController<RuleGroupServiceImpl, RuleGroupDao> {

    public RuleGroupController(RuleGroupServiceImpl service) {
        super(service);
    }

    @PostMapping("/ruleGroup")
    public ResultData<List<RuleGroupDao>> ruleGroup(@RequestBody RuleGroupDao dao,
                                          @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("RuleGroupID", dao.getRuleGroupId());
        queryWrapper = new QueryWrapper<RuleGroupDao>().eq("HospitalID", dao.getHospitalId());
        return handleRequest(dao, type, deletedMap);
    }
}