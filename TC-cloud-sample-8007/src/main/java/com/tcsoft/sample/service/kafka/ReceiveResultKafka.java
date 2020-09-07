package com.tcsoft.sample.service.kafka;


import com.tcsoft.sample.entity.InfoFromThird;
import com.tcsoft.sample.mapper.InfoFromThirdMapper;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import javax.annotation.Resource;

/**
 * 从kafka中获取检测结果
 * @author WMY
 */
@EnableBinding(ResultChannel.class)
public class ReceiveResultKafka {
    @Resource
    private InfoFromThirdMapper infoFromThirdMapper;

    @StreamListener(ResultChannel.INPUT)
    public void receive(InfoFromThird result) {
        boolean flag = saveResult(result);
        System.out.println(flag);
    }

    private boolean saveResult(InfoFromThird result){
        return infoFromThirdMapper.insert(result)==1;
    }

}
