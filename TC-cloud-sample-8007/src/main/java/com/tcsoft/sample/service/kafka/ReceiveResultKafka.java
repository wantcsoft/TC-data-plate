package com.tcsoft.sample.service.kafka;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * 从kafka中获取检测结果
 * @author WMY
 */
@EnableBinding(ResultChannel.class)
public class ReceiveResultKafka {

    @StreamListener(ResultChannel.INPUT)
    public void receive(String result) {
        System.out.println("B收到一条消息:" + result);
    }

}
