package com.tcsoft.sample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.sample.entity.InfoFromThird;
import com.tcsoft.sample.mapper.InfoFromThirdMapper;
import com.tcsoft.sample.service.InfoFromThirdService;
import org.springframework.stereotype.Service;

/**
 * @author WMY
 */
@Service
public class InfoFromThirdServiceImpl extends ServiceImpl<InfoFromThirdMapper, InfoFromThird>
        implements InfoFromThirdService {
}
