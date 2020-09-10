package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.TestItemInfoDao;
import com.tcsoft.setting.mysqlmapper.TestItemInfoMapper;
import com.tcsoft.setting.service.TestItemInfoService;
import com.tcsoft.setting.viewmodel.TestItemInfoViewModel;
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
public class TestItemInfoServiceImpl extends ServiceImpl<TestItemInfoMapper, TestItemInfoDao>
        implements TestItemInfoService {

    public List<TestItemInfoViewModel> listViewModel(Integer hospitalId) {
        return baseMapper.selectByHospitalId(hospitalId);
    }

}
