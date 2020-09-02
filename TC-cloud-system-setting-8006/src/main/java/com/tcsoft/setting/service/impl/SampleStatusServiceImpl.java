package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.SampleStatusDao;
import com.tcsoft.setting.mysqlmapper.SampleStatusMapper;
import com.tcsoft.setting.service.SampleStatusService;
import com.tcsoft.setting.viewmodel.SampleStatusViewModel;
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
public class SampleStatusServiceImpl extends ServiceImpl<SampleStatusMapper, SampleStatusDao>
        implements SampleStatusService {

    public List<SampleStatusViewModel> listViewModel(){
        return baseMapper.selectAll();
    }

}
