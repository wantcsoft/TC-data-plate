package com.tcsoft.service01.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * @author WMY
 */
@Data
public class User implements Serializable {

    private String userName;
    private Integer age;
    private Dog dog;

}
