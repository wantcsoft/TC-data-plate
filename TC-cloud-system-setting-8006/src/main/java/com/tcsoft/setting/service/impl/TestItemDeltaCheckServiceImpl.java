package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.TestItemDeltaCheckDao;
import com.tcsoft.setting.mapper.TestItemDeltaCheckMapper;
import com.tcsoft.setting.service.TestItemDeltaCheckService;
import com.tcsoft.setting.viewmodel.TestItemDeltaCheckViewModel;
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
public class TestItemDeltaCheckServiceImpl
        extends ServiceImpl<TestItemDeltaCheckMapper, TestItemDeltaCheckDao>
        implements TestItemDeltaCheckService {

    public List<TestItemDeltaCheckViewModel> listViewModel(Integer hospitalId){
        return baseMapper.selectAll(hospitalId);
    }

}
