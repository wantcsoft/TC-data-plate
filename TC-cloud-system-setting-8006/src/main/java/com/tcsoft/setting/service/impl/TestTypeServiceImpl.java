package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.TestTypeDao;
import com.tcsoft.setting.mysqlmapper.TestTypeMapper;
import com.tcsoft.setting.service.TestTypeService;
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
public class TestTypeServiceImpl extends ServiceImpl<TestTypeMapper, TestTypeDao>
        implements TestTypeService {

}
