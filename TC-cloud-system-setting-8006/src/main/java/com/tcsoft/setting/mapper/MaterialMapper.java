package com.tcsoft.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.MaterialDao;
import com.tcsoft.setting.viewmodel.MaterialViewModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface MaterialMapper extends BaseMapper<MaterialDao> {
    @Select("select QC_Material.MaterialID, QC_Material.HospitalID,\n" +
            "       QC_Material.MaterialName, QC_Material.SampleTypeID,\n" +
            "       QC_Material.PeriodStart, QC_Material.PeriodEnd,\n" +
            "       QC_Material.IsActive, BSC_SampleType.SampleTypeName\n" +
            "from QC_Material, BSC_SampleType\n" +
            "where QC_Material.HospitalID = #{hospitalId}\n" +
            "and QC_Material.SampleTypeID = BSC_SampleType.SampleTypeID;")
    List<MaterialViewModel> selectAll(@Param("hospitalId")Integer hospitalId);
}
