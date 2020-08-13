package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.TestItemGroupDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.TestItemGroupServiceImpl;
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
public class TestItemGroupController extends BaseController<TestItemGroupServiceImpl, TestItemGroupDao>{

    public TestItemGroupController(TestItemGroupServiceImpl service) {
        super(service);
    }

    @PostMapping("/testItemGroup")
    public ResultData<List<TestItemGroupDao>> testItemGroup(@RequestBody TestItemGroupDao dao,
                                                @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("TestItemGroupID", dao.getTestItemGroupId());
        queryWrapper = new QueryWrapper<TestItemGroupDao>().eq("HospitalID", dao.getHospitalId());
        return handleRequest(dao, type, deletedMap);
    }

}
