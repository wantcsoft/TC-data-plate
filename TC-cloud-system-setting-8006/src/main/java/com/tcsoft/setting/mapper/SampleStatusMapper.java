package com.tcsoft.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.SampleStatusDao;
import com.tcsoft.setting.viewmodel.SampleStatusViewModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface SampleStatusMapper extends BaseMapper<SampleStatusDao> {

    @Select("select SampleStatusID, SampleStatusName, StatusFlag,\n" +
            "       ParentStatusID, InstrumentRelated\n" +
            "from BSC_SampleStatus;")
    List<SampleStatusViewModel> selectAll();

}
