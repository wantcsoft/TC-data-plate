package com.tcsoft.setting.controller.modify;


import com.tcsoft.setting.dao.ResultRangeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.ResultRangeServiceImpl;
import com.tcsoft.setting.viewmodel.ResultRangeViewModel;
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
public class ResultRangeController extends
        BaseController<ResultRangeServiceImpl, ResultRangeDao, ResultRangeViewModel>{

    private Integer hospitalId;

    public ResultRangeController(ResultRangeServiceImpl service){
        super(service);
    }

    @PostMapping("/resultRange")
    public ResultData<List<ResultRangeViewModel>> resultRange(@RequestBody ResultRangeDao dao,
                                                              @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("ResultRangeID", dao.getResultRangeId());
        hospitalId = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<ResultRangeViewModel> query(){
        return service.listViewModel(hospitalId);
    }

}
