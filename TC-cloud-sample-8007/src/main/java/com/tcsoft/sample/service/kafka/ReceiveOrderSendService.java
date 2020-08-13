package com.tcsoft.sample.service.kafka;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;

import javax.annotation.Resource;


/**
 * 这个注解给我们绑定消息通道的，Source是Stream给我们提供的，可以点进去看源码，可以看到output和input,这和配置文件中的output，input对应的。
 * @author big_john
 */
@EnableBinding(Source.class)
public class ReceiveOrderSendService {

    @Resource
    private Source source;

    public boolean send(String receiveOrder) {
        try {
            return source.output().send(MessageBuilder.withPayload(receiveOrder).build());
        }catch (Exception e){
            return false;
        }
    }

}

