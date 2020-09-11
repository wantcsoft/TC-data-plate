package com.tcsoft.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.RuleGroupDao;
import com.tcsoft.setting.viewmodel.RuleGroupViewModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface RuleGroupMapper extends BaseMapper<RuleGroupDao> {

    @Select("select * from BSC_RuleGroup\n" +
            "where HospitalID = #{hospitalId};")
    List<RuleGroupViewModel> selectAll(@Param("hospitalId")Integer hospitalId);

}
