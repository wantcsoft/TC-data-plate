package com.tcsoft.kafka.service;


import com.tcsoft.kafka.entity.User;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.util.concurrent.TimeUnit;

/**
 * @author WMY
 */
@EnableBinding(Sink.class)
public class ReceiveService {

    @StreamListener(Sink.INPUT)
    public void receive(User msg) throws InterruptedException {
        System.out.println("A收到一条消息:" + msg);
        TimeUnit.SECONDS.sleep(1);
    }

}
