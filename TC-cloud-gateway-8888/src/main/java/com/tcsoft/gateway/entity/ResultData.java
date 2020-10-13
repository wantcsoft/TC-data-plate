package com.tcsoft.gateway.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 前端同一返回数据模型
 * @author big_john
 */
@Data
public class ResultData<T> implements Serializable {
    /**
     * 返回状态码：默认200
     */
    private Integer code = 200;
    /**
     * 返回结果信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

}
