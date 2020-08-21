package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.InstrumentAlternateTypeDao;
import com.tcsoft.setting.mysqlmapper.InstrumentAlternateTypeMapper;
import com.tcsoft.setting.service.InstrumentAlternateTypeService;
import com.tcsoft.setting.viewmodel.InstrumentAlternateTypeViewModel;
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
public class InstrumentAlternateTypeServiceImpl
        extends ServiceImpl<InstrumentAlternateTypeMapper, InstrumentAlternateTypeDao>
        implements InstrumentAlternateTypeService {

    public List<InstrumentAlternateTypeViewModel> listViewModel(){
        return baseMapper.selectAll();
    }

}
