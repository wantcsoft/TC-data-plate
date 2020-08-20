package com.tcsoft.setting.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.setting.dao.ChemistryContrastDao;
import com.tcsoft.setting.dao.MaterialDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.MaterialServiceImpl;
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
public class MaterialController extends BaseController<MaterialServiceImpl, MaterialDao>{

    public MaterialController(MaterialServiceImpl service) {
        super(service);
    }

    @PostMapping("/material")
    public ResultData<List<MaterialDao>> material(@RequestBody MaterialDao dao,
                                                  @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("MaterialID", dao.getMaterialId());
        queryWrapper = new QueryWrapper<MaterialDao>()
                .eq("HospitalID", dao.getHospitalId());
        return handleRequest(dao, type, deletedMap);
    }
}