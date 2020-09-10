package com.tcsoft.setting.modifycontroller;


import com.tcsoft.setting.dao.AuditStateDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.AuditStateServiceImpl;
import com.tcsoft.setting.viewmodel.AuditStateViewModel;
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
public class AuditStateController extends
        BaseController<AuditStateServiceImpl, AuditStateDao, AuditStateViewModel>{

    public AuditStateController(AuditStateServiceImpl service) {
        super(service);
    }

    @PostMapping("/auditState")
    public ResultData<List<AuditStateViewModel>> auditState(@RequestBody AuditStateDao dao,
                                                      @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("AuditStateID", dao.getAuditStateId());
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<AuditStateViewModel> query(){
        return service.listViewModel();
    }

}
