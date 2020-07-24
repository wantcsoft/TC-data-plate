package com.tcsoft.security.config;

import com.tcsoft.security.auth.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(80)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * 通过登录名查找用户权限等其他信息
     */
    @Resource
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * 用户密码加密处理
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 自定义一个请求拦截过滤器
     * @return
     * @throws Exception
     */
    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers(
                HttpMethod.GET,
                "/",
                "/**/*.jpg",
                "/favicon.ico",
                "/**/index.html",
                "/**/*.css",
                "/**/*.js");
//        放行静态资源
    }

    /**
     * 资源授权处理
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 由于使用的是JWT，我们这里不需要csrf
                .cors().disable()
                .csrf().disable()
                .formLogin()
                    //用户未登录时，访问任何资源都转跳到该路径，即登录页面
                    .loginPage("/html/index.html")
                    //登录认证成功后默认转跳的路径
                    .defaultSuccessUrl("/index")
                .and()
                /**
                 * 认证失败或者权限不足设置，未授权处理
                 */
                .exceptionHandling().authenticationEntryPoint((request, response, exception) -> {
                    // 也可以直接转到登录页面
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                })
                .and()

                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .authorizeRequests()

                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // 对于获取token的rest api要允许匿名访问
                .antMatchers("/auth", "/user").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated();

        // 添加JWT filter
        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity
                .exceptionHandling()
        // 没有权限时处理
                .accessDeniedHandler(((request, response, accessDeniedException) -> {
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json");
                    response.getWriter().println("{\"code\":401,\"message\":\"你没有权限访问\",\"data\":\"\"}");
                    response.getWriter().flush();
                }));

        // 禁用缓存
        httpSecurity.headers().cacheControl();
    }
}
