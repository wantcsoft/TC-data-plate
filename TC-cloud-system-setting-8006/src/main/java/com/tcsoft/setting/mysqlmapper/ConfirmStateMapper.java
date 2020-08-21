package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.ConfirmStateDao;
import com.tcsoft.setting.viewmodel.ConfirmStateViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface ConfirmStateMapper extends BaseMapper<ConfirmStateDao> {

    /**
     * 查询所有信息
     * @return
     */
    @Select("select * from BSC_ConfirmState;")
    List<ConfirmStateViewModel> selectAll();
}
