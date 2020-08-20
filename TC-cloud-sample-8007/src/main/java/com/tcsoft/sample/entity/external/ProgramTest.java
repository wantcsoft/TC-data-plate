package com.tcsoft.sample.entity.external;

import lombok.Data;
import lombok.ToString;


/**
 * 发送给流水线关于样本的编程信息
 * @author WMY
 */
@Data
@ToString
public class ProgramTest{

    private String testItemName;//样本测试名称
    private Integer replicateTimes;//重复次数
    private Integer ordacTimes;//
    private Integer reflexTimes;//
    private Boolean isAliquot;//是否等分

}
