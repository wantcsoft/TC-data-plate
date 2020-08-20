package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.AuditStateDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.AuditStateServiceImpl;
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
public class AuditStateController extends BaseController<AuditStateServiceImpl, AuditStateDao>{

    public AuditStateController(AuditStateServiceImpl service) {
        super(service);
    }

    @PostMapping("/auditState")
    public ResultData<List<AuditStateDao>> auditState(@RequestBody AuditStateDao dao,
                                                      @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("AuditStateID", dao.getAuditStateId());
        return handleRequest(dao, type, deletedMap);
    }

}
