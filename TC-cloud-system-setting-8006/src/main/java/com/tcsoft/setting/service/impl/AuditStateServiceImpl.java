package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.AuditStateDao;
import com.tcsoft.setting.mapper.AuditStateMapper;
import com.tcsoft.setting.service.AuditStateService;
import com.tcsoft.setting.viewmodel.AuditStateViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WMY
 */
@Service
public class AuditStateServiceImpl extends ServiceImpl<AuditStateMapper, AuditStateDao>
        implements AuditStateService {

    public List<AuditStateViewModel> listViewModel(){
        return baseMapper.selectAll();
    }

}
