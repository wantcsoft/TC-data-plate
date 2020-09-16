package com.tcsoft.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.tcsoft.gateway.entity.JwtUser;
import com.tcsoft.gateway.entity.UserGroupDao;
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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * 全局拦截器，权限认证
 * @author WMY
 */
@Component
@Slf4j
public class TcGateWayFilter implements GlobalFilter, Ordered {
    // 系统超级管理员userId
    @Value("${jwt.userId}")
    private Integer userId;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private JwtTokenUtil jwtTokenUtil;
    private static final String TOKEN_HEAD = "Bearer ";
    private static final String SECURITY = "/security/";
    private static final String SYSTEM_GROUP = "system";
    private static final HashSet<String> SETTING_URLS = new HashSet<>(
            Arrays.asList(new String[]{"/setting/actionCode", "/setting/setting/getAgeType",
            "/setting/setting/getInstrumentGroup", "/setting/getInstrumentType",
            "/setting/getPatientType", "/setting/getPrepLinkAbortCode",
            "/setting/getPrepLinkErrorCode", "/setting/getResultRange",
            "/setting/getResultUnit", "/setting/getRuleGroup", "/setting/getSampleType",
            "/setting/getTestItemType", "/setting/getTestType", "/setting/getChemistryContrast",
            "/setting/getComparisonInfo", "/setting/getInstrument", "/setting/getLotSet",
            "/setting/getMaterial", "/setting/getRule", "/setting/getTestItemDeltaCheck",
            "/setting/getTestItemGroup", "/setting/getTestItemGroupItem",
            "/setting/getTestItemInfo"}));

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
            return this.setErrorResponse(response,"未携带token");
        }else if (! token.startsWith(TOKEN_HEAD)){
            return this.setErrorResponse(response,"token异常");
        }else if (jwtTokenUtil.isTokenExpired(token.substring(TOKEN_HEAD.length()))){
            return this.setErrorResponse(response,"token过期");
        }
        // 验证是否有权访问该url
        token = token.substring(TOKEN_HEAD.length());
        JwtUser jwtUser = jwtTokenUtil.getJwtUser(token);
        if (!jwtUser.getUserId().equals(userId)){
            boolean flag = redisUtil.sHasKey("Authority:userId=" + jwtUser.getUserId(), url);
            if (!flag){
                return this.setErrorResponse(response, "你没有权限访问");
            }
        }
        // 当访问系统基础配置信息
        System.out.println(request.getPath());
        if (SETTING_URLS.contains(url)){

            System.out.println(request.getQueryParams().getFirst("hospitalId"));
//            Map<Object, Object> map = redisUtil.hmget("UserGroup");
//            UserGroupDao groupDao = (UserGroupDao) map.get("groupId=" + jwtUser.getGroupId());
//            if (!SYSTEM_GROUP.equals(groupDao.getGroup())){
//                System.out.println(request.getQueryParams());
//            }
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
