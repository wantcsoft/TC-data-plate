package com.tcsoft.sample.controller;


import com.tcsoft.sample.entity.ResultFromThird;
import com.tcsoft.sample.entity.external.SendTest;
import com.tcsoft.sample.entity.ResultData;
import com.tcsoft.sample.service.kafka.SendResultKafka;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 检测结果的接口
 * @author WMY
 */
@RestController
@RequestMapping("/result")
public class ResultController {

    @Resource
    private SendResultKafka sendService;

    /**
     * 获取第三方得检测结果
     * @param result
     * @return
     */
    @PostMapping("/push")
    public ResultData<String> pushResult(@RequestBody ResultFromThird result){
        ResultData<String> resultData = new ResultData<>();
        if (sendService.send(result)){
            resultData.setMessage("上传成功");
        }else {
            resultData.setCode(401);
            resultData.setMessage("上传失败");
        }
        return resultData;
    }

    /**
     * Lis从数据平台获取检测结果
     * @param sampleNo
     * @return
     */
    @GetMapping("/pull")
    public ResultData<SendTest> pullResult(@RequestParam Integer sampleNo){
        ResultData<SendTest> resultData = new ResultData<>();
//        List<ProgItemDao> progItemList = progItemService.list(new QueryWrapper<ProgItemDao>()
//                .eq("SampleNo", sampleNo));
//        SampleInfoDao sampleInfoDao = sampleInfoService.getById(sampleNo);
//        SendTest sendTest = new SendTest();
//        BeanUtils.copyProperties(sampleInfoDao, sendTest);
//        sendTest.setProgramTests(progItemList);
//        resultData.setMessage("操作成功");
//        resultData.setData(sendTest);
        return resultData;
    }

}
