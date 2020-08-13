package com.tcsoft.sample.service.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author WMY
 */
public interface ResultChannel {

    String INPUT = "resultInput";
    String OUTPUT = "resultOutput";

    @Input(ResultChannel.INPUT)
    SubscribableChannel input();

    @Output(ResultChannel.OUTPUT)
    MessageChannel output();

}
