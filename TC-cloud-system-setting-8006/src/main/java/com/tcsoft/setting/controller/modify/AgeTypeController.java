package com.tcsoft.setting.controller.modify;

import com.tcsoft.setting.dao.AgeTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.AgeTypeServiceImpl;
import com.tcsoft.setting.viewmodel.AgeTypeViewModel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WMY
 */
@RestController
public class AgeTypeController extends
        BaseController<AgeTypeServiceImpl, AgeTypeDao, AgeTypeViewModel> {

    private Integer hospitalId;

    public AgeTypeController(AgeTypeServiceImpl ageTypeService) {
        super(ageTypeService);
    }

    @PostMapping("/ageType")
    public ResultData<List<AgeTypeViewModel>> ageType(@RequestBody AgeTypeDao dao,
                                                      @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("AgeTypeID", dao.getAgeTypeId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<AgeTypeViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
