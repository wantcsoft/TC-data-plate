package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.ComparisonInfoDao;
import com.tcsoft.setting.mysqlmapper.ComparisonInfoMapper;
import com.tcsoft.setting.service.ComparisonInfoService;
import com.tcsoft.setting.viewmodel.ComparisonInfoViewModel;
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
public class ComparisonInfoServiceImpl extends ServiceImpl<ComparisonInfoMapper, ComparisonInfoDao>
        implements ComparisonInfoService {

    public List<ComparisonInfoViewModel> listViewModel(){
        return baseMapper.selectAll();
    }

}
