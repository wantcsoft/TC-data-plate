package com.tcsoft.security.convert;

import java.util.ArrayList;
import java.util.List;

import com.tcsoft.security.dao.UserAuthorityDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.dao.UserDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


/**
 * JwtUser对象生成器，将数据库的user对象生成JwtUser
 * @author big_john
 */
public final class UserConvertJwtUser {

    private UserConvertJwtUser() {
    }

    public static JwtUser create(UserDao userDao, UserAuthorityDao userAuthorityDao) {
        return new JwtUser(
                userDao.getUserId(),
                userDao.getUsername(),
                userDao.getPassword(),
                mapToGrantedAuthorities(userAuthorityDao.getAuthority()),
                userDao.getLastPasswordResetDate(),
                userDao.isAccountNonLocked(),
                userDao.isAccountNonExpired(),
                userDao.isCredentialsNonExpired(),
                userDao.isEnabled()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(String authorities) {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(authorities));
        return list;
    }
}

