package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 基础配置信息，设备信息
 * @author WMY
 */
@Data
@ToString
@TableName("BSC_Instrument")
public class InstrumentDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableField(value = "InstrumentTypeID")
    private Integer instrumentTypeId;

    @TableField(value = "InstrumentGroupID")
    private Integer instrumentGroupId;

    @TableId(value = "InstrumentID", type = IdType.AUTO)
    private Integer instrumentId;

    @TableField(value = "InstrumentName")
    private String instrumentName;

    @TableField(value = "IsOnLine")
    private boolean isOnline;

    @TableField(value = "Location")
    private String location;

    @TableField(value = "CommunicateType")
    private Integer communicateType;

    @TableField(value = "BaudRate")
    private Integer baudRate;

    @TableField(value = "BitSize")
    private Integer bitSize;

    @TableField(value = "Parity")
    private Integer parity;

    @TableField(value = "StopBits")
    private Integer stopBits;

    @TableField(value = "FlowControl")
    private Integer flowControl;

    @TableField(value = "BufferSize")
    private Integer bufferSize;

    @TableField(value = "ReadTimeOut")
    private Integer readTimeOut;

    @TableField(value = "WriteTimeOut")
    private Integer writeTimeOut;

    @TableField(value = "LineType")
    private Integer lineType;

    //设备授权码 = 更迭类型(8位) + HospitalCode(32位) + 服务器Mac地址(32位) + 设备数量(8位)，不足位数的补空格 (' ')
    @TableField(value = "PermissionCode")
    private String permissionCode;

    //在批量设备更迭方式为删除最后使用的设备方式时使用
    @TableField(value = "LastActiveDate")
    private Date lastActiveDate;

    @TableField(value = "IsEnabled")
    private boolean isEnabled = true;

    @TableField(value = "IsDeleted")
    @TableLogic
    private boolean isDeleted = false;

}
