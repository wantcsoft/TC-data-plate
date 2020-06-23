package com.tcsoft.service01.config;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * 创建一个shiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        /**
         * 添加shiro内置过滤器
         * anon:    无需认证即可访问
         * authc:   必须认证才可以访问
         * perms:   拥有对某个资源的权限才可以访问
         * role；    拥有某个角色的权限才可以访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/service/add", "authc");
        filterMap.put("/service/delete", "perms[user:delete]");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setLoginUrl("/service/login");
        return shiroFilterFactoryBean;
    }

    /**
     * 创建一个DefaultWebSecurityManage
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    /**
     * 创建一个realm对象
     */
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
