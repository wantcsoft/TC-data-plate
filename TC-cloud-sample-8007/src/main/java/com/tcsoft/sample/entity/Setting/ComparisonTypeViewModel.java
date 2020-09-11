package com.tcsoft.sample.entity.Setting;


import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class ComparisonTypeViewModel {

    private Integer comparisonTypeId;
    private String comparisonTypeName;
    private String comparisonTableName;

}
