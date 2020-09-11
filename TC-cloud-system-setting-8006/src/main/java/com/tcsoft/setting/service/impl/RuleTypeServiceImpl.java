package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.RuleTypeDao;
import com.tcsoft.setting.mapper.RuleTypeMapper;
import com.tcsoft.setting.service.RuleTypeService;
import com.tcsoft.setting.viewmodel.RuleTypeViewModel;
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
public class RuleTypeServiceImpl extends ServiceImpl<RuleTypeMapper, RuleTypeDao>
        implements RuleTypeService {

    public List<RuleTypeViewModel> listViewModel(){
        return baseMapper.selectAll();
    }

}
