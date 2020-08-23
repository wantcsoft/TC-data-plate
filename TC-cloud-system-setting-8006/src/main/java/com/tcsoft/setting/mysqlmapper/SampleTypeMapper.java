package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.SampleTypeDao;
import com.tcsoft.setting.viewmodel.ChemistryContrastViewModel;
import com.tcsoft.setting.viewmodel.SampleTypeViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface SampleTypeMapper extends BaseMapper<SampleTypeDao> {

    /**
     * 根据hospitalId查询出前端所需要的数据
     * @param hospitalId
     * @return
     */
    @Select("select * from BSC_SampleType\n" +
            "where IsDeleted = false\n" +
            "and HospitalID = #{hospitalId};")
    List<SampleTypeViewModel> selectByHospitalId(@Param("hospitalId") Integer hospitalId);

}
