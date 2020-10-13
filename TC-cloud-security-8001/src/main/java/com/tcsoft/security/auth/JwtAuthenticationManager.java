package com.tcsoft.security.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author WMY
 * 将请求转到用户验证AuthenticationProvider类
 */
@Slf4j
@Component
public class JwtAuthenticationManager
        implements AuthenticationManager {

    private final AuthenticationProvider authenticationProvider;

    public JwtAuthenticationManager(
            AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    /**
     * 用户登录认证
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        Authentication result = authenticationProvider.authenticate(authentication);
        if (Objects.nonNull(result)) {
            log.info("认证成功");
            return result;
        }
        log.info("认证失败");
        throw new ProviderNotFoundException("认证失败");
    }
}
