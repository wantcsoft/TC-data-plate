package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.ResultTypeDao;
import com.tcsoft.setting.mysqlmapper.ResultTypeMapper;
import com.tcsoft.setting.service.ResultTypeService;
import com.tcsoft.setting.viewmodel.ResultTypeViewModel;
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
public class ResultTypeServiceImpl extends ServiceImpl<ResultTypeMapper, ResultTypeDao>
        implements ResultTypeService {

    public List<ResultTypeViewModel> listViewModel(){
        return baseMapper.selectAll();
    }

}
