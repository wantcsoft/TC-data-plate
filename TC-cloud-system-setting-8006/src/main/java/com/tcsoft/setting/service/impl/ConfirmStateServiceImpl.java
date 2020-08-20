package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.ConfirmStateDao;
import com.tcsoft.setting.mapper.ConfirmStateMapper;
import com.tcsoft.setting.service.ConfirmStateService;
import org.springframework.stereotype.Service;

/**
 * @author WMY
 */
@Service
public class ConfirmStateServiceImpl extends ServiceImpl<ConfirmStateMapper, ConfirmStateDao>
        implements ConfirmStateService {
}
