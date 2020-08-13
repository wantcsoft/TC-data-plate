package com.tcsoft.sample.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.sample.dao.ProgItemDao;
import com.tcsoft.sample.dao.SampleInfoDao;
import com.tcsoft.sample.entity.SendTest;
import com.tcsoft.sample.entity.ResultData;
import com.tcsoft.sample.service.impl.ProgItemServiceImpl;
import com.tcsoft.sample.service.impl.SampleInfoServiceImpl;
import com.tcsoft.sample.service.kafka.ReceiveResultSendService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author WMY
 */
@RestController
public class TestInfoController {

    @Resource
    private ProgItemServiceImpl progItemService;
    @Resource
    private SampleInfoServiceImpl sampleInfoService;
    @Resource
    private ReceiveResultSendService sendService;

    @PostMapping("/testInfo")
    public String fromPoc(@RequestBody String list){
        return sendService.send(list) ? "上传成功" : "上传失败";
    }

    @GetMapping("/testInfo")
    public ResultData<SendTest> toPoc(@RequestParam Integer sampleNo){
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
