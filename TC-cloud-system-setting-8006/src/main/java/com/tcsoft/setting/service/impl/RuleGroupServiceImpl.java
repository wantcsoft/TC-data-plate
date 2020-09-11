package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.RuleGroupDao;
import com.tcsoft.setting.mapper.RuleGroupMapper;
import com.tcsoft.setting.service.RuleGroupService;
import com.tcsoft.setting.viewmodel.RuleGroupViewModel;
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
public class RuleGroupServiceImpl extends ServiceImpl<RuleGroupMapper, RuleGroupDao>
        implements RuleGroupService {

    public List<RuleGroupViewModel> listViewModel(Integer hospitalId){
        return baseMapper.selectAll(hospitalId);
    }

}
