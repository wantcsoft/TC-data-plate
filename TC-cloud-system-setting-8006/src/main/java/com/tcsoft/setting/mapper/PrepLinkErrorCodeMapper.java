package com.tcsoft.setting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.PrepLinkErrorCodeDao;
import com.tcsoft.setting.viewmodel.PrepLinkErrorCodeViewModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface PrepLinkErrorCodeMapper extends BaseMapper<PrepLinkErrorCodeDao> {

    @Select("select * from BSC_PrepLinkErrorCode\n" +
            "where HospitalID=#{hospitalId};")
    List<PrepLinkErrorCodeViewModel> selectAll(@Param("hospitalId")Integer hospitalId);

}
