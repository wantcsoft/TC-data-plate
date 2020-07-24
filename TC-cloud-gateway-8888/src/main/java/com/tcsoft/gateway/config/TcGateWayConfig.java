package com.tcsoft.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author WMY
 */
@Slf4j
@Configuration
public class TcGateWayConfig {

    /**
     * 配置路由规则
     * @param routeLocatorBuilder
     * @return
     */
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
//        log.info("网关的路由配置");
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        routes.route("path_route_xd",
//                r -> r.path("/guonei").uri("https://news.baidu.com/guonei"));
//        routes.route("tc-security",
//                r -> r.path("/**").uri("http://192.168.3.3:8001/**"));
//        return routes.build();
//    }
}
