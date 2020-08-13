package com.tcsoft.sample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.sample.dao.SampleInfoDao;
import com.tcsoft.sample.mapper.SampleInfoMapper;
import com.tcsoft.sample.service.SampleInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WMY
 * @since 2020-08-10
 */
@Service
public class SampleInfoServiceImpl extends ServiceImpl<SampleInfoMapper, SampleInfoDao> implements SampleInfoService {

}
