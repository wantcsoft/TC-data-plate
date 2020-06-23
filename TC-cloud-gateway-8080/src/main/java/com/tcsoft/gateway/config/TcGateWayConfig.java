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
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        log.info("网关的路由配置");
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_xd",
                r -> r.path("/guonei").uri("https://news.baidu.com/guonei"));
        routes.route("path_route_xd2",
                r -> r.path("/security/**").uri("http://localhost:8001/security/**"));
        routes.route("path_route_xd1",
                r -> r.path("/service/**").uri("http://localhost:8002/service/**"));
        return routes.build();
    }
}
