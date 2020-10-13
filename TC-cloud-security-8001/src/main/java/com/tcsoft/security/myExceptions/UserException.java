package com.tcsoft.security.myExceptions;

import com.tcsoft.security.enums.ResultCode;
import lombok.Getter;

/**
 * 用户异常类
 * @author WMY
 */
@Getter
public class UserException extends RuntimeException {

    private int code;
    private String msg;

    // 默认异常使用APP_ERROR状态码
    public UserException(String message) {
        super(message);
        this.code = ResultCode.FAILED.getCode();
        this.msg = ResultCode.FAILED.getMsg();
    }

}
