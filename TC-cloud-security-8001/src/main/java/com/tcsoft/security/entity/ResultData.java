package com.tcsoft.security.entity;

import com.tcsoft.security.enums.ResultCode;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * 前端同一返回数据模型
 * @author big_john
 */
@Getter
public class ResultData<T> implements Serializable {
    /**
     * 返回状态码：默认200
     */
    private Integer code;
    /**
     * 返回结果信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public void setResultCode(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
    }

    public void setData(T data){
        this.data = data;
    }

}
