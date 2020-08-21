package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.TestItemTypeDao;
import com.tcsoft.setting.mysqlmapper.TestItemTypeMapper;
import com.tcsoft.setting.service.TestItemTypeService;
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
public class TestItemTypeServiceImpl extends ServiceImpl<TestItemTypeMapper, TestItemTypeDao>
        implements TestItemTypeService {

}
