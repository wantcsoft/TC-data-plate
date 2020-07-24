package com.tcsoft.kafka.controller;

import com.tcsoft.kafka.entity.User;
import com.tcsoft.kafka.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author big_john
 */
@RestController
public class ProducerController {

    @Resource
    private SendService sendService;

    @RequestMapping("/send/{msg}")
    public void send(@PathVariable("msg") String msg) throws InterruptedException {
        sendService.sendMsg(new User("wan", 22));
    }
}

