package com.tcsoft.security.service;

import com.tcsoft.security.convert.UserConvertJwtUser;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.mapper.UserRoleMapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.dao.UserDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


/**
 * 继承UserDetailsService实现通过用户名查找用户信息返回UserDetails实现类
 * @author big_john
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDao userDao = userMapper.queryUserByName(username);
        UserRoleDao userRoleDao = userRoleMapper.queryRoleByName(username);
        if (userDao == null) {
            throw new UsernameNotFoundException(String.format("没有找到该用户 '%s'.", username));
        } else {
            return UserConvertJwtUser.create(userDao, userRoleDao);
        }
    }
}