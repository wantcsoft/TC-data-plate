package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.TestItemGroupDao;
import com.tcsoft.setting.dao.TestItemInfoDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.TestItemInfoServiceImpl;
import org.bouncycastle.cert.dane.DANEEntry;
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
public class TestItemInfoController extends BaseController<TestItemInfoServiceImpl, TestItemInfoDao>{

    public TestItemInfoController(TestItemInfoServiceImpl service) {
        super(service);
    }

    @PostMapping("/testItemInfo")
    public ResultData<List<TestItemInfoDao>> testItemInfo(@RequestBody TestItemInfoDao dao,
                                                @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("TestItemID", dao.getTestItemId());
        queryWrapper = new QueryWrapper<TestItemInfoDao>().eq("HospitalID", dao.getHospitalId());
        return handleRequest(dao, type, deletedMap);
    }

}
