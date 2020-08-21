package com.tcsoft.setting.mysqlmapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.LotSetDao;
import com.tcsoft.setting.viewmodel.LotSetViewModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author WMY
 */
public interface LotSetMapper extends BaseMapper<LotSetDao> {

    List<LotSetViewModel> selectAll();
}
