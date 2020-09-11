package com.tcsoft.sample.entity.Setting;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author WMY
 */
@Data
@ToString
public class MaterialViewModel {

    private String sampleTypeName;

    private Integer materialId;
    private Integer hospitalId;
    private String materialName;
    private Integer sampleTypeId;
    private Date periodStart;
    private Date periodEnd;
    private boolean isActive;

}
