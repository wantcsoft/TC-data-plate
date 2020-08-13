package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.TestItemGroupItemDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.TestItemGroupItemServiceImpl;
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
public class TestItemGroupItemController extends BaseController<TestItemGroupItemServiceImpl, TestItemGroupItemDao>{

    public TestItemGroupItemController(TestItemGroupItemServiceImpl service) {
        super(service);
    }

    @PostMapping("/testItemGroupItem")
    public ResultData<List<TestItemGroupItemDao>> testItemGroupItem(@RequestBody TestItemGroupItemDao dao,
                                                @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(2);
        deletedMap.put("TestItemGroupID", dao.getTestItemGroupId());
        deletedMap.put("TestItemID", dao.getTestItemId());
        return handleRequest(dao, type, deletedMap);
    }

}