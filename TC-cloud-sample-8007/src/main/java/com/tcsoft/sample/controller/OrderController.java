package com.tcsoft.sample.controller;


import com.tcsoft.sample.entity.OrderFromLis;
import com.tcsoft.sample.entity.OrderToThird;
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
     * @param order
     * @return
     */
    @PostMapping("/push")
    public ResultData<String> pushOrder(@RequestBody OrderFromLis order) {
        ResultData<String> resultData = new ResultData<>();
        if (sendService.send(order)){
            resultData.setMessage("上传成功");
        }else {
            resultData.setCode(401);
            resultData.setMessage("上传失败");
        }
        return resultData;
    }

    /**
     * 将医嘱信息发送给第三方
     * @param
     * @return
     */
    @GetMapping("/pull")
    public ResultData<List<OrderToThird>> pullOrder(){
        ResultData<List<OrderToThird>> resultData = new ResultData<>();
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
