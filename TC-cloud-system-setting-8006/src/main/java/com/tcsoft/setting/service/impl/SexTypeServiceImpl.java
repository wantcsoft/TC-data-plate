package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.SexTypeDao;
import com.tcsoft.setting.mysqlmapper.SexTypeMapper;
import com.tcsoft.setting.service.SexTypeService;
import com.tcsoft.setting.viewmodel.SexTypeViewModel;
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
public class SexTypeServiceImpl extends ServiceImpl<SexTypeMapper, SexTypeDao>
        implements SexTypeService {

    public List<SexTypeViewModel> listViewModel(){
        return baseMapper.selectAll();
    }

}
