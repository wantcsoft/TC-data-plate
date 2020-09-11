package com.tcsoft.setting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.SexTypeDao;
import com.tcsoft.setting.viewmodel.SexTypeViewModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface SexTypeMapper extends BaseMapper<SexTypeDao> {

    @Select("select * from BSC_SexType\n" +
            "where IsDeleted = false;")
    List<SexTypeViewModel> selectAll();

}
