package com.tcsoft.setting.controller.modify;


import com.tcsoft.setting.dao.TestItemInfoDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.TestItemInfoServiceImpl;
import com.tcsoft.setting.viewmodel.TestItemInfoViewModel;
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
public class TestItemInfoController extends
        BaseController<TestItemInfoServiceImpl, TestItemInfoDao, TestItemInfoViewModel>{

    private Integer hospitalId;

    public TestItemInfoController(TestItemInfoServiceImpl service) {
        super(service);
    }

    @PostMapping("/testItemInfo")
    public ResultData<List<TestItemInfoViewModel>> testItemInfo(@RequestBody TestItemInfoDao dao,
                                                @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        System.out.println(dao);
        deletedMap.put("TestItemID", dao.getTestItemId());
        System.out.println(dao);
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<TestItemInfoViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
