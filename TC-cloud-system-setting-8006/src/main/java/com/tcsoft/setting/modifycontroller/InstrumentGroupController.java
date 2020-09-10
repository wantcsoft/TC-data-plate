package com.tcsoft.setting.modifycontroller;


import com.tcsoft.setting.dao.InstrumentGroupDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.InstrumentGroupServiceImpl;
import com.tcsoft.setting.viewmodel.InstrumentGroupViewModel;
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
public class InstrumentGroupController extends
        BaseController<InstrumentGroupServiceImpl, InstrumentGroupDao, InstrumentGroupViewModel>{

    private Integer hospitalId;

    public InstrumentGroupController(InstrumentGroupServiceImpl service){
        super(service);
    }

    @PostMapping("/instrumentGroup")
    public ResultData<List<InstrumentGroupViewModel>> instrumentGroup(@RequestBody InstrumentGroupDao dao,
                                                             @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("InstrumentGroupID", dao.getInstrumentGroupId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<InstrumentGroupViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
