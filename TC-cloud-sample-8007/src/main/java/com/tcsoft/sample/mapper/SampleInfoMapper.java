package com.tcsoft.sample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.sample.dao.SampleInfoDao;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author WMY
 * @since 2020-08-10
 */
@Mapper
public interface SampleInfoMapper extends BaseMapper<SampleInfoDao> {

}
