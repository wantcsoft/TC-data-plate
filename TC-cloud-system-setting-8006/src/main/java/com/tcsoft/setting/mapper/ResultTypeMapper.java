package com.tcsoft.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.ResultTypeDao;
import com.tcsoft.setting.viewmodel.ResultTypeViewModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface ResultTypeMapper extends BaseMapper<ResultTypeDao> {

    @Select("select * from BSC_ResultType;")
    List<ResultTypeViewModel> selectAll();

}
