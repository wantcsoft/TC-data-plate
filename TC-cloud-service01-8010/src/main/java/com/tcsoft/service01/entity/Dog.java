package com.tcsoft.service01.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * @author WMY
 */
@Data
public class Dog implements Serializable {

    private String name;
    private Integer weight;

}
