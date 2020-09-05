package com.tcsoft.sample.controller;


import com.tcsoft.sample.entity.InfoFromThird;
import com.tcsoft.sample.entity.external.SendTest;
import com.tcsoft.sample.entity.ResultData;
import com.tcsoft.sample.service.kafka.SendResultKafka;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

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
     * @param resultList
     * @return
     */
    @PostMapping("/push")
    public ResultData<String> pushResult(@RequestBody List<InfoFromThird> resultList){
        ResultData<String> resultData = new ResultData<>();
        resultData.setMessage("上传成功");
        resultList.forEach((result) -> {
            if (!sendService.send(result)){
                resultData.setCode(401);
                resultData.setMessage("上传失败");
            }
        });
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

        return resultData;
    }

}
