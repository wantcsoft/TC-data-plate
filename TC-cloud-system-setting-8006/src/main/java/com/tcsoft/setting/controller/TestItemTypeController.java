package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.TestItemInfoDao;
import com.tcsoft.setting.dao.TestItemTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.TestItemTypeServiceImpl;
import com.tcsoft.setting.viewmodel.TestItemTypeViewModel;
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
public class TestItemTypeController extends
        BaseController<TestItemTypeServiceImpl, TestItemTypeDao, TestItemTypeViewModel>{

    private Integer hospitalId;

    public TestItemTypeController(TestItemTypeServiceImpl testItemTypeService) {
        super(testItemTypeService);
    }

    @PostMapping("/testItemType")
    public ResultData<List<TestItemTypeViewModel>> testItemType(@RequestBody TestItemTypeDao dao,
                                                @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("TestItemTypeID", dao.getTestItemTypeId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<TestItemTypeViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
