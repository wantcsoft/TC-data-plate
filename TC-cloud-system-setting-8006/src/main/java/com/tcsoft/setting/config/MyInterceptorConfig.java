package com.tcsoft.setting.config;

import com.tcsoft.setting.filter.SettingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author WMY
 */
@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {

    @Bean
    public SettingFilter getSettingFilter(){
        return new SettingFilter();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSettingFilter()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
