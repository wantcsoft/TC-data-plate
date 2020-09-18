package com.tcsoft.security.convert;

import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.dao.UserDao;
import org.springframework.security.core.authority.AuthorityUtils;


/**
 * JwtUser对象生成器，将数据库的user对象生成JwtUser
 * @author big_john
 */
public final class UserConvertJwtUser {

    private UserConvertJwtUser() {
    }

    /**
     * 生成jwtUser认证的对象
     * @param userDao
     * @param userRoleDao
     * @return
     */
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

