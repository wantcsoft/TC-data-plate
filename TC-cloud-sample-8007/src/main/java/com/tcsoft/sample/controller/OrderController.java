package com.tcsoft.sample.controller;


import com.tcsoft.sample.entity.InfoFromLis;
import com.tcsoft.sample.entity.InfoToThird;
import com.tcsoft.sample.entity.ResultData;
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

    /**
     * 从lis获取医嘱信息
     * @param orderList
     * @return
     */
    @PostMapping("/push")
    public ResultData<String> pushOrder(@RequestBody List<InfoFromLis> orderList) {
        ResultData<String> resultData = new ResultData<>();
        resultData.setMessage("上传成功");
        orderList.forEach((order) -> {
            if (!sendService.send(order)){
                resultData.setCode(401);
                resultData.setMessage("上传失败");
            }
        });
        return resultData;
    }

    /**
     * 将医嘱信息发送给第三方
     * @param
     * @return
     */
    @GetMapping("/pull")
    public ResultData<List<InfoToThird>> pullOrder(){
        ResultData<List<InfoToThird>> resultData = new ResultData<>();

        return resultData;
    }

}
