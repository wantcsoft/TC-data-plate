package com.tcsoft.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.LineTypeDao;
import com.tcsoft.setting.viewmodel.LineTypeViewModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface LineTypeMapper extends BaseMapper<LineTypeDao> {

    @Select("select *\n" +
            "from BSC_LineType;")
    List<LineTypeViewModel> selectAll();
}
