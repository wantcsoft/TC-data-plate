package com.tcsoft.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * 网关统一配置跨域
 * @author WMY
 */
@Configuration
public class MyCORSConfig {

    /**
     * 配置CorsWebFilterweb过滤器，允许任意请求头，任意方法，任意来源访问，并且注册到容器中
     * @return
     */
    @Bean
    public CorsWebFilter corsConfig(){
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许任意请求头
        corsConfiguration.addAllowedHeader("*");
        //允许任意方法
        corsConfiguration.addAllowedMethod("*");
        //允许任意请求来源
        corsConfiguration.addAllowedOrigin("*");
        //允许携带cookie
        corsConfiguration.setAllowCredentials(true);
        //表示所有请求都需要跨域
        corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(corsConfigurationSource);
    }

}
