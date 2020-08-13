package com.tcsoft.sample.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 编程项目字段
 * @author WMY
 */
@Data
@ToString
public class ProgramOrder{

    private String testItemCode;//测试项目代码
    private String dilutionCondition;
    private String dilutionCoefficient;
    private String instrumentCode;

}
