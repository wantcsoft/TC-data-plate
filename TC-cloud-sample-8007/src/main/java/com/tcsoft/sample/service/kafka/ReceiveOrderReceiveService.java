package com.tcsoft.sample.service.kafka;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcsoft.sample.entity.ReceiveOrder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;


/**
 * @author WMY
 */
@EnableBinding(Sink.class)
public class ReceiveOrderReceiveService {

    @StreamListener(Sink.INPUT)
    public void receive(String receiveOrders) {
        System.out.println("A收到一条消息:" + receiveOrders);
        JSONObject jsonObject = JSONObject.parseObject(receiveOrders);
        JSONArray orderList = jsonObject.getJSONArray("orderList");
        orderList.forEach((order) -> {
            ObjectMapper om = new ObjectMapper();
            try {
                ReceiveOrder receiveOrder = om.readValue(JSON.toJSONString(order), ReceiveOrder.class);
                System.out.println(receiveOrder);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
    }

}
