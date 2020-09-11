package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.ResultRangeDao;
import com.tcsoft.setting.mapper.ResultRangeMapper;
import com.tcsoft.setting.service.ResultRangeService;
import com.tcsoft.setting.viewmodel.ResultRangeViewModel;
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
public class ResultRangeServiceImpl extends ServiceImpl<ResultRangeMapper, ResultRangeDao>
        implements ResultRangeService {

    public List<ResultRangeViewModel> listViewModel(Integer hospitalId){
        return baseMapper.selectAll(hospitalId);
    }

}
