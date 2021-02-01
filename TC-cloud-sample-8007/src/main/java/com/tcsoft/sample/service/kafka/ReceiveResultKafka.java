//package com.tcsoft.sample.service.kafka;
//
//
//import com.tcsoft.sample.dao.ResultDao;
//import com.tcsoft.sample.entity.InfoFromThird;
//import com.tcsoft.sample.mapper.InfoFromThirdMapper;
//import com.tcsoft.sample.mapper.ResultMapper;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//
//import javax.annotation.Resource;
//
///**
// * 从kafka中获取检测结果
// * @author WMY
// */
//@EnableBinding(ResultChannel.class)
//public class ReceiveResultKafka {
//    @Resource
//    private ResultMapper resultMapper;
//
//    @StreamListener(ResultChannel.INPUT)
//    public void receive(InfoFromThird result) {
//        boolean flag = saveResult(result);
//        System.out.println(flag);
//    }
//
//    private boolean saveResult(InfoFromThird result){
//        ResultDao resultDao = new ResultDao();
//        resultDao.setSampleNo(result.getSampleNo());
//        resultDao.setTestItemId(result.getTestItemId());
//        resultDao.setResultTxt(result.getResultTxt());
//        resultDao.setResultNumeric(result.getResultNumeric());
//        resultDao.setConfirmStateId(result.getConfirmStateId());
//        resultDao.setInstrumentId(result.getInstrumentId());
//        resultDao.setTestTime(result.getTestTime());
//        resultDao.setReagentSerialNo(result.getReagentSerialNo());
//        resultDao.setReagentLotNo(result.getReagentLotNo());
//        resultDao.setChemCode(result.getChemCode());
//        resultDao.setAuditStateId(result.getAuditStateId());
//        resultDao.setErrorInfo(result.getErrorInfo());
//        resultDao.setDiluteFactor(result.getDiluteFactor());
//        resultDao.setResultRangeId(result.getResultRangeId());
//        resultDao.setIsMerged(result.getIsMerged());
//        resultDao.setCalculatedResult(result.getCalculatedResult());
//        resultDao.setReplicateNo(result.getReplicateNo());
//        resultDao.setUnitId(result.getUnitId());
//
//        int resultFlag = resultMapper.insert(resultDao);
//        return resultFlag == 1;
//    }
//
//}
