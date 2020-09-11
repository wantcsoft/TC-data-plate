package com.tcsoft.sample.entity.Setting;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class SampleEventViewModel {

    private Integer sampleEventId;
    private String eventDesc;
    private String eventDisplay;

}
