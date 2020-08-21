package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.InstrumentTypeDao;
import com.tcsoft.setting.viewmodel.InstrumentTypeViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface InstrumentTypeMapper extends BaseMapper<InstrumentTypeDao> {

    /**
     * 根据hospital查询所有的信息
     * @param hospital
     * @return
     */
    @Select("select *\n" +
            "from BSC_InstrumentType\n" +
            "where HospitalID = #{hospital};")
    List<InstrumentTypeViewModel> selectAll(@Param("hospital")Integer hospital);

}
