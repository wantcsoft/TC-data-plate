package com.tcsoft.setting.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.dao.LineTypeDao;
import com.tcsoft.setting.mapper.LineTypeMapper;
import com.tcsoft.setting.service.LineTypeService;
import org.springframework.stereotype.Service;

/**
 * @author WMY
 */
@Service
public class LineTypeServiceImpl extends ServiceImpl<LineTypeMapper, LineTypeDao>
        implements LineTypeService {
}
