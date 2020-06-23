package com.tcsoft.security.auth;


import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.user.User;
import lombok.SneakyThrows;
import org.bouncycastle.openssl.PasswordException;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author WMY
 * 验证用户的用户名和密码是否正确
 */
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserMapper userMapper;

    @SneakyThrows
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取用户登录时输入的用户名
        String username = authentication.getName();
        // 根据用户名查询系统中的用户信息
        User user = userMapper.queryUserByName(username);
        // 如果用户列表为空，说明没有匹配的用户，抛出 UsernameNotFoundException
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("No qualified user[%s]!", username));
        }
//        // 如果用户没有设置启用或禁用状态，或者用户被设为禁用，则抛出 DisabledException
//        Optional<Boolean> enabled = Optional.of(user.getEnabled());
//        if (!enabled.orElse(false)) {
//            throw new DisabledException(String.format("User[%s] is disabled!", username));
//        }
//        // 如果用户没有过期状态或过期状态为 true 则抛出 AccountExpiredException
//        Optional<Boolean> expired = Optional.of(user.getExpired());
//        if (expired.orElse(true)) {
//            throw new AccountExpiredException(String.format("User[%s] is expired!", username));
//        }
//        // 如果用户没有锁定状态或锁定状态为 true 则抛出 LockedException
//        Optional<Boolean> locked = Optional.of(user.getLocked());
//        if (locked.orElse(true)) {
//            throw new LockedException(String.format("User[%s] is locked!", username));
//        }
        // 如果用户登录时输入的密码和系统中密码匹配，则返回一个完全填充的 Authentication 对象
        if (user.getPassword().equals(authentication.getCredentials().toString())) {
            return new UsernamePasswordAuthenticationToken(authentication, authentication.getCredentials(), new ArrayList<>());
        }
        // 如果密码不匹配则返回 null（此处可以抛异常，试具体应用场景而定）
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
