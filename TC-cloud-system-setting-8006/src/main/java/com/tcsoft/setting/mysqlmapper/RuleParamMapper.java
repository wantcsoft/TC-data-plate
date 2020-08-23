package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.RuleParamDao;
import com.tcsoft.setting.viewmodel.RuleParamViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface RuleParamMapper extends BaseMapper<RuleParamDao> {

    @Select("select * from BSC_RuleParam;")
    List<RuleParamViewModel> selectAll();

}
