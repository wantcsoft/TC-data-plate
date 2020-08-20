package com.tcsoft.setting.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.MaterialDao;
import com.tcsoft.setting.mapper.MaterialMapper;
import com.tcsoft.setting.service.MaterialService;
import org.springframework.stereotype.Service;

/**
 * @author WMY
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, MaterialDao>
        implements MaterialService {
}
