package com.tcsoft.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.SampleEventDao;
import com.tcsoft.setting.viewmodel.SampleEventViewModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface SampleEventMapper extends BaseMapper<SampleEventDao> {

    @Select("select * from BSC_SampleEvent;")
    List<SampleEventViewModel> selectAll();

}
