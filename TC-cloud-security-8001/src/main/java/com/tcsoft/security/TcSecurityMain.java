package com.tcsoft.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author WMY
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.tcsoft.security.mapper")
//开启事务
@EnableTransactionManagement
public class TcSecurityMain {

    public static void main(String[] args) {
        SpringApplication.run(TcSecurityMain.class, args);
    }

}
