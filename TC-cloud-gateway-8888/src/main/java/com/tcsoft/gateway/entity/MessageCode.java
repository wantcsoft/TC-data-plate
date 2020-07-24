package com.tcsoft.gateway.entity;


/**
 * 请求的状态码
 * @author WMY
 */

public enum MessageCode {

    COMMON_SUCCESS("00000","执行成功"),
    COMMON_FAILURE("00001", "执行失败"),
    COMMON_AUTHORIZED_FAILURE("00002", "身份鉴权失败");

    private String code;
    private String message;

    MessageCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "{code:'" + code + '\'' +
                ", message:'" + message + '\'' +
                '}';
    }
}

