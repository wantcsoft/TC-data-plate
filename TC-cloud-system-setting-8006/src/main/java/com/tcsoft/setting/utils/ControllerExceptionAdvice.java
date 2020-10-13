package com.tcsoft.setting.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author WMY
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 全局json序列化异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(JsonProcessingException.class)
    public ResultData<String> authenticationExceptionHandler(JsonProcessingException e) {
        ResultData<String> resultData = new ResultData();
        resultData.setResultCode(ResultCode.FAILED);
        resultData.setData("配置信息获取失败");
        log.debug(e.getMessage());
        return resultData;
    }

}
