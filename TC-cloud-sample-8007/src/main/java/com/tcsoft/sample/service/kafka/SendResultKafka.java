//package com.tcsoft.sample.service.kafka;
//
//
//import com.tcsoft.sample.entity.InfoFromThird;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.integration.support.MessageBuilder;
//
//import javax.annotation.Resource;
//
///**
// * 发送测试结果到kafka中
// * @author WMY
// */
//@EnableBinding(ResultChannel.class)
//public class SendResultKafka {
//
//    @Resource
//    private ResultChannel resultChannel;
//
//    public boolean send(InfoFromThird result) {
//        try {
//            return resultChannel.output().send(MessageBuilder.withPayload(result).build());
//        }catch (Exception e){
//            return false;
//        }
//    }
//
//}
