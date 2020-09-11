package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.LotSetDao;
import com.tcsoft.setting.mapper.LotSetMapper;
import com.tcsoft.setting.service.LotSetService;
import com.tcsoft.setting.viewmodel.LotSetViewModel;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author WMY
 */
@Service
public class LotSetServiceImpl extends ServiceImpl<LotSetMapper, LotSetDao>
        implements LotSetService {

    public List<LotSetViewModel> listViewModel(Integer hospitalId){
        return baseMapper.selectAll(hospitalId);
    }
}
