package com.tcsoft.sample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.sample.dao.ResultDao;
import com.tcsoft.sample.mapper.ResultMapper;
import com.tcsoft.sample.service.ResultService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WMY
 * @since 2020-08-10
 */
@Service
public class ResultServiceImpl extends ServiceImpl<ResultMapper, ResultDao> implements ResultService {

}
