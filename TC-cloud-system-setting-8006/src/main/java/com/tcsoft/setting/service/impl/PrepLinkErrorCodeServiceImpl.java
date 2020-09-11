package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.PrepLinkErrorCodeDao;
import com.tcsoft.setting.mapper.PrepLinkErrorCodeMapper;
import com.tcsoft.setting.service.PrepLinkErrorCodeService;
import com.tcsoft.setting.viewmodel.PrepLinkErrorCodeViewModel;
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
public class PrepLinkErrorCodeServiceImpl
        extends ServiceImpl<PrepLinkErrorCodeMapper, PrepLinkErrorCodeDao>
        implements PrepLinkErrorCodeService {

    public List<PrepLinkErrorCodeViewModel> listViewModel(Integer hospitalId){
        return baseMapper.selectAll(hospitalId);
    }

}
