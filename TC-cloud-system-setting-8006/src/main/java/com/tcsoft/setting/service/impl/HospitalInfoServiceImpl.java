package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.HospitalInfoDao;
import com.tcsoft.setting.mysqlmapper.HospitalInfoMapper;
import com.tcsoft.setting.service.HospitalInfoService;
import com.tcsoft.setting.viewmodel.HospitalInfoViewModel;
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
public class HospitalInfoServiceImpl extends ServiceImpl<HospitalInfoMapper, HospitalInfoDao>
        implements HospitalInfoService {

    public List<HospitalInfoViewModel> listViewMode() {
        return baseMapper.selectAll();
    }

}
