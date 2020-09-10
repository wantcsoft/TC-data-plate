package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.TestItemDeltaCheckDao;
import com.tcsoft.setting.viewmodel.TestItemDeltaCheckViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface TestItemDeltaCheckMapper extends BaseMapper<TestItemDeltaCheckDao> {

    @Select("select BSC_TestItemDeltaCheck.TestItemID, BSC_TestItemDeltaCheck.HospitalID,\n" +
            "       BSC_TestItemDeltaCheck.Formula, BSC_TestItemDeltaCheck.DayRange,\n" +
            "       BSC_TestItemInfo.TestItemName\n" +
            "from BSC_TestItemDeltaCheck, BSC_TestItemInfo\n" +
            "where BSC_TestItemDeltaCheck.HospitalID = #{hospitalId}\n" +
            "and BSC_TestItemInfo.IsDeleted = false\n" +
            "and BSC_TestItemDeltaCheck.TestItemID = BSC_TestItemInfo.TestItemID;")
    List<TestItemDeltaCheckViewModel> selectAll(@Param("hospitalId")Integer hospitalId);

}
