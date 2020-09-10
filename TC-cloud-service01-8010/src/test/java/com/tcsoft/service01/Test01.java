package com.tcsoft.service01;

import com.tcsoft.service01.util.RedisUtil;

import javax.annotation.Resource;

public class Test01 {

    @Resource
    private RedisUtil redisUtil;

    public static void main(String[] args){
        new Test01().getInfoFromRedis();
    }

    public void getInfoFromRedis(){
        System.out.println(redisUtil.get("hello"));
    }

//    public void test01(){
//
//        Stream<Double> doubleStream = Stream.generate(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                return Math.random();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return 0.0;
//        });
//        doubleStream.forEach(System.out::println);
//
////        Stream<Integer> integers = Stream.iterate(0, i -> i + 1);
////        integers
////                .forEach((i) -> {
////                    try {
////                        TimeUnit.MILLISECONDS.sleep(1);
////                        System.out.println(i);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                });
//
//    }
//
//    public void test02() throws JsonProcessingException {
//        Dog dog = new Dog();
//        dog.setName("wangwang");
//        dog.setWeight(10);
//        User user = new User();
//        user.setUserName("xiaoming");
//        user.setAge(22);
//        user.setDog(dog);
//        ObjectMapper om = new ObjectMapper();
//        String s = om.writeValueAsString(user);
//        System.out.println(s);
//        User user1 = om.readValue(s, User.class);
//        System.out.println(user1);
//    }
}
