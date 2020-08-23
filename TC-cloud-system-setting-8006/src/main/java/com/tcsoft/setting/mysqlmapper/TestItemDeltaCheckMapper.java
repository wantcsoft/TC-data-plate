package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.TestItemDeltaCheckDao;
import com.tcsoft.setting.viewmodel.TestItemDeltaCheckViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface TestItemDeltaCheckMapper extends BaseMapper<TestItemDeltaCheckDao> {

    @Select("select * from BSC_TestItemDeltaCheck\n" +
            "where HospitalID = #{hospitalId};")
    List<TestItemDeltaCheckViewModel> selectAll(@Param("hospitalId")Integer hospitalId);

}
