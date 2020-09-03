package com.tcsoft.sample.service.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 第三方测试结果的输入输出管道
 * @author WMY
 */
public interface ResultChannel {

    String INPUT = "resultInput";
    String OUTPUT = "resultOutput";

    /**
     * 结果输入管道
     * @return
     */
    @Input(ResultChannel.INPUT)
    SubscribableChannel input();

    /**
     * 结果输出管道
     * @return
     */
    @Output(ResultChannel.OUTPUT)
    MessageChannel output();

}
