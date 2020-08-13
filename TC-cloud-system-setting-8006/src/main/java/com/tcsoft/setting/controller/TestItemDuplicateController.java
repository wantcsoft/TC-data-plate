package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.TestItemDuplicateDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.TestItemDuplicateServiceImpl;
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
public class TestItemDuplicateController extends BaseController<TestItemDuplicateServiceImpl, TestItemDuplicateDao>{

    public TestItemDuplicateController(TestItemDuplicateServiceImpl service) {
        super(service);
    }

    @PostMapping("/testItemDuplicate")
    public ResultData<List<TestItemDuplicateDao>> testItemDuplicate(@RequestBody TestItemDuplicateDao dao,
                                                   @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("DuplicateTestItemID", dao.getDuplicateTestItemId());
        return handleRequest(dao, type, deletedMap);
    }

}