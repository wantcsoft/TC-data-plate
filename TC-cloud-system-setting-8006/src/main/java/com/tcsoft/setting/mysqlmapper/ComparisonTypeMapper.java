package com.tcsoft.setting.mysqlmapper;

;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.setting.dao.ComparisonTypeDao;
import com.tcsoft.setting.viewmodel.ComparisonTypeViewModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WMY
 */
public interface ComparisonTypeMapper extends BaseMapper<ComparisonTypeDao> {

    /**
     * 查询所有的信息
     * @return
     */
    @Select("select *\n" +
            "from BSC_ComparisonType;")
    List<ComparisonTypeViewModel> selectAll();

}
