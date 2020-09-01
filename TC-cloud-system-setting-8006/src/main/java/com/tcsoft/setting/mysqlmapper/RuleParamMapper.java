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

    @Select("select BSC_RuleParam.RuleParamID, BSC_RuleParam.ParamCode,\n" +
            "       BSC_RuleParam.ParamDesc, BSC_RuleParam.DataTypeID,\n" +
            "       BSC_DataType.DataTypeName\n" +
            "from BSC_RuleParam, BSC_DataType\n" +
            "where BSC_RuleParam.DataTypeID=BSC_DataType.DataTypeID;")
    List<RuleParamViewModel> selectAll();

}
