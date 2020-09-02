package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.tcsoft.setting.dao.ChemistryContrastDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.ChemistryContrastServiceImpl;
import com.tcsoft.setting.viewmodel.ChemistryContrastViewModel;
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
public class ChemistryContrastController extends
        BaseController<ChemistryContrastServiceImpl, ChemistryContrastDao, ChemistryContrastViewModel>{

    private Integer hospital;

    public ChemistryContrastController(ChemistryContrastServiceImpl service) {
        super(service);
    }

    @PostMapping("/chemistryContrast")
    public ResultData<List<ChemistryContrastViewModel>> chemistryContrast(@RequestBody ChemistryContrastDao dao,
                                                                    @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(4);
        deletedMap.put("HospitalID", dao.getHospitalId());
        deletedMap.put("TestItemID", dao.getTestItemId());
        deletedMap.put("SampleTypeID", dao.getSampleTypeId());
        deletedMap.put("InstrumentID", dao.getInstrumentId());
        hospital = dao.getHospitalId();
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public boolean modify(ChemistryContrastDao dao){
        try {
            service.update(dao, new UpdateWrapper<ChemistryContrastDao>()
                    .eq("HospitalID", dao.getHospitalId())
                    .eq("TestItemID", dao.getTestItemId())
                    .eq("SampleTypeID", dao.getSampleTypeId())
                    .eq("InstrumentID", dao.getInstrumentId()));
            return service.updateById(dao);
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<ChemistryContrastViewModel> query(){
        return service.listViewMode(hospital);
    }


}
