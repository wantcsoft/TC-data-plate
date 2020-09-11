package com.tcsoft.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.TestItemGroupItemDao;
import com.tcsoft.setting.viewmodel.TestItemGroupItemViewModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface TestItemGroupItemMapper extends BaseMapper<TestItemGroupItemDao> {

    @Select("select BSC_TestItemGroupItem.TestItemGroupID, BSC_TestItemGroupItem.TestItemID,\n" +
            "       BSC_TestItemGroup.GroupName, BSC_TestItemInfo.TestItemName,\n" +
            "       BSC_TestItemGroupItem.HospitalID\n" +
            "from BSC_TestItemGroupItem, BSC_TestItemGroup, BSC_TestItemInfo\n" +
            "where BSC_TestItemGroupItem.HospitalID = #{hospitalId}\n" +
            "and BSC_TestItemGroupItem.TestItemGroupID=BSC_TestItemGroup.TestItemGroupID\n" +
            "and BSC_TestItemGroupItem.TestItemID=BSC_TestItemInfo.TestItemID;")
    List<TestItemGroupItemViewModel> selectAll(@Param("hospitalId")Integer hospitalId);

}
