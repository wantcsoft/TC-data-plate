package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.DataTypeDao;
import com.tcsoft.setting.mapper.DataTypeMapper;
import com.tcsoft.setting.service.DataTypeService;
import com.tcsoft.setting.viewmodel.DataTypeViewModel;
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
public class DataTypeServiceImpl extends ServiceImpl<DataTypeMapper, DataTypeDao>
        implements DataTypeService {

    public List<DataTypeViewModel> listViewModel(){
        return baseMapper.selectAll();
    }

}
