package com.tcsoft.service01.controller;

import com.tcsoft.service01.NotificationWebSocket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author big_john
 */
@RestController("/notification")
public class WebSocketController {

    @GetMapping
    public void test(@RequestParam String merchantId){
        if (!NotificationWebSocket.checkSocketConnected(merchantId)){
            System.out.println("用户在线");
            NotificationWebSocket.sendMessage(merchantId,"你有新的消息");
        } else {
            System.out.println("该用户断开连接，数据转存到数据库中");
        }

    }
}
