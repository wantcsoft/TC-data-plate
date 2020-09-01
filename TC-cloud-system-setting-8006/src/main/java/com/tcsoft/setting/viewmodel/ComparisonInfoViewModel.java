package com.tcsoft.setting.viewmodel;

import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class ComparisonInfoViewModel {
    private Integer hospitalId;
    private Integer instrumentTypeId;
    private Integer comparisonTypeId;

    private String instrumentTypeName;
    private String comparisonTypeName;
    private String instrumentInfo;
    private Integer comparedTypeId;

}
