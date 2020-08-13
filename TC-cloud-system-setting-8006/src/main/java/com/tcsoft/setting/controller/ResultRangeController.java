package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.InstrumentDao;
import com.tcsoft.setting.dao.PrepLinkErrorCodeDao;
import com.tcsoft.setting.dao.ResultRangeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.InstrumentServiceImpl;
import com.tcsoft.setting.service.impl.ResultRangeServiceImpl;
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
public class ResultRangeController extends BaseController<ResultRangeServiceImpl, ResultRangeDao>{

    public ResultRangeController(ResultRangeServiceImpl service){
        super(service);
    }

    @PostMapping("/resultRange")
    public ResultData<List<ResultRangeDao>> resultRange(@RequestBody ResultRangeDao dao,
                                                        @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("ResultRangeID", dao.getResultRangeId());
        queryWrapper = new QueryWrapper<ResultRangeDao>().eq("HospitalID", dao.getHospitalId());
        return handleRequest(dao, type, deletedMap);
    }

}
