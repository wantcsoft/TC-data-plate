package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.PatientTypeDao;
import com.tcsoft.setting.viewmodel.PatientTypeViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface PatientTypeMapper extends BaseMapper<PatientTypeDao> {

    @Select("select *\n" +
            "from BSC_PatientType\n" +
            "where HospitalID = #{hospitalId}")
    List<PatientTypeViewModel> selectAll(@Param("hospitalId")Integer hospitalId);

}
