package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.SampleEventDao;
import com.tcsoft.setting.mysqlmapper.SampleEventMapper;
import com.tcsoft.setting.service.SampleEventService;
import com.tcsoft.setting.viewmodel.SampleEventViewModel;
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
public class SampleEventServiceImpl extends ServiceImpl<SampleEventMapper, SampleEventDao>
        implements SampleEventService {

    public List<SampleEventViewModel> listViewModel(){
        return baseMapper.selectAll();
    }

}
