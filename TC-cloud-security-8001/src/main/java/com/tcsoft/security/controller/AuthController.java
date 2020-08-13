package com.tcsoft.security.controller;

import com.tcsoft.security.entity.*;
import com.tcsoft.security.service.user.*;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author big_john
 */
@RestController
public class AuthController {
    @Resource
    private UserLoginService userLoginService;
    @Resource
    private DevelopRegisterService developRegisterService;

    /**
     * 用户登录认证,注册开发者账号接口
     * @param userServiceBean
     * @return
     */
    @PostMapping("/auth")
    public ResultData createAuthenticationToken(
            @RequestBody UserServiceBean userServiceBean){
        if (userServiceBean.getType() != null){
            switch (userServiceBean.getType()) {
                case UserConstant.LOGIN:
                    //用户登录
                    if (userServiceBean.getUsername()==null || userServiceBean.getPassword()==null){
                        return nullParameter();
                    }else {
                        return userLoginService.login(userServiceBean.getUsername(), userServiceBean.getPassword());
                    }
                case UserConstant.CREATE:
                    //开发者注册账号
                    if (userServiceBean.getUsername()==null || userServiceBean.getPassword()==null ||
                    userServiceBean.getToken()==null){
                        return nullParameter();
                    }else {
                        return developRegisterService.register(userServiceBean);
                    }
                default:
                    ResultData<String> resultData = new ResultData<>();
                    resultData.setCode(401);
                    resultData.setMessage("type类型不正确");
                    return resultData;
            }
        }else {
            ResultData<String> resultData = new ResultData<>();
            resultData.setCode(401);
            resultData.setMessage("type没有值");
            return resultData;
        }
    }

    /**
     * 缺少必要的参数
     * @return
     */
    private ResultData<String> nullParameter(){
        ResultData<String> resultData = new ResultData<>();
        resultData.setCode(401);
        resultData.setMessage("缺少必要参数");
        return resultData;
    }


//    /**
//     * token刷新服务
//     * @param request
//     * @return
//     * @throws AuthenticationException
//     */
//    @PostAuthorize("returnObject.username == principal.username or hasRole('ROLE_ADMIN')")
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

}
