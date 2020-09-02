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
    @Select("select BSC_Instrument.HospitalID, BSC_Instrument.InstrumentTypeID,\n" +
            "       BSC_Instrument.InstrumentGroupID, BSC_Instrument.InstrumentID,\n" +
            "       BSC_Instrument.InstrumentName, BSC_Instrument.IsOnLine,\n" +
            "       BSC_Instrument.Location, BSC_Instrument.CommunicateType,\n" +
            "       BSC_Instrument.BaudRate, BSC_Instrument.BitSize,\n" +
            "       BSC_Instrument.Parity, BSC_Instrument.StopBits,\n" +
            "       BSC_Instrument.FlowControl, BSC_Instrument.BufferSize,\n" +
            "       BSC_Instrument.ReadTimeOut, BSC_Instrument.WriteTimeOut,\n" +
            "       BSC_Instrument.LineType, BSC_Instrument.PermissionCode,\n" +
            "       BSC_Instrument.LastActiveDate, BSC_Instrument.IsEnabled,\n" +
            "       BSC_InstrumentType.InstrumentTypeName, BSC_InstrumentGroup.InstrumentGroupName,\n" +
            "       BSC_LineType.LineTypeName\n" +
            "from BSC_Instrument, BSC_InstrumentType, BSC_InstrumentGroup, BSC_LineType\n" +
            "where BSC_Instrument.HospitalID = #{hospitalId}\n" +
            "and BSC_Instrument.InstrumentTypeID = BSC_InstrumentType.InstrumentTypeID\n" +
            "and BSC_Instrument.InstrumentGroupID = BSC_InstrumentGroup.InstrumentGroupID\n" +
            "and BSC_Instrument.LineType = BSC_LineType.LineTypeID\n" +
            "and BSC_Instrument.IsDeleted = false;")
    List<InstrumentViewModel> selectByHospitalId(@Param("hospitalId") Integer hospitalId);

}
