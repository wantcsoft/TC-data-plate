package com.tcsoft.setting.modifycontroller;


import com.tcsoft.setting.dao.TestItemDuplicateDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.TestItemDuplicateServiceImpl;
import com.tcsoft.setting.viewmodel.TestItemDuplicateViewModel;
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
public class TestItemDuplicateController extends
        BaseController<TestItemDuplicateServiceImpl, TestItemDuplicateDao, TestItemDuplicateViewModel>{

    public TestItemDuplicateController(TestItemDuplicateServiceImpl service) {
        super(service);
    }

    @PostMapping("/testItemDuplicate")
    public ResultData<List<TestItemDuplicateViewModel>> testItemDuplicate(@RequestBody TestItemDuplicateDao dao,
                                                   @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("DuplicateTestItemID", dao.getDuplicateTestItemId());
        return handleRequest(dao, type, deletedMap);
    }

}
