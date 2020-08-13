package com.tcsoft.sample;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WMY
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SampleMain {

    public static void main(String[] args) {
        SpringApplication.run(SampleMain.class, args);
    }

}
