package com.tcsoft.sample.controller;


import com.tcsoft.sample.entity.external.SendOrder;
import com.tcsoft.sample.entity.ResultData;
import com.tcsoft.sample.service.impl.ResultServiceImpl;
import com.tcsoft.sample.service.impl.SampleInfoServiceImpl;
import com.tcsoft.sample.service.kafka.ReceiveOrderSendService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author WMY
 */
@RestController
public class OrderController {

    @Resource
    private ReceiveOrderSendService sendService;
    @Resource
    private ResultServiceImpl resultService;
    @Resource
    private SampleInfoServiceImpl sampleInfoService;

    @PostMapping("/order")
    public String fromLis(@RequestBody String receiveOrders) {
        return sendService.send(receiveOrders) ? "上传成功" : "上传失败";
    }

    @GetMapping("/order")
    public ResultData<SendOrder> toLis(@RequestParam Integer sampleNo){
        ResultData<SendOrder> resultData = new ResultData<>();
//        List<ResultDao> resultDaoList = resultService.list(new QueryWrapper<ResultDao>()
//                .eq("SampleNo", sampleNo));
//        SampleInfoDao sampleInfoDao = sampleInfoService.getById(sampleNo);
//        SendOrder sendOrder = new SendOrder();
//        BeanUtils.copyProperties(sampleInfoDao, sendOrder);
//        sendOrder.setResultDaoList(resultDaoList);
//        resultData.setMessage("操作成功");
//        resultData.setData(sendOrder);
        return resultData;
    }

}
