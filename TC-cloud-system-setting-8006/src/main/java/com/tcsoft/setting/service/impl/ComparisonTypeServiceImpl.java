package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.ComparisonTypeDao;
import com.tcsoft.setting.mysqlmapper.ComparisonTypeMapper;
import com.tcsoft.setting.service.ComparisonTypeService;
import com.tcsoft.setting.viewmodel.ComparisonTypeViewModel;
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
public class ComparisonTypeServiceImpl extends ServiceImpl<ComparisonTypeMapper, ComparisonTypeDao>
        implements ComparisonTypeService {

    public List<ComparisonTypeViewModel> listViewModel(){
        return baseMapper.selectAll();
    }

}
