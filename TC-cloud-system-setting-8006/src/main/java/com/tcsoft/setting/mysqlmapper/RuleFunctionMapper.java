package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.RuleFunctionDao;
import com.tcsoft.setting.viewmodel.RuleFunctionViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface RuleFunctionMapper extends BaseMapper<RuleFunctionDao> {

    @Select("select BSC_RuleFunction.RuleFunctionID, BSC_RuleFunction.RuleFunctionName,\n" +
            "       BSC_RuleFunction.ParamCount, BSC_RuleFunction.Comment,\n" +
            "       BSC_RuleFunction.FirstParamDataType, BSC_RuleFunction.SecondParamDataType,\n" +
            "       DT1.DataTypeName AS FirstParam, DT2.DataTypeName AS SecondParam\n" +
            "from BSC_RuleFunction\n" +
            "join BSC_DataType DT1 on BSC_RuleFunction.FirstParamDataType = DT1.DataTypeID\n" +
            "join BSC_DataType DT2 on BSC_RuleFunction.SecondParamDataType = DT2.DataTypeID;")
    List<RuleFunctionViewModel> selectAll();

}
