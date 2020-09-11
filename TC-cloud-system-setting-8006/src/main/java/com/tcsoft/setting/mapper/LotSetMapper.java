package com.tcsoft.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.LotSetDao;
import com.tcsoft.setting.viewmodel.LotSetViewModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface LotSetMapper extends BaseMapper<LotSetDao> {

    @Select("select QC_LotSet.LotSetID, QC_LotSet.MaterialID,\n" +
            "       QC_LotSet.LotSetName, QC_LotSet.LevelCount,\n" +
            "       QC_LotSet.Level1Code, QC_LotSet.Level2Code,\n" +
            "       QC_LotSet.Level3Code, QC_LotSet.IsActive,\n" +
            "       QC_Material.MaterialName\n" +
            "from QC_LotSet, QC_Material\n" +
            "where QC_LotSet.HospitalID = #{hospitalId} \n" +
            "and QC_LotSet.MaterialID = QC_Material.MaterialID;")
    List<LotSetViewModel> selectAll(@Param("hospitalId")Integer hospitalId);
}
