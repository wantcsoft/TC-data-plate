package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.PrepLinkAbortCodeDao;
import com.tcsoft.setting.mysqlmapper.PrepLinkAbortCodeMapper;
import com.tcsoft.setting.service.PrepLinkAbortCodeService;
import com.tcsoft.setting.viewmodel.PrepLinkAbortCodeViewModel;
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
public class PrepLinkAbortCodeServiceImpl
        extends ServiceImpl<PrepLinkAbortCodeMapper, PrepLinkAbortCodeDao>
        implements PrepLinkAbortCodeService {

    public List<PrepLinkAbortCodeViewModel> listViewModel(Integer hospitalId){
        return baseMapper.selectAll(hospitalId);
    }

}
