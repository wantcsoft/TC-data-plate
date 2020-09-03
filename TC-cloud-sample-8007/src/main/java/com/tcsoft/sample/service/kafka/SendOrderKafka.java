package com.tcsoft.sample.service.kafka;


import com.tcsoft.sample.entity.OrderFromLis;
import com.tcsoft.sample.entity.OrderToThird;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;

import javax.annotation.Resource;


/**
 * 将医嘱信息发送到kafka中
 * @author big_john
 */
@EnableBinding(Source.class)
public class SendOrderKafka {

    @Resource
    private Source source;

    public boolean send(OrderFromLis order) {
        try {
            return source.output().send(MessageBuilder.withPayload(order).build());
        }catch (Exception e){
            return false;
        }
    }

}

