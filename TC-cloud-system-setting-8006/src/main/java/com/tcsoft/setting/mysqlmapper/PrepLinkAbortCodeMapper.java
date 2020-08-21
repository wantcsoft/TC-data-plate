package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.PrepLinkAbortCodeDao;
import com.tcsoft.setting.viewmodel.PrepLinkAbortCodeViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface PrepLinkAbortCodeMapper extends BaseMapper<PrepLinkAbortCodeDao> {

    @Select("select *\n" +
            "from BSC_PrepLinkAbortCode\n" +
            "where HospitalID = #{hospitalId}")
    List<PrepLinkAbortCodeViewModel> selectAll(@Param("hospitalId")Integer hospitalId);
}
