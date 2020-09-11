package com.tcsoft.sample.entity.Setting;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class LineTypeViewModel {

    private Integer lineTypeId;
    private String lineTypeCode;
    private String lineTypeName;
    private String comment;

}
