package com.tcsoft.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.tcsoft.gateway.utils.JwtUtil;
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



/**
 * @author WMY
 */
@Component
@Slf4j
public class TcGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("这个是gateway过滤器");
        ServerHttpRequest request = exchange.getRequest();
        System.out.println(exchange.getRequest().getHeaders());
//        如果请求的URL含有login，不进行拦截
        if(request.getPath().value().contains("login") || request.getPath().value().contains("index")){
            return chain.filter(exchange);
        }
        ServerHttpResponse response = exchange.getResponse();
//        获取请求头中的token
        String token = request.getHeaders().getFirst("Authoriszation");
//        简单验证一下token是否为空，格式是否正确
        if(token == null || ! token.startsWith("eyJhbGciOiJIUzI1NiJ9")){
            return this.setErrorResponse(response,"未携带token");
        }
        try {
            exchange.getAttributes().put("user", JwtUtil.parseJWT(token));
        }catch(Exception e) {
            return this.setErrorResponse(response,e.getMessage());
        }
        return  chain.filter(exchange);
    }

    protected Mono<Void> setErrorResponse(ServerHttpResponse response, String message){
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("status_code",500);
        jsonObject.put("data",message);
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