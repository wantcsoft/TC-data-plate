package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.InstrumentGroupDao;
import com.tcsoft.setting.mapper.InstrumentGroupMapper;
import com.tcsoft.setting.service.InstrumentGroupService;
import com.tcsoft.setting.viewmodel.InstrumentGroupViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwq
 * @since 2020-07-31
 */
@Service
public class InstrumentGroupServiceImpl
        extends ServiceImpl<InstrumentGroupMapper, InstrumentGroupDao>
        implements InstrumentGroupService {

    public List<InstrumentGroupViewModel> listViewModel(Integer hospitalId){
        return baseMapper.selectAll(hospitalId);
    }

}
