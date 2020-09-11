package com.tcsoft.setting.controller.modify;


import com.tcsoft.setting.dao.RuleDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.RuleServiceImpl;
import com.tcsoft.setting.viewmodel.RuleViewModel;
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
public class RuleController extends
        BaseController<RuleServiceImpl, RuleDao, RuleViewModel>{

    private Integer hospitalId;

    public RuleController(RuleServiceImpl service){
        super(service);
    }

    @PostMapping("/rule")
    public ResultData<List<RuleViewModel>> rule(@RequestBody RuleDao dao,
                                          @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("RuleID", dao.getRuleId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<RuleViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
