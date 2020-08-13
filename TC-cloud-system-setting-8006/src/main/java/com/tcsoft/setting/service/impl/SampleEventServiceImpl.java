package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.SampleEventDao;
import com.tcsoft.setting.mapper.SampleEventMapper;
import com.tcsoft.setting.service.SampleEventService;
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
public class SampleEventServiceImpl extends ServiceImpl<SampleEventMapper, SampleEventDao>
        implements SampleEventService {

}