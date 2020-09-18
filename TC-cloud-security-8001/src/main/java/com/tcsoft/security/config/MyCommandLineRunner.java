package com.tcsoft.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 当spring boot项目完全启动后执行run方法
 * @author WMY
 */
@Component
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner {

    @Resource
    private LoadInfoToRedis loadInfoToRedis;

    @Override
    public void run(String... var1){
        loadInfoToRedis.start();
        log.info("加载完成");
    }

}
