package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.InstrumentTypeDao;
import com.tcsoft.setting.mapper.InstrumentTypeMapper;
import com.tcsoft.setting.service.InstrumentTypeService;
import com.tcsoft.setting.viewmodel.InstrumentTypeViewModel;
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
public class InstrumentTypeServiceImpl extends ServiceImpl<InstrumentTypeMapper, InstrumentTypeDao>
        implements InstrumentTypeService {

    public List<InstrumentTypeViewModel> listViewModel(Integer hospital){
        return baseMapper.selectAll(hospital);
    }

}
