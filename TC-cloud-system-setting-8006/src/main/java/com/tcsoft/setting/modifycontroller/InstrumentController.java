package com.tcsoft.setting.modifycontroller;


import com.tcsoft.setting.dao.InstrumentDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.InstrumentServiceImpl;
import com.tcsoft.setting.viewmodel.InstrumentViewModel;
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
public class InstrumentController extends
        BaseController<InstrumentServiceImpl, InstrumentDao, InstrumentViewModel> {

    private Integer hospitalId;

    public InstrumentController(InstrumentServiceImpl service){
        super(service);
    }

    @PostMapping("/instrument")
    public ResultData<List<InstrumentViewModel>> instrument(@RequestBody InstrumentDao dao,
                                                        @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("InstrumentID", dao.getInstrumentId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<InstrumentViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
