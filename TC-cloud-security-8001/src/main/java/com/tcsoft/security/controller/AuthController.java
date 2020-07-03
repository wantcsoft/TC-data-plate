package com.tcsoft.security.controller;

import com.tcsoft.security.entity.FrontUser;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.service.UserService;
import com.tcsoft.security.entity.JwtAuthenticationRequest;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.entity.ResultData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;

/**
 * @author big_john
 */
@RestController
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    /**
     * 登录注册认证注册服务
     */
    @Resource
    private UserService userService;

    /**
     * 用户登录认证接口
     * @param authenticationRequest
     * @return
     * @throws AuthenticationException
     */
    @PostMapping("/auth")
    public ResultData createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        return userService.login(username, password);
    }

    /**
     * token刷新服务
     * @param request
     * @return
     * @throws AuthenticationException
     */
//    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
//    public ResponseEntity<?> refreshAndGetAuthenticationToken(
//            HttpServletRequest request) throws AuthenticationException{
//        String token = request.getHeader(tokenHeader);
//        String refreshedToken = userService.refresh(token);
//        if(refreshedToken == null) {
//            return ResponseEntity.badRequest().body(null);
//        } else {
//            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
//        }
//    }

    /**
     * 用户注册接口
     * @param addedUser
     * @return
     * @throws AuthenticationException
     */
    @PostMapping("/auth/register")
    public ResultData register(@RequestBody FrontUser addedUser, Authentication authentication){
        System.out.println(authentication.getDetails());
        System.out.println(authentication.getPrincipal());
        System.out.println(authentication.getAuthorities());
        return userService.register(addedUser);
    }

    /**
     * 用户信息修改
     * @param modifyUser
     * @return
     */
    @PostMapping("/auth/modify")
    public ResultData modify(@RequestBody FrontUser modifyUser, Authentication authentication){
        ResultData<String> resultData = new ResultData<>();
        if (authentication == null || authentication.getPrincipal() == null) {
            resultData.setCode(402);
            resultData.setMessage("身份已过期,重新登陆");
            return resultData;
        }
        try{
            JwtUser user = (JwtUser) authentication.getPrincipal();
            String username = user.getUsername();
            return userService.modify(modifyUser);
        }catch (Exception e){
            resultData.setCode(402);
            resultData.setMessage("身份已过期，重新登陆");
            return resultData;
        }
    }

    @DeleteMapping("/auth/delete")
    public ResultData delete(@RequestBody UserDao deleteUser){
        return userService.delete(deleteUser);
    }

    /**
     * 获取所有用户信息
     *
     * @return
     */
//    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @GetMapping("/auth/total")
    public ResultData getUsers(Authentication authentication) {
        ResultData<String> resultData = new ResultData<>();
        if (authentication == null || authentication.getPrincipal() == null) {
            resultData.setCode(402);
            resultData.setMessage("身份已过期,重新登陆");
            return resultData;
        }
        try{
            JwtUser user = (JwtUser) authentication.getPrincipal();
            String username = user.getUsername();
            return userService.getAllUser(username);
        }catch (Exception e){
            resultData.setCode(402);
            resultData.setMessage("身份已过期，重新登陆");
            return resultData;
        }
    }
}
