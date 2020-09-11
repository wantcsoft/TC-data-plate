package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.SampleStateDao;
import com.tcsoft.setting.mapper.SampleStateMapper;
import com.tcsoft.setting.service.SampleStateService;
import com.tcsoft.setting.viewmodel.SampleStateViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WMY
 */
@Service
public class SampleStateServiceImpl extends ServiceImpl<SampleStateMapper, SampleStateDao>
        implements SampleStateService {

    public List<SampleStateViewModel> listViewModel(){
        return baseMapper.selectAll();
    }
}
