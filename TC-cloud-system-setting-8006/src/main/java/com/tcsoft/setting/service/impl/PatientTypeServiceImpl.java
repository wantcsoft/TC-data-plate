package com.tcsoft.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.PatientTypeDao;
import com.tcsoft.setting.mapper.PatientTypeMapper;
import com.tcsoft.setting.service.PatientTypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwq
 * @since 2020-07-31
 */
@Service
public class PatientTypeServiceImpl extends ServiceImpl<PatientTypeMapper, PatientTypeDao>
        implements PatientTypeService {

}
