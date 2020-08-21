package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.TestItemDuplicateDao;
import com.tcsoft.setting.mysqlmapper.TestItemDuplicateMapper;
import com.tcsoft.setting.service.TestItemDuplicateService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwq
 * @since 2020-07-31
 */
@Service
public class TestItemDuplicateServiceImpl
        extends ServiceImpl<TestItemDuplicateMapper, TestItemDuplicateDao>
        implements TestItemDuplicateService {

}
