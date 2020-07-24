package com.tcsoft.security.controller;

import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.*;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.mapper.UserRoleMapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.service.user.*;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import java.util.List;

/**
 * @author big_john
 */
@RestController
public class AuthController {
    // 登录
    @Resource
    private UserLoginService userLoginService;
    // 注册
    @Resource
    private UserRegisterService userRegisterService;
    //删除
    @Resource
    private UserDeleteService userDeleteService;
    // 修改
    @Resource
    private UserModifyService userModifyService;
    // 查询
    @Resource
    private UserQueryService userQueryService;

    @Resource
    private UserGroupMapper userGroupMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * 用户登录认证接口
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
//    @PostMapping("/auth")
//    public ResultData<String> createAuthenticationToken(
//            @RequestBody JwtAuthenticationRequest authentication){
//        String username = authentication.getUsername();
//        String password = authentication.getPassword();
//        return userLoginService.login(username, password);
//    }


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

    /**
     * 用户注册接口
     * @param registerUser
     * 需要参数  groupDescription：群组信息（是系统用户还是某个医院）
     *         authorityDescription：权限信息（系统管理员，系统超级用户，系统普通用户，医院管理员，医院超级用户，医院普通用户）
     *         username：用户名（不可以和库中的用户名重名）
     *         password：用户密码（不少于6位）
     *
     * @return
     * @throws AuthenticationException
     */
//    @PostMapping("/auth/register")
//    public ResultData<UserDao> register(@RequestBody RegisterUserBean registerUser) throws Exception {
//        ResultData<UserDao> resultData = new ResultData<>();
//        String groupDescription = registerUser.getGroupDescription();
//        if (groupDescription == null){
//            resultData.setMessage("注册失败，没有群组信息");
//            return resultData;
//        }
//        String roleDescription = registerUser.getRoleDescription();
//        //注册系统用户
//        if (groupDescription.equals(UserConstant.SYSTEM_GROUP)){
//            if (roleDescription.equals(UserConstant.SYSTEM_ADMIN)){
//                resultData.setMessage("注册失败，无法注册");
//                return resultData;
//            }else if (roleDescription.equals(UserConstant.SYSTEM_SUPER_USER)){
//                // 注册系统管理员
//                return userRegisterService.registerSystemSuperUser(registerUser);
//            }else if (roleDescription.equals(UserConstant.SYSTEM_USER)){
//                // 注册系统普通用户
//                return userRegisterService.registerSystemUser(registerUser);
//            }else {
//                resultData.setMessage("注册失败，权限信息不正确");
//                return resultData;
//            }
//        }
//        // 注册医院用户
//        UserGroupDao userGroupDao = userGroupMapper.queryGroupByDescription(groupDescription);
//        if (userGroupDao == null){
//            resultData.setMessage("注册失败，群组信息不正确");
//            return resultData;
//        }else {
//            if (roleDescription.equals(UserConstant.HOSPITAL)){
//                //注册医院用户
////                return userRegisterService.registerHospitalUser(registerUser);
//                return null;
//            }else {
//                resultData.setMessage("注册失败，权限信息不正确");
//                return resultData;
//            }
//        }
//    }

    /**
     * 用户信息修改
//     * @param modifyUser
     * @return
     */
    @PostMapping("/auth/modify")
//    public ResultData<UserDao> modify(@RequestBody ModifyUserBean modifyUser) throws Exception{
//        ResultData<UserDao> resultData = new ResultData<>();
//        Integer userId = modifyUser.getUserId();
//        if (userMapper.queryUserById(userId) == null) {
//            resultData.setMessage("要修改的用户不存在");
//            return resultData;
//        } else {
//            String groupDescription = modifyUser.getGroupDescription();
//            String roleDescription = modifyUser.getRoleDescription();
//            if (groupDescription.equals(UserConstant.SYSTEM_GROUP)){
//                //修改为系统用户
//                if (roleDescription.equals(UserConstant.SYSTEM_ADMIN)){
//                    //修改为系统管理员
//                    resultData.setMessage("无法创建");
//                    return resultData;
//                } else if (roleDescription.equals(UserConstant.SYSTEM_SUPER_USER)){
//                    //修改系统超级用户
//                    return userModifyService.modifySystemSuperUser(modifyUser, resultData);
//                } else if (roleDescription.equals(UserConstant.SYSTEM_USER)){
//                    //修改为系统普通用户
//                    return userModifyService.modifySystemUser(modifyUser, resultData);
//                } else {
//                    resultData.setMessage("角色不存在");
//                    return resultData;
//                }
//            } else {
//                //修改为医院用户
//                if (roleDescription.equals(UserConstant.ADMIN)){
//                    //修改为医院管理员
//                    return userModifyService.modifyAdmin(modifyUser, resultData);
//                } else if (roleDescription.equals(UserConstant.SUPER_USER)){
//                    //修改为医院超级用户
//                    return userModifyService.modifySuperUser(modifyUser, resultData);
//                } else if (roleDescription.equals(UserConstant.USER)){
//                    //修改为医院普通用户
//                    return userModifyService.modifyUser(modifyUser, resultData);
//                } else {
//                    resultData.setMessage("角色不存在");
//                    return resultData;
//                }
//            }
//        }
//    }

