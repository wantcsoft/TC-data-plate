package com.tcsoft.setting.config;

import com.tcsoft.setting.utils.LoadConfigToRedis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author WMY
 */
@Component
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner {

    @Resource
    private LoadConfigToRedis loadConfigToRedis;

    @Override
    public void run(String... var1){
        loadConfigToRedis.start();
        log.info("配置类全部加载完成");
    }

}
