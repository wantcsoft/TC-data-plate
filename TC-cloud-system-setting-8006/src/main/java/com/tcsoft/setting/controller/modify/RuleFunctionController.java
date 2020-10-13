package com.tcsoft.setting.controller.modify;

import com.tcsoft.setting.dao.RuleFunctionDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.RuleFunctionServiceImpl;
import com.tcsoft.setting.viewmodel.RuleFunctionViewModel;
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
public class RuleFunctionController extends
        BaseController<RuleFunctionServiceImpl, RuleFunctionDao, RuleFunctionViewModel>{

    public RuleFunctionController(RuleFunctionServiceImpl service){
        super(service);
    }

    @PostMapping("/ruleFunction")
    public ResultData<List<RuleFunctionViewModel>> ruleFunction(@RequestBody RuleFunctionDao dao,
                                                                @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("RuleFunctionID", dao.getRuleFunctionId());
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<RuleFunctionViewModel> query(){
        return service.listViewModel();
    }

}
