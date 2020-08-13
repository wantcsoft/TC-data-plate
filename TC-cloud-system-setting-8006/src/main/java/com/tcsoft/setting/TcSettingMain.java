package com.tcsoft.setting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WMY
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TcSettingMain {

    public static void main(String[] args) {
        SpringApplication.run(TcSettingMain.class, args);
    }

}
