package com.tcsoft.sample.service.kafka;


import com.tcsoft.sample.entity.OrderFromLis;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;


/**
 * 从kafka中获取医嘱信息进行信息处理
 * @author WMY
 */
@EnableBinding(Sink.class)
public class ReceiveOrderKafka {

    @StreamListener(Sink.INPUT)
    public void receive(OrderFromLis order) {
        System.out.println(order);
//        JSONObject jsonObject = JSONObject.parseObject(receiveOrders);
//        JSONArray orderList = jsonObject.getJSONArray("orderList");
//        orderList.forEach((order) -> {
//            ObjectMapper om = new ObjectMapper();
//            try {
//                ReceiveOrder receiveOrder = om.readValue(JSON.toJSONString(order), ReceiveOrder.class);
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        });
    }

}
