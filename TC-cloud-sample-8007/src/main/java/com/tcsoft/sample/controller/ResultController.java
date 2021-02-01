package com.tcsoft.sample.controller;


import com.tcsoft.sample.entity.InfoFromThird;
import com.tcsoft.sample.entity.ResultData;
import com.tcsoft.sample.service.InfoFromThirdService;
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

//    @Resource
//    private SendResultKafka sendService;
    @Resource
    private InfoFromThirdService infoFromThirdService;

    /**
     * 获取第三方得检测结果
     * @param resultList
     * @return
     */
    @PostMapping("/push")
    public void pushResult(@RequestBody List<InfoFromThird> resultList){
        for (InfoFromThird result:resultList){
//            sendService.send(result);
        }
    }

    /**
     * Lis从数据平台获取检测结果
     * @param
     * @return
     */
    @GetMapping("/pull")
    public ResultData<List<InfoFromThird>> pullResult(){
        ResultData<List<InfoFromThird>> resultData = new ResultData<>();
        List<InfoFromThird> list = infoFromThirdService.list();
        resultData.setData(list);
        return resultData;
    }

}
