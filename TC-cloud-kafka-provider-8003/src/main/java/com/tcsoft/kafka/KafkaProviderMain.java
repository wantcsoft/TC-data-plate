package com.tcsoft.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author big_john
 */
@SpringBootApplication
@EnableDiscoveryClient
public class KafkaProviderMain {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProviderMain.class, args);
    }

}
