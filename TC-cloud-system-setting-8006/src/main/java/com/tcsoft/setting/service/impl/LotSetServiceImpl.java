package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.LotSetDao;
import com.tcsoft.setting.mysqlmapper.LotSetMapper;
import com.tcsoft.setting.service.LotSetService;
import org.springframework.stereotype.Service;


/**
 * @author WMY
 */
@Service
public class LotSetServiceImpl extends ServiceImpl<LotSetMapper, LotSetDao>
        implements LotSetService {
}
