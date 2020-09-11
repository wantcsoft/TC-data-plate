package com.tcsoft.setting.controller.modify;

import com.tcsoft.setting.dao.InstrumentTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.InstrumentTypeServiceImpl;
import com.tcsoft.setting.viewmodel.InstrumentTypeViewModel;
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
public class InstrumentTypeController extends
        BaseController<InstrumentTypeServiceImpl, InstrumentTypeDao, InstrumentTypeViewModel>{

    private Integer hospitalId;

    public InstrumentTypeController(InstrumentTypeServiceImpl service){
        super(service);
    }

    @PostMapping("/instrumentType")
    public ResultData<List<InstrumentTypeViewModel>> instrumentType(@RequestBody InstrumentTypeDao dao,
                                                              @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("InstrumentTypeID", dao.getInstrumentTypeId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<InstrumentTypeViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
