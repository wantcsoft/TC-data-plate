package com.tcsoft.setting.controller.modify;


import com.tcsoft.setting.dao.TestItemGroupDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.TestItemGroupServiceImpl;
import com.tcsoft.setting.viewmodel.TestItemGroupViewModel;
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
public class TestItemGroupController extends
        BaseController<TestItemGroupServiceImpl, TestItemGroupDao, TestItemGroupViewModel>{

    private Integer hospitalId;

    public TestItemGroupController(TestItemGroupServiceImpl service) {
        super(service);
    }

    @PostMapping("/testItemGroup")
    public ResultData<List<TestItemGroupViewModel>> testItemGroup(@RequestBody TestItemGroupDao dao,
                                                                  @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("TestItemGroupID", dao.getTestItemGroupId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<TestItemGroupViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
