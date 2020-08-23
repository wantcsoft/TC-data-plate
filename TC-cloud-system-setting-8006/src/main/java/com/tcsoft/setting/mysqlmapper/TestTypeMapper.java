package com.tcsoft.setting.mysqlmapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.TestTypeDao;
import com.tcsoft.setting.viewmodel.TestTypeViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface TestTypeMapper extends BaseMapper<TestTypeDao> {

    @Select("select * from BSC_TestType\n" +
            "where IsDeleted = false\n" +
            "and HospitalID = #{hospitalId};")
    List<TestTypeViewModel> selectAll(@Param("hospitalId")Integer hospitalId);
}
