package com.tcsoft.setting.controller.modify;


import com.tcsoft.setting.dao.TestTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.TestTypeServiceImpl;
import com.tcsoft.setting.viewmodel.TestTypeViewModel;
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
public class TestTypeController extends
        BaseController<TestTypeServiceImpl, TestTypeDao, TestTypeViewModel>{

    private Integer hospitalId;

    public TestTypeController(TestTypeServiceImpl service) {
        super(service);
    }

    @PostMapping("/testType")
    public ResultData<List<TestTypeViewModel>> testType(@RequestBody TestTypeDao dao,
                                                        @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("TestTypeID", dao.getTestTypeId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<TestTypeViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
