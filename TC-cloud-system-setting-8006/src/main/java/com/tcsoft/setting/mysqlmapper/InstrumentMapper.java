package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.InstrumentDao;
import com.tcsoft.setting.viewmodel.InstrumentViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface InstrumentMapper extends BaseMapper<InstrumentDao> {

    /**
     * 根据hospitalId查询出所有设备信息
     * @param hospitalId
     * @return
     */
    @Select("select *\n" +
            "from BSC_Instrument\n" +
            "where HospitalID = #{hospitalId}\n" +
            "and IsDeleted = false;")
    List<InstrumentViewModel> selectByHospitalId(@Param("hospitalId") Integer hospitalId);

}
