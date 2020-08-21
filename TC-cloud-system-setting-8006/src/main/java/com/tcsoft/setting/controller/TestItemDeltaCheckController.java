package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.ActionCodeDao;
import com.tcsoft.setting.dao.TestItemDeltaCheckDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.TestItemDeltaCheckServiceImpl;
import com.tcsoft.setting.viewmodel.TestItemDeltaCheckViewModel;
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
public class TestItemDeltaCheckController extends
        BaseController<TestItemDeltaCheckServiceImpl, TestItemDeltaCheckDao, TestItemDeltaCheckViewModel> {

    public TestItemDeltaCheckController(TestItemDeltaCheckServiceImpl service) {
        super(service);
    }

    @PostMapping("/testItemDeltaCheck")
    public ResultData<List<TestItemDeltaCheckViewModel>> testItemDeltaCheck(@RequestBody TestItemDeltaCheckDao dao,
                                                   @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("TestItemID", dao.getTestItemId());
        queryWrapper = new QueryWrapper<TestItemDeltaCheckDao>().eq("HospitalID", dao.getHospitalId());
        return handleRequest(dao, type, deletedMap);
    }

}
