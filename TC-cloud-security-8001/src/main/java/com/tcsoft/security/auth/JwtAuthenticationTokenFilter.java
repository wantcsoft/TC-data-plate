package com.tcsoft.security.auth;


import com.tcsoft.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 请求过滤器，如果携带token，可以转到登录页面
 * 如果携带token,验证token合法性和权限
 * @author WMY
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    /**
     * jwt的token生成与解析工具
     */
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    /**
     * http请求头字段
     */
    @Value("${jwt.header}")
    private String header;
    /**
     * token加密字符串的开头
     */
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 访问验证忽略下面URL
     */
    private static final Set<String> IGNORE = new HashSet<>(Arrays
            .asList("/security/login", "/security/register", "/security/develop/register",
                    "/security/develop/login"));

    /**
     * 每次访问时的验证逻辑，验证token里的信息
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 跳过忽略的URL
        if (!IGNORE.contains(request.getRequestURI())){
            String authHeader = request.getHeader(header);
            final String authToken = authHeader.substring(tokenHead.length());
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            logger.info("checking authentication " + username);
            // 解析token并验证里面的信息
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails jwtUser = jwtTokenUtil.getJwtUser(authToken);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        jwtUser, null, jwtUser.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }
}
