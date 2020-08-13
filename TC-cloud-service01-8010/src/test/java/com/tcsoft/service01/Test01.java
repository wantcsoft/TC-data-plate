package com.tcsoft.service01;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tcsoft.service01.entity.Dog;
import com.tcsoft.service01.entity.User;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Test01 {

    public static void main(String[] args) throws JsonProcessingException {
        new Test01().test02();
    }

    public void test01(){

        Stream<Double> doubleStream = Stream.generate(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return Math.random();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0.0;
        });
        doubleStream.forEach(System.out::println);

//        Stream<Integer> integers = Stream.iterate(0, i -> i + 1);
//        integers
//                .forEach((i) -> {
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(1);
//                        System.out.println(i);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                });

    }

    public void test02() throws JsonProcessingException {
        Dog dog = new Dog();
        dog.setName("wangwang");
        dog.setWeight(10);
        User user = new User();
        user.setUserName("xiaoming");
        user.setAge(22);
        user.setDog(dog);
        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(user);
        System.out.println(s);
        User user1 = om.readValue(s, User.class);
        System.out.println(user1);
    }
}
