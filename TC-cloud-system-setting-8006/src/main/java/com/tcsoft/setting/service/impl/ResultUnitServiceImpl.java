package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.ResultUnitDao;
import com.tcsoft.setting.mapper.ResultUnitMapper;
import com.tcsoft.setting.service.ResultUnitService;
import com.tcsoft.setting.viewmodel.ResultUnitViewModel;
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
public class ResultUnitServiceImpl extends ServiceImpl<ResultUnitMapper, ResultUnitDao>
        implements ResultUnitService {

    public List<ResultUnitViewModel> listViewModel(Integer hospitalId){
        return baseMapper.selectAll(hospitalId);
    }

}
