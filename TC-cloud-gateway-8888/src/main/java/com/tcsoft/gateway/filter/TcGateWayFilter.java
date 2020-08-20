package com.tcsoft.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.tcsoft.gateway.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 全局拦截器，权限认证
 * @author WMY
 */
@Component
@Slf4j
public class TcGateWayFilter implements GlobalFilter, Ordered {
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    private static final Set<String> IGNORE = new HashSet<>(Arrays
            .asList("/security/login", "/security/register", "/security/develop/register",
                    "/security/develop/login"));

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
//        如果请求的登录连接或者注册链接，不进行拦截
        if (IGNORE.contains(request.getPath().toString())){
            return chain.filter(exchange);
        }
//        获取请求头中的token
        String token = request.getHeaders().getFirst("Authorization");
//        简单验证一下token是否为空，格式是否正确
        ServerHttpResponse response = exchange.getResponse();
        if(token == null){
            return this.setErrorResponse(response,"未携带token");
        }else if (! token.startsWith("Bearer")){
            return this.setErrorResponse(response,"token异常");
        }else if (jwtTokenUtil.isTokenExpired(token.substring("Bearer ".length()))){
            return this.setErrorResponse(response,"token过期");
        }
        return  chain.filter(exchange);
    }

    /**
     * 返回值
     * @param response
     * @param message
     * @return
     */
    protected Mono<Void> setErrorResponse(ServerHttpResponse response, String message){
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code", 403);
        jsonObject.put("data", null);
        jsonObject.put("message",message);
        return response.writeWith(Mono.just(response.bufferFactory().wrap(jsonObject.toString().getBytes())));
    }

    /**
     * 过滤器加载的顺序 越小,优先级别越高
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
