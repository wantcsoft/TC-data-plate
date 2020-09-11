package com.tcsoft.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.InstrumentAlternateTypeDao;
import com.tcsoft.setting.viewmodel.InstrumentAlternateTypeViewModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface InstrumentAlternateTypeMapper extends BaseMapper<InstrumentAlternateTypeDao> {

    @Select("select * from BSC_InstrumentAlternateType")
    List<InstrumentAlternateTypeViewModel> selectAll();

}
