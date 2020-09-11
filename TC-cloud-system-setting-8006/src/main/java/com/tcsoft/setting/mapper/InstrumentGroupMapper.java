package com.tcsoft.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.InstrumentGroupDao;
import com.tcsoft.setting.viewmodel.InstrumentGroupViewModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface InstrumentGroupMapper extends BaseMapper<InstrumentGroupDao> {

    @Select("select * from BSC_InstrumentGroup " +
            "where HospitalId = #{hospitalId}")
    List<InstrumentGroupViewModel> selectAll(@Param("hospitalId")Integer hospitalId);

}
