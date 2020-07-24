package com.tcsoft.kafka.service;



import com.tcsoft.kafka.entity.User;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * 这个注解给我们绑定消息通道的，Source是Stream给我们提供的，可以点进去看源码，可以看到output和input,这和配置文件中的output，input对应的。
 * @author big_john
 */
@EnableBinding(Source.class)
public class SendService {

    /**
     * 消息发送管道
     */
    @Resource
    private Source source;

    public void sendMsg(User msg) {
        source.output().send(MessageBuilder.withPayload(msg).build());
    }


}

