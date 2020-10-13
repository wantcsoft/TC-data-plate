package com.tcsoft.setting.enums;

import lombok.Getter;

/**
 * 返回响应的状态码
 * @author WMY
 */
@Getter
public enum ResultCode {
    //操作成功
    SUCCESS(200, "请求成功"),
    //操作失败
    FAILED(401, "操作失败"),
    //未授权
    UNAUTHORIZED(403, "未授权");

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
