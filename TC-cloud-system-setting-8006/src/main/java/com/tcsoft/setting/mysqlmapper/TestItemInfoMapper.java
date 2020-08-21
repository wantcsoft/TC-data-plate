package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.TestItemInfoDao;
import com.tcsoft.setting.viewmodel.TestItemInfoViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface TestItemInfoMapper extends BaseMapper<TestItemInfoDao> {

    @Select("select *\n" +
            "from BSC_TestItemInfo\n" +
            "where HospitalID = #{hospitalId}\n" +
            "and IsDeleted = false;")
    List<TestItemInfoViewModel> selectByHospitalId(@Param("hospitalId") Integer hospitalId);

}
