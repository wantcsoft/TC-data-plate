package com.tcsoft.setting.controller.modify;


import com.tcsoft.setting.dao.PatientTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.PatientTypeServiceImpl;
import com.tcsoft.setting.viewmodel.PatientTypeViewModel;
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
public class PatientTypeController extends
        BaseController<PatientTypeServiceImpl, PatientTypeDao, PatientTypeViewModel>{

    private Integer hospitalId;

    public PatientTypeController(PatientTypeServiceImpl service){
        super(service);
    }

    @PostMapping("/patientType")
    public ResultData<List<PatientTypeViewModel>> patientType(@RequestBody PatientTypeDao dao,
                                                              @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("PatientTypeID", dao.getPatientTypeId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<PatientTypeViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
