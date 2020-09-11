package com.tcsoft.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.TestItemInfoDao;
import com.tcsoft.setting.viewmodel.TestItemInfoViewModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface TestItemInfoMapper extends BaseMapper<TestItemInfoDao> {

    @Select("select BSC_TestItemInfo.TestItemID, BSC_TestItemInfo.HospitalID,\n" +
            "       BSC_TestItemInfo.TestItemTypeID, BSC_TestItemInfo.DataTypeID,\n" +
            "       BSC_TestItemInfo.UnitID, BSC_TestItemInfo.TestItemCode,\n" +
            "       BSC_TestItemInfo.TestItemName, BSC_TestItemInfo.Accuracy,\n" +
            "       BSC_TestItemInfo.PrintOrder, BSC_TestItemInfo.IsSexRelated,\n" +
            "       BSC_TestItemInfo.IsSampleTypeRelated, BSC_TestItemInfo.IsOrdac,\n" +
            "       BSC_TestItemInfo.IsQCItem, BSC_TestItemInfo.IsAgeRelated,\n" +
            "       BSC_TestItemInfo.IsProgrammed, BSC_TestItemInfo.IsEnabled,\n" +
            "       BSC_TestItemInfo.IsDeleted, BSC_TestItemType.TestItemTypeName,\n" +
            "       BSC_DataType.DataTypeName, BSC_ResultUnit.ResultUnit\n" +
            "from BSC_TestItemInfo, BSC_TestItemType, BSC_DataType, BSC_ResultUnit\n" +
            "where BSC_TestItemInfo.HospitalID = 1\n" +
            "and BSC_TestItemInfo.IsDeleted = false\n" +
            "and BSC_TestItemInfo.TestItemTypeID = BSC_TestItemType.TestItemTypeID\n" +
            "and BSC_TestItemInfo.DataTypeID = BSC_DataType.DataTypeID\n" +
            "and BSC_TestItemInfo.UnitID = BSC_ResultUnit.ResultUnitID;")
    List<TestItemInfoViewModel> selectByHospitalId(@Param("hospitalId") Integer hospitalId);

}
