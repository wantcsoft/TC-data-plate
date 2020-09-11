package com.tcsoft.setting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WMY
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.tcsoft.setting.mapper")
public class TcSettingMain {

    public static void main(String[] args) {
        SpringApplication.run(TcSettingMain.class, args);
    }

}
