package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.ActionCodeDao;
import com.tcsoft.setting.mapper.ActionCodeMapper;
import com.tcsoft.setting.service.ActionCodeService;
import com.tcsoft.setting.viewmodel.ActionCodeViewModel;
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
public class ActionCodeServiceImpl extends ServiceImpl<ActionCodeMapper, ActionCodeDao>
        implements ActionCodeService {

    public List<ActionCodeViewModel> listViewModel(Integer hospitalId) {
        return baseMapper.selectByHospitalId(hospitalId);
    }

}
