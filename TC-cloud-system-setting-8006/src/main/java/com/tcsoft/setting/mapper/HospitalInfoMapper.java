package com.tcsoft.setting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.HospitalInfoDao;
import com.tcsoft.setting.viewmodel.HospitalInfoViewModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface HospitalInfoMapper extends BaseMapper<HospitalInfoDao> {

    /**
     * 查出所有的医院信息
     * @return
     */
    @Select("select * from BSC_HospitalInfo where IsDeleted = false;")
    List<HospitalInfoViewModel> selectAll();

}
