package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.RuleFunctionDao;
import com.tcsoft.setting.mysqlmapper.RuleFunctionMapper;
import com.tcsoft.setting.service.RuleFunctionService;
import com.tcsoft.setting.viewmodel.RuleFunctionViewModel;
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
public class RuleFunctionServiceImpl extends ServiceImpl<RuleFunctionMapper, RuleFunctionDao>
        implements RuleFunctionService {

    public List<RuleFunctionViewModel> listViewModel(){
        return baseMapper.selectAll();
    }

}
