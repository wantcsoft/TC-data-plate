package com.tcsoft.setting.viewmodel;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class SampleStatusViewModel {

    private Integer sampleStatusId;
    private String sampleStatusName;
    private String statusFlag;
    private Integer parentStatusId;
    private boolean instrumentRelated;

}
