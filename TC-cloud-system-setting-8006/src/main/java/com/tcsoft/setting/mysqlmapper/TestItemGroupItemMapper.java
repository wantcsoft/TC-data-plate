package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.TestItemGroupItemDao;
import com.tcsoft.setting.viewmodel.TestItemGroupItemViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface TestItemGroupItemMapper extends BaseMapper<TestItemGroupItemDao> {

    @Select("select BSC_TestItemGroupItem.TestItemGroupID, BSC_TestItemGroupItem.TestItemID,\n" +
            "       BSC_TestItemGroup.GroupName, BSC_TestItemInfo.TestItemCode\n" +
            "from BSC_TestItemGroupItem, BSC_TestItemGroup, BSC_TestItemInfo\n" +
            "where BSC_TestItemGroupItem.TestItemGroupID=BSC_TestItemGroup.TestItemGroupID\n" +
            "and BSC_TestItemGroupItem.TestItemID=BSC_TestItemInfo.TestItemCode;")
    List<TestItemGroupItemViewModel> selectAll();

}
