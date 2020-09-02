package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.RuleDao;
import com.tcsoft.setting.mysqlmapper.RuleMapper;
import com.tcsoft.setting.service.RuleService;
import com.tcsoft.setting.viewmodel.RuleViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwq
 * @since 2020-07-31
 */
@Service
public class RuleServiceImpl extends ServiceImpl<RuleMapper, RuleDao>
        implements RuleService {

    public List<RuleViewModel> listViewModel(Integer hospitalId){
        return baseMapper.selectAll(hospitalId);
    }

}
