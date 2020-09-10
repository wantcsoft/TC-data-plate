package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.ChemistryContrastDao;
import com.tcsoft.setting.viewmodel.ChemistryContrastViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface ChemistryContrastMapper extends BaseMapper<ChemistryContrastDao> {

    /**
     * 根据hospitalId查询出前端所需要的数据
     * @param hospitalId
     * @return
     */
    @Select("select BSC_ChemistryContrast.HospitalID, BSC_ChemistryContrast.TestItemID,\n" +
            "       BSC_ChemistryContrast.SampleTypeID, BSC_ChemistryContrast.IsProgrammed,\n" +
            "       BSC_ChemistryContrast.InstrumentID, BSC_ChemistryContrast.ChemCode,\n" +
            "       BSC_ChemistryContrast.IsEnabled, BSC_TestItemInfo.TestItemName,\n" +
            "       BSC_SampleType.SampleTypeName, BSC_Instrument.InstrumentName\n" +
            "from BSC_ChemistryContrast, BSC_TestItemInfo, BSC_SampleType, BSC_Instrument\n" +
            "where BSC_ChemistryContrast.InstrumentID=BSC_Instrument.InstrumentID\n" +
            "and BSC_ChemistryContrast.TestItemID=BSC_TestItemInfo.TestItemID\n" +
            "and BSC_ChemistryContrast.SampleTypeID=BSC_SampleType.SampleTypeID\n" +
            "and BSC_ChemistryContrast.HospitalID = #{hospitalId};")
    List<ChemistryContrastViewModel> selectByHospitalId(@Param("hospitalId") Integer hospitalId);
}
