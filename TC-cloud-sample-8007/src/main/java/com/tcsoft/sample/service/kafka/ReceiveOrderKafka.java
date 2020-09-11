package com.tcsoft.sample.service.kafka;


import com.tcsoft.sample.dao.ProgItemDao;
import com.tcsoft.sample.dao.SampleInfoDao;
import com.tcsoft.sample.entity.InfoFromLis;
import com.tcsoft.sample.mapper.ProgItemMapper;
import com.tcsoft.sample.mapper.SampleInfoMapper;
import org.springframework.beans.factory.annotation.Value;
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
    private SampleInfoMapper sampleInfoMapper;
    @Resource
    private ProgItemMapper progItemMapper;

    @Value("${setting-service-url}")
    private String settingUrl;

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
        SampleInfoDao sampleInfo = new SampleInfoDao();
        sampleInfo.setHospitalId(order.getPatientId());
        sampleInfo.setSampleId(order.getSampleId());
        sampleInfo.setSampleTypeId(order.getSampleTypeId());
        sampleInfo.setTestTypeId(order.getTestTypeId());
        sampleInfo.setRackNo(order.getRackNo());
        sampleInfo.setCupNo(order.getCupNo());
        sampleInfo.setCollectTime(order.getCollectTime());
        sampleInfo.setPatientCardNo(order.getPatientCardNo());
        sampleInfo.setPatientBedNo(order.getPatientBedNo());
        sampleInfo.setPatientTypeId(order.getPatientTypeId());
        sampleInfo.setPatientName(order.getPatientName());
        sampleInfo.setPatientAge(order.getPatientAge());
        sampleInfo.setAgeTypeId(order.getAgeTypeId());
        sampleInfo.setSexTypeId(order.getSexTypeId());
        sampleInfo.setParentSampleNo(order.getParentSampleNo());
//        保存样本信息
        sampleInfoMapper.insert(sampleInfo);

        Integer sampleNo = sampleInfoMapper.selectSampleNo(order.getSampleId(), order.getCollectTime());
        ProgItemDao progItem = new ProgItemDao();
        progItem.setSampleNo(sampleNo);
        progItem.setTestItemId(order.getTestItemId());
        progItem.setReplicateTimes(order.getReplicateTimes());
//        保存编程信息
        progItemMapper.insert(progItem);

        return true;
    }

}
