package com.tcsoft.sample;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WMY
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TcSampleMain {

    public static void main(String[] args) {
        SpringApplication.run(TcSampleMain.class, args);
    }

}
