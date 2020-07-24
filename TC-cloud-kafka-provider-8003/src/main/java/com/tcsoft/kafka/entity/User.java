package com.tcsoft.kafka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author WMY
 */
@AllArgsConstructor
@Data
public class User implements Serializable {

    private String name;
    private int age;

}
