package com.tcsoft.service01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WMY
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TcServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(TcServiceMain.class, args);
    }

}