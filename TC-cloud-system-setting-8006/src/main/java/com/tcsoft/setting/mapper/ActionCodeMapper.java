package com.tcsoft.setting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.ActionCodeDao;
import com.tcsoft.setting.viewmodel.ActionCodeViewModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author WMY
 */
public interface ActionCodeMapper extends BaseMapper<ActionCodeDao> {

    /**
     * 根据hospitalId查询所有的信息
     * @param hospitalId
     * @return
     */
    @Select("select *\n" +
            "from BSC_ActionCode\n" +
            "where HospitalID = #{hospitalId}\n" +
            "and IsDeleted = false;")
    List<ActionCodeViewModel> selectByHospitalId(@Param("hospitalId")Integer hospitalId);

}
