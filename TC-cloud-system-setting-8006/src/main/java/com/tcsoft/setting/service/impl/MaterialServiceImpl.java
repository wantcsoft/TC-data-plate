package com.tcsoft.setting.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.MaterialDao;
import com.tcsoft.setting.mysqlmapper.MaterialMapper;
import com.tcsoft.setting.service.MaterialService;
import com.tcsoft.setting.viewmodel.MaterialViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WMY
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, MaterialDao>
        implements MaterialService {

    public List<MaterialViewModel> listViewModel(Integer hospitalId){
        return baseMapper.selectAll(hospitalId);
    }
}
