package com.tcsoft.service01.controller;

import com.tcsoft.service01.entity.AuditStateViewModel;
import com.tcsoft.service01.entity.Dog;
import com.tcsoft.service01.entity.User;
import com.tcsoft.service01.util.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;


/**
 * @author WMY
 */
@RestController
public class TestController {

    @Resource
    private RedisUtil redisUtil;

//    @Resource
//    private MongoTemplate mongoTemplate;


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
        Map<Object, Object> auditState = redisUtil.hmget("AuditState");
        System.out.println(auditState.get("auditStateId=2"));
        return "hello";
    }

//    @GetMapping("/mongo/set")
//    public void putMongo(){
//        Dog dog = new Dog();
//        dog.setName("wangwang");
//        dog.setWeight(10);
//        com.tcsoft.service01.entity.User user = new User();
//        user.setUserName("xiaoming");
//        user.setAge(22);
//        user.setDog(dog);
//        mongoTemplate.insert(user);
//    }
//
//    @GetMapping("/mongo/get")
//    public Object getMongo(){
//        return mongoTemplate.findAll(User.class);
//    }

}

