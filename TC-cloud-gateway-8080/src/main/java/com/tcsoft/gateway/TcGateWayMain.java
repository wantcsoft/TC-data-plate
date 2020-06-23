package com.tcsoft.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WMY
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TcGateWayMain {

    public static void main(String[] args) {
        SpringApplication.run(TcGateWayMain.class,args);
    }

}
