package com.tcsoft.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.TestItemGroupDao;
import com.tcsoft.setting.viewmodel.TestItemGroupViewModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface TestItemGroupMapper extends BaseMapper<TestItemGroupDao> {

    @Select("select BSC_TestItemGroup.TestItemGroupID, BSC_TestItemGroup.HospitalID,\n" +
            "       BSC_TestItemGroup.InstrumentGroupID, BSC_TestItemGroup.IsEnabled,\n" +
            "       BSC_TestItemGroup.Comment, BSC_TestItemGroup.GroupName,\n" +
            "       BSC_InstrumentGroup.InstrumentGroupName\n" +
            "from BSC_TestItemGroup, BSC_InstrumentGroup\n" +
            "where BSC_TestItemGroup.HospitalID = #{hospitalId}\n" +
            "and BSC_TestItemGroup.InstrumentGroupID=BSC_InstrumentGroup.InstrumentGroupID;")
    List<TestItemGroupViewModel> selectAll(@Param("hospitalId")Integer hospitalId);

}
