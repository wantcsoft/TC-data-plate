package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.AgeTypeDao;
import com.tcsoft.setting.mysqlmapper.AgeTypeMapper;
import com.tcsoft.setting.service.AgeTypeService;
import com.tcsoft.setting.viewmodel.AgeTypeViewModel;
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
public class AgeTypeServiceImpl extends ServiceImpl<AgeTypeMapper, AgeTypeDao>
        implements AgeTypeService {

    public List<AgeTypeViewModel> listViewMode(Integer hospitalId) {
        return baseMapper.selectByHospitalId(hospitalId);
    }

}
