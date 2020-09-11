package com.tcsoft.setting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.TestItemTypeDao;
import com.tcsoft.setting.viewmodel.TestItemTypeViewModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface TestItemTypeMapper extends BaseMapper<TestItemTypeDao> {

    @Select("select * from BSC_TestItemType\n" +
            "where HospitalID = #{hospitalId};")
    List<TestItemTypeViewModel> selectAll(@Param("hospitalId")Integer hospitalId);

}
