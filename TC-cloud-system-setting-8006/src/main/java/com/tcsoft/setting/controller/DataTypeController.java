package com.tcsoft.setting.controller;


import com.tcsoft.setting.dao.DataTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.DataTypeServiceImpl;
import com.tcsoft.setting.viewmodel.DataTypeViewModel;
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
public class DataTypeController extends
        BaseController<DataTypeServiceImpl, DataTypeDao, DataTypeViewModel> {

    public DataTypeController(DataTypeServiceImpl service){
        super(service);
    }

    @PostMapping("/dataType")
    public ResultData<List<DataTypeViewModel>> dataType(@RequestBody DataTypeDao dao,
                                                  @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("DataTypeID", dao.getDataTypeId());
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<DataTypeViewModel> query(){
        return service.listViewModel();
    }

}
