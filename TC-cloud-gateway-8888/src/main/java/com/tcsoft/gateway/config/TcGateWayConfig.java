package com.tcsoft.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * 网关的路由配置
 * @author WMY
 */
@Slf4j
@Configuration
public class TcGateWayConfig {

    /**
     * 配置路由规则实例，并注册到容器中
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        log.info("网关的路由配置");
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        安全模块路由配置
        routes.route("tcsoft-data-platform-security",
                r -> r.path("/security/**")
                        .uri("lb://tcsoft-data-platform-security/security/**"));
//        系统配置模块路由配置
        routes.route("tcsoft-data-platform-system-setting",
                r -> r.path("/setting/**")
                        .uri("lb://tcsoft-data-platform-system-setting/setting/**"));
//        样本模块路由配置
        routes.route("tcsoft-data-platform-sample",
                r -> r.path("/sample/**")
                        .uri("lb://tcsoft-data-platform-sample/sample/**"));

        return routes.build();
    }
}
