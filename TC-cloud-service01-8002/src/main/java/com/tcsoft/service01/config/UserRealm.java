package com.tcsoft.service01.config;


import com.tcsoft.service01.Mapper.UserMapper;
import com.tcsoft.service01.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

/**
 * 自定义Realm
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserMapper userMapper;

    /**
     * 授权
     * @param principalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行了授权==》doGetAuthorizationInfo");
        /**
         * 在数据库中加一个角色表和权限表
         */
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:delete");
        //拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
//        info.setObjectPermissions();  设置当前用户的权限

        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return AuthenticationInfo
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("执行了==》认证");

        UsernamePasswordToken userToken = (UsernamePasswordToken)authenticationToken;
        User user = userMapper.queryUserByName(userToken.getUsername());
        if (user == null){
            return null;
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), userToken.getUsername());
    }
}
