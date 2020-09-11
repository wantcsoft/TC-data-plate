package com.tcsoft.sample.entity.Setting;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class SampleStateViewModel {

    private Integer sampleStateId;
    private Integer parentSampleState;
    private String sampleStateName;
    private boolean isSamplePosition;
    private boolean instrumentRelated;
    private Integer displayOrder;
    private String stateDisplayName;
    private String defaultDisplayName;
    private Integer bindInstrumentId;

}
