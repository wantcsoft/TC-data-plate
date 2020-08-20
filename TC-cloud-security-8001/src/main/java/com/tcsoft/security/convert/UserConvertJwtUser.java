package com.tcsoft.security.convert;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.scene.control.skin.LabeledImpl;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.dao.UserDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


/**
 * JwtUser对象生成器，将数据库的user对象生成JwtUser
 * @author big_john
 */
public final class UserConvertJwtUser {

    private UserConvertJwtUser() {
    }

    public static JwtUser create(UserDao userDao, UserRoleDao userRoleDao) {
        JwtUser jwtUser = new JwtUser();

        jwtUser.setUserId(userDao.getUserId());
        jwtUser.setUsername(userDao.getUsername());
        jwtUser.setPassword(userDao.getPassword());
        jwtUser.setGroupId(userDao.getGroupId());
        jwtUser.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(userRoleDao.getRole()));
        jwtUser.setLastPasswordResetDate(userDao.getLastPasswordResetDate());
        jwtUser.setAccountNonLocked(userDao.isAccountNonLocked());
        jwtUser.setAccountNonExpired(userDao.isAccountNonExpired());
        jwtUser.setCredentialsNonExpired(userDao.isCredentialsNonExpired());
        jwtUser.setEnabled(userDao.isEnabled());
        return jwtUser;
    }

}

