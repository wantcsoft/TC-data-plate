//package com.tcsoft.sample.service.kafka;
//
//
//import com.tcsoft.sample.dao.ProgItemDao;
//import com.tcsoft.sample.dao.SampleInfoDao;
//import com.tcsoft.sample.entity.InfoFromLis;
//import com.tcsoft.sample.mapper.ProgItemMapper;
//import com.tcsoft.sample.mapper.SampleInfoMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//
//import javax.annotation.Resource;
//import java.util.Date;
//
//
///**
// * 从kafka中获取医嘱信息进行信息处理
// * @author WMY
// */
//@Slf4j
//@EnableBinding(Sink.class)
//public class ReceiveOrderKafka {
//
//    @Resource
//    private SampleInfoMapper sampleInfoMapper;
//    @Resource
//    private ProgItemMapper progItemMapper;
//
//    @StreamListener(Sink.INPUT)
//    public void receive(InfoFromLis order) {
//        boolean flag = saveOrder(order);
//        if (flag) {
//            log.info(order.getSampleId() + "保存成功");
//        }else {
//            log.error(order.getSampleId() + "保存失败");
//        }
//    }
//
//    private boolean saveOrder(InfoFromLis order){
//        SampleInfoDao sampleInfo = new SampleInfoDao();
//        sampleInfo.setHospitalId(order.getPatientId());
//        sampleInfo.setSampleId(order.getSampleId());
//        sampleInfo.setSampleTypeId(order.getSampleTypeId());
//        sampleInfo.setTestTypeId(order.getTestTypeId());
//        sampleInfo.setRackNo(order.getRackNo());
//        sampleInfo.setCupNo(order.getCupNo());
//        sampleInfo.setCollectTime(order.getCollectTime());
//        sampleInfo.setParentSampleNo(order.getParentSampleNo());
//        sampleInfo.setPatientCardNo(order.getPatientCardNo());
//        sampleInfo.setPatientBedNo(order.getPatientBedNo());
//        sampleInfo.setPatientTypeId(order.getPatientTypeId());
//        sampleInfo.setPatientName(order.getPatientName());
//        sampleInfo.setPatientAge(order.getPatientAge());
//        sampleInfo.setAgeTypeId(order.getAgeTypeId());
//        sampleInfo.setSexTypeId(order.getSexTypeId());
//        sampleInfo.setDiagnosis(order.getDiagnosis());
////        保存样本信息
//        int sampleInfoFlag = sampleInfoMapper.insert(sampleInfo);
//        if (sampleInfoFlag != 1) {
//            return false;
//        }
//
//        Integer sampleNo = sampleInfoMapper.selectSampleNo(order.getSampleId(), order.getCollectTime());
//        ProgItemDao progItem = new ProgItemDao();
//        progItem.setSampleNo(sampleNo);
//        progItem.setTestItemId(order.getTestItemId());
//        progItem.setReplicateTimes(order.getReplicateTimes());
//        progItem.setProgTime(order.getProgTime());
//        progItem.setProgSendTime(new Date());
//        progItem.setIsAliquot(order.getIsAliquot());
////        保存编程信息
//        int progItemFlag = progItemMapper.insert(progItem);
//        if (progItemFlag != 1) {
//            return false;
//        }
//        return true;
//    }
//
//}
