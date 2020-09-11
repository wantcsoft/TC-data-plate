package com.tcsoft.setting.controller.modify;


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

    private Integer hospitalId;

    public TestItemDeltaCheckController(TestItemDeltaCheckServiceImpl service) {
        super(service);
    }

    @PostMapping("/testItemDeltaCheck")
    public ResultData<List<TestItemDeltaCheckViewModel>> testItemDeltaCheck(@RequestBody TestItemDeltaCheckDao dao,
                                                   @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(2);
        deletedMap.put("TestItemID", dao.getTestItemId());
        deletedMap.put("HospitalID", dao.getHospitalId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<TestItemDeltaCheckViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
