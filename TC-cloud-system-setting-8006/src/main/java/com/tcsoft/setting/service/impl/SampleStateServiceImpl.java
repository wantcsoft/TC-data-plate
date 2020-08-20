package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.SampleStateDao;
import com.tcsoft.setting.mapper.SampleStateMapper;
import com.tcsoft.setting.service.SampleStateService;
import org.springframework.stereotype.Service;

/**
 * @author WMY
 */
@Service
public class SampleStateServiceImpl extends ServiceImpl<SampleStateMapper, SampleStateDao>
        implements SampleStateService {
}
