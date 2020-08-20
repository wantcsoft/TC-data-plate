package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.ConfirmStateDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.ConfirmStateServiceImpl;
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
public class ConfirmStateController extends BaseController<ConfirmStateServiceImpl, ConfirmStateDao> {

    public ConfirmStateController(ConfirmStateServiceImpl service) {
        super(service);
    }

    @PostMapping("/confirmState")
    public ResultData<List<ConfirmStateDao>> confirmState(@RequestBody ConfirmStateDao dao,
                                                          @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("ConfirmStateID", dao.getConfirmStateId());
        return handleRequest(dao, type, deletedMap);
    }
}
