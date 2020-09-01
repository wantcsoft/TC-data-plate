package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.TestItemGroupItemDao;
import com.tcsoft.setting.mysqlmapper.TestItemGroupItemMapper;
import com.tcsoft.setting.service.TestItemGroupItemService;
import com.tcsoft.setting.viewmodel.TestItemGroupItemViewModel;
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
public class TestItemGroupItemServiceImpl
        extends ServiceImpl<TestItemGroupItemMapper, TestItemGroupItemDao>
        implements TestItemGroupItemService {

    public List<TestItemGroupItemViewModel> listViewModel(){
        return baseMapper.selectAll();
    }

}