    /**
     * 输入用户名即可删除用户信息
     * @param username
     * @return
     */
//    @DeleteMapping("/auth/delete")
//    public ResultData<UserDao> delete(@RequestParam String username){
//        ResultData<UserDao> resultData = new ResultData<>();
//        if (username == null){
//            resultData.setMessage("请输入用户名");
//            return resultData;
//        } else {
//            UserDao userDao = userMapper.queryUserByName(username);
//            if (userDao == null){
//                resultData.setMessage("要删除的用户不存在");
//                return resultData;
//            } else {
//                UserRoleDao userRoleDao = userRoleMapper.queryRoleByName(username);
//                String roleDescription = userRoleDao.getRoleDescription();
//                if (roleDescription.equals(UserConstant.SYSTEM_ADMIN)){
//                    //删除系统管理员
//                    resultData.setCode(401);
//                    resultData.setMessage("您没有此权限");
//                    return resultData;
//                } else if (roleDescription.equals(UserConstant.SYSTEM_SUPER_USER)){
//                    //删除系统超级用户
//                    return userDeleteService.deleteSystemSuperUser(username);
//                } else if (roleDescription.equals(UserConstant.SYSTEM_USER)){
//                    //删除系统普通用户
//                    return userDeleteService.deleteSystemUser(username);
//                } else if (roleDescription.equals(UserConstant.ADMIN)){
//                    //删除医院管理员
//                    return userDeleteService.deleteAdmin(username);
//                } else if (roleDescription.equals(UserConstant.SUPER_USER)){
//                    //删除医院的超级用户
//                    return userDeleteService.deleteSuperUser(username);
//                } else if (roleDescription.equals(UserConstant.USER)){
//                    //删除医院普通用户
//                    return userDeleteService.deleteUser(username);
//                } else {
//                    resultData.setMessage("该用户信息异常，请联系管理员");
//                    return resultData;
//                }
//            }
//        }
//    }

    /**
     * 获取所有用户信息
     *
     * @return
     */
    @GetMapping("/auth/queryAll")
    public ResultData<List<QueryUserBean>> getUsers(Authentication authentication) {
        ResultData<List<QueryUserBean>> resultData = new ResultData<>();
        if (authentication == null || authentication.getPrincipal() == null) {
            resultData.setCode(402);
            resultData.setMessage("身份已过期,重新登陆");
            return resultData;
        }
        try{
            JwtUser user = (JwtUser) authentication.getPrincipal();
            String username = user.getUsername();
            return userQueryService.queryAllUser(username, resultData);
        }catch (Exception e){
            resultData.setCode(402);
            resultData.setMessage("身份已过期，重新登陆");
            return resultData;
        }
    }

    @GetMapping("/auth/queryByName")
    public ResultData<List<QueryUserBean>> getUserByName(@RequestParam String username, Authentication authentication) {
        ResultData<List<QueryUserBean>> resultData = new ResultData<>();
        if (authentication == null || authentication.getPrincipal() == null) {
            resultData.setCode(402);
            resultData.setMessage("身份已过期,重新登陆");
            return resultData;
        }
        try {
            JwtUser user = (JwtUser) authentication.getPrincipal();
            return userQueryService.queryUserByName(username, user, resultData);
        } catch (Exception e) {
            resultData.setCode(402);
            resultData.setMessage("身份已过期，重新登陆");
            return resultData;
        }
    }
}
