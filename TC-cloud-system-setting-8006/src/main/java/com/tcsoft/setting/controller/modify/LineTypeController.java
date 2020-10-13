package com.tcsoft.setting.controller.modify;


import com.tcsoft.setting.dao.LineTypeDao;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.service.impl.LineTypeServiceImpl;
import com.tcsoft.setting.viewmodel.LineTypeViewModel;
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
public class LineTypeController extends
        BaseController<LineTypeServiceImpl, LineTypeDao, LineTypeViewModel>{

    public LineTypeController(LineTypeServiceImpl service) {
        super(service);
    }

    @PostMapping("/lineType")
    public ResultData<List<LineTypeViewModel>> lineType(@RequestBody LineTypeDao dao,
                                                        @RequestParam String type){
        Map<String, Object> deletedMap = new HashMap<>(1);
        deletedMap.put("LineTypeId", dao.getLineTypeId());
        return handleRequest(dao, type, deletedMap);
    }

    @Override
    public List<LineTypeViewModel> query(){
        return service.listViewModel();
    }
}
