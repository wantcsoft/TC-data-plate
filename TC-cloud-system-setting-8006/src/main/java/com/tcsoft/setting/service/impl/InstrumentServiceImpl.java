package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.InstrumentDao;
import com.tcsoft.setting.mapper.InstrumentMapper;
import com.tcsoft.setting.service.InstrumentService;
import com.tcsoft.setting.viewmodel.InstrumentViewModel;
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
public class InstrumentServiceImpl extends ServiceImpl<InstrumentMapper, InstrumentDao>
        implements InstrumentService {

    public List<InstrumentViewModel> listViewModel(Integer hospitalId) {
        return baseMapper.selectByHospitalId(hospitalId);
    }

}
