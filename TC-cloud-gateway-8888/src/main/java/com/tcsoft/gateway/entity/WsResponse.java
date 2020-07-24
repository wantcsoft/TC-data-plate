package com.tcsoft.gateway.entity;

import lombok.Data;


/**
 * 请求返回的数据格式
 * @author WMY
 */
@Data
public class WsResponse<T> {

    private MessageCode status;
    private String messages;
    private T result;

    @Override
    public String toString() {
        return "code:" + status + "message:" + messages + " result:" + result;
    }

}

