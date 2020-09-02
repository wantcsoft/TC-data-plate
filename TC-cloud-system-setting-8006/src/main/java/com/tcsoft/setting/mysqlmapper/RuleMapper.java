package com.tcsoft.setting.mysqlmapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.RuleDao;
import com.tcsoft.setting.viewmodel.RuleViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface RuleMapper extends BaseMapper<RuleDao> {

    @Select("select BSC_Rule.RuleID, BSC_Rule.RuleName,\n" +
            "       BSC_Rule.InstrumentGroupID, BSC_Rule.HospitalID,\n" +
            "       BSC_Rule.RuleGroupID, BSC_Rule.RuleTypeID,\n" +
            "       BSC_Rule.`Condition`, BSC_Rule.ActionTrue, \n" +
            "       BSC_Rule.ActionFalse, BSC_Rule.Comment, \n" +
            "       BSC_Rule.RuleOrder, BSC_Rule.IsVisible, \n" +
            "       BSC_Rule.IsRuleOnly, BSC_InstrumentGroup.InstrumentGroupName,\n" +
            "       BSC_RuleGroup.RuleGroupName, BSC_RuleType.RuleTypeName\n" +
            "from BSC_Rule, BSC_InstrumentGroup,\n" +
            "     BSC_RuleGroup, BSC_RuleType\n" +
            "where BSC_Rule.HospitalID = 1\n" +
            "and BSC_Rule.InstrumentGroupID = BSC_InstrumentGroup.InstrumentGroupID\n" +
            "and BSC_Rule.RuleGroupID = BSC_RuleGroup.RuleGroupID\n" +
            "and BSC_Rule.RuleTypeID = BSC_RuleType.RuleTypeID;\n")
    List<RuleViewModel> selectAll(@Param("hospitalId")Integer hospitalId);

}
