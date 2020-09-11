package com.tcsoft.setting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.ResultRangeDao;
import com.tcsoft.setting.viewmodel.ResultRangeViewModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface ResultRangeMapper extends BaseMapper<ResultRangeDao> {

    @Select("select BSC_ResultRange.ResultRangeID, BSC_ResultRange.HospitalID,\n" +
            "       BSC_ResultRange.LowerAge, BSC_ResultRange.UpperAge,\n" +
            "       BSC_ResultRange.AgeTypeID, BSC_ResultRange.RefLowerValue,\n" +
            "       BSC_ResultRange.RefUpperValue, BSC_ResultRange.SampleTypeID,\n" +
            "       BSC_ResultRange.AffirmLowerValue, BSC_ResultRange.AffirmUpperValue,\n" +
            "       BSC_ResultRange.ReportLowerValue, BSC_ResultRange.ReportUpperValue,\n" +
            "       BSC_ResultRange.IsDefault, BSC_ResultRange.IsEnabled,\n" +
            "       BSC_AgeType.AgeTypeName, BSC_SampleType.SampleTypeName\n" +
            "from BSC_ResultRange, BSC_AgeType, BSC_SampleType\n" +
            "where BSC_ResultRange.HospitalID = #{hospitalId}\n" +
            "and BSC_ResultRange.AgeTypeID = BSC_AgeType.AgeTypeID\n" +
            "and BSC_ResultRange.SampleTypeID = BSC_SampleType.SampleTypeID;")
    List<ResultRangeViewModel> selectAll(@Param("hospitalId")Integer hospitalId);

}
