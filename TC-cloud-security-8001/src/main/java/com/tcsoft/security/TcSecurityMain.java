package com.tcsoft.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WMY
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TcSecurityMain {

    public static void main(String[] args) {
        SpringApplication.run(TcSecurityMain.class, args);
    }

}
