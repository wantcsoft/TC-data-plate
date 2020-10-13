package com.tcsoft.security.utils;

import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.enums.ResultCode;
import com.tcsoft.security.myExceptions.UserException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author WMY
 */
@RestControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 全局认证异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    public ResultData<String> authenticationExceptionHandler(AuthenticationException e) {
        ResultData<String> resultData = new ResultData();
        resultData.setResultCode(ResultCode.FAILED);
        resultData.setData(e.getMessage());
        return resultData;
    }

    /**
     * 全局用户信息异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(UserException.class)
    public ResultData<String> userExceptionHandler(UserException e) {
        ResultData<String> resultData = new ResultData();
        resultData.setResultCode(ResultCode.FAILED);
        resultData.setData(e.getMessage());
        return resultData;
    }

}
