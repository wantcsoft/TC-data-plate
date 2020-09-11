package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.RuleParamDao;
import com.tcsoft.setting.mapper.RuleParamMapper;
import com.tcsoft.setting.service.RuleParamService;
import com.tcsoft.setting.viewmodel.RuleParamViewModel;
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
public class RuleParamServiceImpl extends ServiceImpl<RuleParamMapper, RuleParamDao>
        implements RuleParamService {

    public List<RuleParamViewModel> listViewModel(){
        return baseMapper.selectAll();
    }

}
