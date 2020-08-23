package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.RuleTypeDao;
import com.tcsoft.setting.viewmodel.RuleTypeViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface RuleTypeMapper extends BaseMapper<RuleTypeDao> {

    @Select("select * from BSC_RuleType;")
    List<RuleTypeViewModel> selectAll();

}
