package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.ComparisonInfoDao;
import com.tcsoft.setting.viewmodel.ComparisonInfoViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface ComparisonInfoMapper extends BaseMapper<ComparisonInfoDao> {

    /**
     * 查询所有信息
     * @param hospitalId
     * @return
     */
    @Select("select BSC_ComparisonInfo.InstrumentTypeID, BSC_ComparisonInfo.ComparisonTypeID,\n" +
            "       BSC_ComparisonInfo.InstrumentInfo, BSC_ComparisonInfo.ComparedTypeID,\n" +
            "       BSC_InstrumentType.InstrumentTypeName, BSC_ComparisonType.ComparisonTypeName\n" +
            "from BSC_ComparisonInfo, BSC_InstrumentType, BSC_ComparisonType\n" +
            "where BSC_ComparisonInfo.HospitalId = #{hospitalId}\n" +
            "and BSC_ComparisonInfo.InstrumentTypeID=BSC_InstrumentType.InstrumentTypeID\n" +
            "and BSC_ComparisonInfo.ComparisonTypeID=BSC_ComparisonType.ComparisonTypeID;")
    List<ComparisonInfoViewModel> selectAll(@Param("hospitalId")Integer hospitalId);

}
