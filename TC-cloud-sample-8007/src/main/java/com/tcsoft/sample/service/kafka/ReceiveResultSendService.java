package com.tcsoft.sample.service.kafka;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author WMY
 */
@EnableBinding(ResultChannel.class)
public class ReceiveResultSendService {

    @Resource
    private ResultChannel resultChannel;

    public boolean send(String receiveOrder) {
        try {
            return resultChannel.output().send(MessageBuilder.withPayload(receiveOrder).build());
        }catch (Exception e){
            return false;
        }
    }

}
