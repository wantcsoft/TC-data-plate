package com.tcsoft.security.service.user;


import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.utils.JwtTokenUtil;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author big_john
 */
@Service
public class UserLoginService {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    public ResultData<String> login(String username, String password) {
        ResultData<String> resultData = new ResultData<>();
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(username);
        final String token = tokenHead + jwtTokenUtil.generateToken(jwtUser);
        resultData.setMessage("登陆成功");
        resultData.setData(token);
        return resultData;
    }

    public ResultData<String> developLogin(String username, String password){
        ResultData<String> resultData = new ResultData<>();
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtUser.getGroupId() != null && UserConstant.SYSTEM_GROUP_ID != jwtUser.getGroupId()){
            resultData.setCode(401);
            resultData.setMessage("登陆失败");
        }else {
            final String token = tokenHead + jwtTokenUtil.generateToken(jwtUser);
            resultData.setMessage("登陆成功");
            resultData.setData(token);
        }
        return resultData;
    }

    // token刷新服务
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }

}
