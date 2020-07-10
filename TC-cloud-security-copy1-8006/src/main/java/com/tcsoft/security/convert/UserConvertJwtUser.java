package com.tcsoft.security.convert;

import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;


/**
 * JwtUser对象生成器，将数据库的user对象生成JwtUser
 * @author big_john
 */
public final class UserConvertJwtUser {

    private UserConvertJwtUser() {
    }

    public static JwtUser create(UserDao userDao, UserRoleDao userRoleDao) {
        return new JwtUser(
                userDao.getUserId(),
                userDao.getUsername(),
                userDao.getPassword(),
                userDao.getGroupId(),
                mapToGrantedAuthorities(userRoleDao.getRole()),
                userDao.getLastPasswordResetDate(),
                userDao.isAccountNonLocked(),
                userDao.isAccountNonExpired(),
                userDao.isCredentialsNonExpired(),
                userDao.isEnabled()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(String roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(roles));
        return list;
    }
}

