package com.tcsoft.setting.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author big_john
 */
@Data
public class ResultData<T> implements Serializable {

    private Integer code = 200;

    private String message;

    private T data;

}
