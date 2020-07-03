package com.tcsoft.gateway.utils;

import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.Objects;


/**
 * @author WMY
 */
public class TcGateWayUtils {

    public static String getRemoteIp(ServerHttpRequest request) {
//        Squid 服务代理IP
        String ip = request.getHeaders().getFirst("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            Proxy-Client-IP：apache 服务代理IP
            ip = request.getHeaders().getFirst("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            WL-Proxy-Client-IP：weblogic 服务代理IP
            ip = request.getHeaders().getFirst("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "X-Real-IP".equalsIgnoreCase(ip)) {
//            X-Real-IP：nginx服务代理IP
            ip = request.getHeaders().getFirst("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = Objects.requireNonNull(request.getRemoteAddress()).getHostString();
        }
        return ip;
    }
}
