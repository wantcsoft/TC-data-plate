package com.tcsoft.sample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.sample.dao.SampleInfoDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

/**
 *
 * @author WMY
 * @since 2020-08-10
 */
public interface SampleInfoMapper extends BaseMapper<SampleInfoDao> {

    /**
     * 跟据条码号和时间查询出条码号
     * @param sampleId
     * @param collectTime
     * @return
     */
    @Select("select SampleNo\n" +
            "from WOR_SampleInfo\n" +
            "where SampleID = #{sampleId}\n" +
            "and CollectTime = #{collectTime}")
    Integer selectSampleNo(@Param("sampleId")String sampleId, @Param("collectTime")Date collectTime);

}
