package com.tcsoft.setting.config;

import com.tcsoft.setting.filter.SettingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 配置拦截器和过滤器并注册进spring容器中
 * @author WMY
 */
@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {

    /**
     * 将过滤器注册进容器中
     * @return
     */
    @Bean
    public SettingFilter getSettingFilter(){
        return new SettingFilter();
    }

    /**
     * 注册过滤器，并设置过滤哪些url
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSettingFilter()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
