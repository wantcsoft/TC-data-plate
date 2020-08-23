package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.ResultUnitDao;
import com.tcsoft.setting.viewmodel.ResultUnitViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface ResultUnitMapper extends BaseMapper<ResultUnitDao> {

    @Select("select * from BSC_ResultUnit\n" +
            "where IsDeleted = false\n" +
            "and HospitalID = #{hospitalId};")
    List<ResultUnitViewModel> selectAll(@Param("hospitalId")Integer hospitalId);

}
