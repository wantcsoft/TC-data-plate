package com.tcsoft.setting.controller.modify;

import com.tcsoft.setting.dao.ActionCodeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.ActionCodeServiceImpl;
import com.tcsoft.setting.viewmodel.ActionCodeViewModel;
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
public class ActionCodeController extends
        BaseController<ActionCodeServiceImpl, ActionCodeDao, ActionCodeViewModel>{

    private Integer hospitalId;

    public ActionCodeController(ActionCodeServiceImpl service){
        super(service);
    }

    @PostMapping("/actionCode")
    public ResultData<List<ActionCodeViewModel>> actionCode(@RequestBody ActionCodeDao dao,
                                                            @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("ActionID", dao.getActionId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<ActionCodeViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
