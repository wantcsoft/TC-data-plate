package com.tcsoft.service01;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Test01 {

    public static void main(String[] args) {
        new Test01().test01();
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
}
