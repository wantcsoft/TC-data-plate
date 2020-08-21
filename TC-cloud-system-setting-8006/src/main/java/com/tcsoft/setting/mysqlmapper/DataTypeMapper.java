package com.tcsoft.setting.mysqlmapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.DataTypeDao;
import com.tcsoft.setting.viewmodel.DataTypeViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface DataTypeMapper extends BaseMapper<DataTypeDao> {

    /**
     * 查询所有的信息
     * @return
     */
    @Select("select * from BSC_DataType;")
    List<DataTypeViewModel> selectAll();
}
