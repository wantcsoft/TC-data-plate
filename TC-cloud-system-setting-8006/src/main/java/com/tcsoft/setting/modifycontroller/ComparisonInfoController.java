package com.tcsoft.setting.modifycontroller;


import com.tcsoft.setting.dao.ComparisonInfoDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.ComparisonInfoServiceImpl;
import com.tcsoft.setting.viewmodel.ComparisonInfoViewModel;
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
public class ComparisonInfoController extends
        BaseController<ComparisonInfoServiceImpl, ComparisonInfoDao, ComparisonInfoViewModel> {

    private Integer hospitalId;

    public ComparisonInfoController(ComparisonInfoServiceImpl service){
        super(service);
    }

    @PostMapping("/comparisonInfo")
    public ResultData<List<ComparisonInfoViewModel>> comparisonInfo(@RequestBody ComparisonInfoDao dao,
                                                       @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(4);
        deletedMap.put("HospitalId", dao.getHospitalId());
        deletedMap.put("InstrumentTypeID", dao.getInstrumentTypeId());
        deletedMap.put("ComparisonTypeID", dao.getComparisonTypeId());
        deletedMap.put("InstrumentInfo", dao.getInstrumentInfo());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<ComparisonInfoViewModel> query(){
        System.out.println("hospital" + hospitalId);
        return service.listViewModel(hospitalId);
    }

}
