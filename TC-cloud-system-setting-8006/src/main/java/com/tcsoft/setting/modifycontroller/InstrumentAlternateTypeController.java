package com.tcsoft.setting.modifycontroller;

import com.tcsoft.setting.dao.InstrumentAlternateTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.InstrumentAlternateTypeServiceImpl;
import com.tcsoft.setting.viewmodel.InstrumentAlternateTypeViewModel;
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
public class InstrumentAlternateTypeController extends
        BaseController<InstrumentAlternateTypeServiceImpl, InstrumentAlternateTypeDao, InstrumentAlternateTypeViewModel> {

    public InstrumentAlternateTypeController(InstrumentAlternateTypeServiceImpl service){
        super(service);
    }

    @PostMapping("/instrumentAlternateType")
    public ResultData<List<InstrumentAlternateTypeViewModel>> instrumentAlternateType(@RequestBody InstrumentAlternateTypeDao dao,
                                                                     @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("InstrumentAlternateTypeID", dao.getInstrumentAlternateTypeId());
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<InstrumentAlternateTypeViewModel> query(){
        return service.listViewModel();
    }

}
