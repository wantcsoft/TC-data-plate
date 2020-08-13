package com.tcsoft.service01.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tcsoft.service01.entity.Dog;
import com.tcsoft.service01.entity.User;
import com.tcsoft.service01.util.RedisUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author WMY
 */
@RestController
public class TestController {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private MongoTemplate mongoTemplate;


    @GetMapping("/redis/set")
    public void setKey () {
        Dog dog = new Dog();
        dog.setName("wangwang");
        dog.setWeight(10);
        com.tcsoft.service01.entity.User user = new User();
        user.setUserName("xiaoming");
        user.setAge(22);
        user.setDog(dog);
        redisUtil.set("1010101", user);
    }

    @GetMapping("/redis/get")
    public Object getKey(){
        Object o = redisUtil.get("1010101");
        System.out.println(o);
        return o;
    }

    @GetMapping("/mongo/set")
    public void putMongo(){
        Dog dog = new Dog();
        dog.setName("wangwang");
        dog.setWeight(10);
        com.tcsoft.service01.entity.User user = new User();
        user.setUserName("xiaoming");
        user.setAge(22);
        user.setDog(dog);
        mongoTemplate.insert(user);
    }

    @GetMapping("/mongo/get")
    public Object getMongo(){
        return mongoTemplate.findAll(User.class);
    }

}

