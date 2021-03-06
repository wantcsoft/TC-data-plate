package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.SampleTypeDao;
import com.tcsoft.setting.mapper.SampleTypeMapper;
import com.tcsoft.setting.service.SampleTypeService;
import com.tcsoft.setting.viewmodel.SampleTypeViewModel;
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
public class SampleTypeServiceImpl extends ServiceImpl<SampleTypeMapper, SampleTypeDao>
        implements SampleTypeService {

    public List<SampleTypeViewModel> listViewModel(Integer hospitalId) {
        return baseMapper.selectByHospitalId(hospitalId);
    }

}
