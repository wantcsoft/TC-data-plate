package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.ChemistryContrastDao;
import com.tcsoft.setting.mysqlmapper.ChemistryContrastMapper;
import com.tcsoft.setting.service.ChemistryContrastService;
import com.tcsoft.setting.viewmodel.ChemistryContrastViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WMY
 */
@Service
public class ChemistryContrastServiceImpl extends ServiceImpl<ChemistryContrastMapper, ChemistryContrastDao>
        implements ChemistryContrastService {

    public List<ChemistryContrastViewModel> listViewMode(Integer hospitalId) {
        return baseMapper.selectByHospitalId(hospitalId);
    }
}
