package com.tcsoft.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.AgeTypeDao;
import com.tcsoft.setting.viewmodel.AgeTypeViewModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface AgeTypeMapper extends BaseMapper<AgeTypeDao> {

    /**
     * 根据hospitalId查询所有信息
     * @param hospitalId
     * @return
     */
    @Select("select *\n" +
            "from BSC_AgeType\n" +
            "where HospitalID = #{hospitalId}\n" +
            "and IsDeleted = false;")
    List<AgeTypeViewModel> selectByHospitalId(@Param("hospitalId")Integer hospitalId);

}
