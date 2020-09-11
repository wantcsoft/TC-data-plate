package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.TestItemTypeDao;
import com.tcsoft.setting.mapper.TestItemTypeMapper;
import com.tcsoft.setting.service.TestItemTypeService;
import com.tcsoft.setting.viewmodel.TestItemTypeViewModel;
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
public class TestItemTypeServiceImpl extends ServiceImpl<TestItemTypeMapper, TestItemTypeDao>
        implements TestItemTypeService {

    public List<TestItemTypeViewModel> listViewModel(Integer hospitalId){
        return baseMapper.selectAll(hospitalId);
    }

}
