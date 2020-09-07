package com.tcsoft.sample.service.kafka;


import com.tcsoft.sample.entity.InfoFromLis;
import com.tcsoft.sample.mapper.InfoFromLisMapper;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import javax.annotation.Resource;


/**
 * 从kafka中获取医嘱信息进行信息处理
 * @author WMY
 */
@EnableBinding(Sink.class)
public class ReceiveOrderKafka {
    @Resource
    private InfoFromLisMapper infoFromLisMapper;

    @StreamListener(Sink.INPUT)
    public void receive(InfoFromLis order) {
        boolean flag = saveOrder(order);
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

    private boolean saveOrder(InfoFromLis order){
        return infoFromLisMapper.insert(order) == 1;
    }

}
