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

    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.header}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private static final Set<String> IGNORE = new HashSet<>(Arrays
            .asList("/security/login", "/security/register", "/security/develop/register",
                    "/security/develop/login"));

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {
        if (!IGNORE.contains(request.getRequestURI())){
            String authHeader = request.getHeader(this.tokenHeader);
            final String authToken = authHeader.substring(tokenHead.length());
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            logger.info("checking authentication " + username);
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
