package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.TestItemGroupDao;
import com.tcsoft.setting.mysqlmapper.TestItemGroupMapper;
import com.tcsoft.setting.service.TestItemGroupService;
import com.tcsoft.setting.viewmodel.TestItemGroupViewModel;
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
public class TestItemGroupServiceImpl extends ServiceImpl<TestItemGroupMapper, TestItemGroupDao>
        implements TestItemGroupService {

    public List<TestItemGroupViewModel> listViewModel(Integer hospitalId){
        return baseMapper.selectAll(hospitalId);
    }

}
