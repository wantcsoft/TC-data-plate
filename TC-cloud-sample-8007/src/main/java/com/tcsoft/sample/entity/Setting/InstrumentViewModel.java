package com.tcsoft.sample.entity.Setting;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author WMY
 */
@Data
@ToString
public class InstrumentViewModel {

    private String instrumentTypeName;
    private String instrumentGroupName;
    private String lineTypeName;

    private Integer hospitalId;
    private Integer instrumentTypeId;
    private Integer instrumentGroupId;
    private Integer instrumentId;
    private String instrumentName;
    private boolean isOnline;
    private String location;
    private Integer communicateType;
    private Integer baudRate;
    private Integer bitSize;
    private Integer parity;
    private Integer stopBits;
    private Integer flowControl;
    private Integer bufferSize;
    private Integer readTimeOut;
    private Integer writeTimeOut;
    private Integer lineType;
    private String permissionCode;
    private Date lastActiveDate;
    private boolean isEnabled = true;

}
