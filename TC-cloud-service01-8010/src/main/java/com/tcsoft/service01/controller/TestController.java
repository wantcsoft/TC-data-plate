package com.tcsoft.service01.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author WMY
 */
@RestController
public class TestController {

    @Resource
    private StringRedisTemplate redisTemplate;

    @GetMapping(value = "/redis/set")
    public void setKey () throws JsonProcessingException {
        User user = new User("john", "616162728", 23);
        ObjectMapper objectMapper = new ObjectMapper();
        String uu = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        redisTemplate.opsForValue().set("dasda", uu);
    }

    @GetMapping("/redis/get")
    public Object getKey(){
        return redisTemplate.opsForValue().get("dasda");
    }

}

