package com.tcsoft.setting.viewmodel;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author WMY
 */
@Data
@ToString
public class MaterialViewModel {

    private Integer materialId;
    private Integer hospitalId;
    private String materialName;
    private Integer sampleTypeId;
    private Date periodStart;
    private Date periodEnd;
    private boolean isActive;

}
