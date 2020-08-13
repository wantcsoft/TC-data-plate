package com.tcsoft.kafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tcsoft.kafka.entity.User;
import com.tcsoft.kafka.service.SendService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author big_john
 */
@RestController
public class ProducerController {

    @Resource
    private SendService sendService;

    @RequestMapping("/send/{msg}")
    public void send(@PathVariable("msg") String msg) throws JsonProcessingException {
        User user = new User("john", 1);
        sendService.sendMsg(user);

        for (int i = 0; i < 20; i++) {
            user.setAge(user.getAge()+1);
            sendService.sendMsg(user);
        }
    }

}

