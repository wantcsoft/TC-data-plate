package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.SampleStateDao;
import com.tcsoft.setting.viewmodel.SampleStateViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface SampleStateMapper extends BaseMapper<SampleStateDao> {

    @Select("select BSC_SampleState.SampleStateID, BSC_SampleState.ParentSampleState,\n" +
            "       BSC_SampleState.SampleStateName, BSC_SampleState.IsSamplePosition,\n" +
            "       BSC_SampleState.InstrumentRelated, BSC_SampleState.DisplayOrder,\n" +
            "       BSC_SampleState.StateDisplayName, BSC_SampleState.DefaultDisplayName,\n" +
            "       BSC_SampleState.BindInstrumentID\n" +
            "from BSC_SampleState;")
    List<SampleStateViewModel> selectAll();
}
