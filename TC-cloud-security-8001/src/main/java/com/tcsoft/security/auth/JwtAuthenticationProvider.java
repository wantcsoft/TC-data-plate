package com.tcsoft.security.auth;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.mapper.UserPermissionMapper;
import com.tcsoft.security.utils.RedisUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author WMY
 * 验证用户的用户名和密码是否正确
 */
@Component
@Slf4j
public class JwtAuthenticationProvider implements AuthenticationProvider {
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private UserPermissionMapper userPermissionMapper;
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 用户登录时的验证
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @SneakyThrows
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取用户登录时输入的用户名
        String username = authentication.getName();
        // 根据用户名查询系统中的用户信息
        UserDao userDao = userMapper.selectOne(new QueryWrapper<UserDao>()
                .eq("UserName", username));
        // 如果用户列表为空，说明没有匹配的用户，抛出 UsernameNotFoundException
        if (Objects.isNull(userDao)) {
            throw new UsernameNotFoundException(String.format("No qualified userDao[%s]!", username));
        }
        // 如果用户没有设置启用或禁用状态，或者用户被设为禁用，则抛出 DisabledException
        Optional<Boolean> enabled = Optional.of(userDao.isEnabled());
        if (!enabled.orElse(false)) {
            throw new DisabledException(String.format("UserDao[%s] is disabled!", username));
        }
        // 如果用户没有过期状态或过期状态为 true 则抛出 AccountExpiredException
        Optional<Boolean> expired = Optional.of(userDao.isAccountNonExpired());
        if (expired.orElse(true)) {
            throw new AccountExpiredException(String.format("UserDao[%s] is expired!", username));
        }
        // 如果用户没有锁定状态或锁定状态为 true 则抛出 LockedException
        Optional<Boolean> locked = Optional.of(userDao.isAccountNonLocked());
        if (locked.orElse(true)) {
            throw new LockedException(String.format("UserDao[%s] is locked!", username));
        }
        // 如果用户登录时输入的密码和系统中密码匹配，则返回一个完全填充的 Authentication 对象
        if (passwordEncoder.matches(authentication.getCredentials().toString(), userDao.getPassword())){
            loadRedis(userDao.getUserId());
            return new UsernamePasswordAuthenticationToken(authentication, authentication.getCredentials(), new ArrayList<>());
        }
        // 如果密码不匹配则返回 null（此处可以抛异常，试具体应用场景而定）
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    /**
     * 登录时将用户权限信息放入redis中,用户信息失效性为7天,和token保持一致
     * @param userId
     */
    private void loadRedis(int userId){
//        try {
//            redisUtil.setRemove("Authority:userId="+userId);
//        }catch (Exception e){
//            log.error("没有该用户信息");
//        }
        List<String> list = userPermissionMapper.selectAuthorityByUserId(userId);
        Object[] array = list.toArray();
        // 设置过期时间为7天
        long time = System.currentTimeMillis() + expiration * 1000;
        redisUtil.sSetAndTime("Authority:userId="+userId, time, array);
    }
}
