package com.tcsoft.sample.service.kafka;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author WMY
 */
@EnableBinding(ResultChannel.class)
public class ReceiveResultReceiveService {

    @StreamListener(ResultChannel.INPUT)
    public void receive(String result) {
        System.out.println("B收到一条消息:" + result);
    }

}
