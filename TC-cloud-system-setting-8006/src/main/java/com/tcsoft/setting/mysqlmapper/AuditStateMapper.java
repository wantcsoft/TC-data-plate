package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.AuditStateDao;
import com.tcsoft.setting.viewmodel.AuditStateViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface AuditStateMapper extends BaseMapper<AuditStateDao> {

    /**
     * 查询出所有的信息
     * @return
     */
    @Select("select * from BSC_AuditState;")
    List<AuditStateViewModel> selectAll();
}
