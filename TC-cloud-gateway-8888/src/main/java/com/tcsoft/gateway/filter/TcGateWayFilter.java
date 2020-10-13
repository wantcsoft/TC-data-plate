package com.tcsoft.gateway.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcsoft.gateway.entity.JwtUser;
import com.tcsoft.gateway.entity.ResultData;
import com.tcsoft.gateway.utils.JwtTokenUtil;
import com.tcsoft.gateway.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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


/**
 * 网关的全局拦截器，权限认证，token合法性，时效性验证
 * @author WMY
 */
@Component
@Slf4j
public class TcGateWayFilter implements GlobalFilter, Ordered {

    /**
     * 系统超级管理员userId
      */
    @Value("${jwt.userId}")
    private Integer userId;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private JwtTokenUtil jwtTokenUtil;
    /**
     * jwt加密字符串的开头
     */
    private static final String TOKEN_HEAD = "Bearer ";
    /**
     * 用户安全模块的路径
     */
    private static final String SECURITY = "/security/";

    /**
     * 过滤器
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getPath().toString();
        // 如果请求的安全模块，不进行拦截
        if (url.startsWith(SECURITY)){
            return chain.filter(exchange);
        }
        // 获取请求头中的token
        String token = request.getHeaders().getFirst("Authorization");
        // 简单验证一下token是否为空，格式是否正确
        ServerHttpResponse response = exchange.getResponse();
        if(token == null){
            log.info("未携带token");
            return this.setErrorResponse(response,"未携带token");
        }else if (! token.startsWith(TOKEN_HEAD)){
            log.info("token异常");
            return this.setErrorResponse(response,"token异常");
        }else if (jwtTokenUtil.isTokenExpired(token.substring(TOKEN_HEAD.length()))){
            log.info("token过期");
            return this.setErrorResponse(response,"token过期");
        }
        // 验证是否有权访问该url
        token = token.substring(TOKEN_HEAD.length());
        JwtUser jwtUser = jwtTokenUtil.getJwtUser(token);
        // 验证是否是系统管理员
        if (!jwtUser.getUserId().equals(userId)){
            boolean flag = redisUtil.sHasKey("Authority:userId=" + jwtUser.getUserId(), url);
            // 访问的url是否在自己被授权的集合中
            if (!flag){
                log.info("{} 没有权限访问 {}", jwtUser.getUsername(), url);
                return this.setErrorResponse(response, "你没有权限访问");
            }
        }
        log.info("{} 有权限访问 {}", jwtUser.getUsername(), url);
        return chain.filter(exchange);
    }

    /**
     * 设置请求的返回值
     * @param response
     * @param message
     * @return
     */
    protected Mono<Void> setErrorResponse(ServerHttpResponse response, String message){
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        ObjectMapper om = new ObjectMapper();
        ResultData<String> resultData = new ResultData<>();
        resultData.setCode(403);
        resultData.setMessage(message);
        byte[] value = null;
        try {
            value = om.writeValueAsBytes(resultData);
        }catch (Exception e){
            log.error("gateway响应序列化失败");
        }
        return response.writeWith(Mono.just(response.bufferFactory().wrap(value)));
    }

    /**
     * 过滤器加载的顺序 越小,优先级别越高
     */
    @Override
    public int getOrder() {
        return 0;
    }

}
