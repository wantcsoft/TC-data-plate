package com.tcsoft.setting.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.ActionCodeDao;
import com.tcsoft.setting.dao.AgeTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.ActionCodeServiceImpl;
import com.tcsoft.setting.utils.SettingUtilsConstant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WMY
 */
@RestController
public class ActionCodeController extends BaseController<ActionCodeServiceImpl, ActionCodeDao>{

    public ActionCodeController(ActionCodeServiceImpl service){
        super(service);
    }

    @PostMapping("/actionCode")
    public ResultData<List<ActionCodeDao>> actionCode(@RequestBody ActionCodeDao dao,
                                                      @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("ActionID", dao.getActionId());
        queryWrapper = new QueryWrapper<ActionCodeDao>().eq("HospitalID", dao.getHospitalId());
        return handleRequest(dao, type, deletedMap);
    }

}
