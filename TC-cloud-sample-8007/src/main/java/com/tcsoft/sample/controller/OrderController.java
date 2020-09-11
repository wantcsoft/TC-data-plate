package com.tcsoft.sample.controller;


import com.tcsoft.sample.entity.InfoFromLis;
import com.tcsoft.sample.entity.ResultData;
import com.tcsoft.sample.service.InfoFromLisService;
import com.tcsoft.sample.service.kafka.SendOrderKafka;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 医嘱信息接口
 * @author WMY
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private SendOrderKafka sendService;
    @Resource
    private InfoFromLisService service;

    /**
     * 从lis获取医嘱信息
     * @param orderList
     * @return
     */
    @PostMapping("/push")
    public void pushOrder(@RequestBody List<InfoFromLis> orderList) {
        for (InfoFromLis order:orderList){
            sendService.send(order);
        }
    }

    /**
     * 将医嘱信息发送给第三方
     * @param
     * @return
     */
    @GetMapping("/pull")
    public ResultData<List<InfoFromLis>> pullOrder(){
        ResultData<List<InfoFromLis>> resultData = new ResultData<>();
        List<InfoFromLis> list = service.list();
        resultData.setData(list);
        return resultData;
    }

}
