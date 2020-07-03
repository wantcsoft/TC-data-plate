package com.tcsoft.security.service.impl;


import com.tcsoft.security.dao.UserAuthorityDao;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.entity.FrontUser;
import com.tcsoft.security.mapper.UserAuthorityMapper;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.service.UserService;
import com.tcsoft.security.utils.JwtTokenUtil;
import com.tcsoft.security.entity.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 注册登录接口实现类
 * @author big_john
 */
@Service
public class UserServiceImpl implements UserService {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserGroupMapper userGroupMapper;
    @Resource
    private UserAuthorityMapper userAuthorityMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public UserServiceImpl(
            AuthenticationManager authenticationManager,
            @Qualifier("jwtUserDetailsServiceImpl") UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PreAuthorize("hasRole('system_admin')")
    @Override
    public ResultData<String> register(FrontUser userToAdd) {
        ResultData<String> resultData = new ResultData<>();
        final String username = userToAdd.getUsername();
        if(userMapper.queryUserByName(username)!=null) {
            resultData.setMessage("用户名已存在！");
            return resultData;
        }
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        final String rawPassword = userToAdd.getPassword();
//        userToAdd.setPassword(encoder.encode(rawPassword));
//        userToAdd.setLastPasswordResetDate(new Date());
//        if (userMapper.insertOne(userToAdd)){
//            resultData.setMessage("用户注册成功");
//        }else{
//            resultData.setMessage("用户注册失败");
//        }
        resultData.setMessage("用户名已存在");
        return resultData;
    }

    @Override
    public ResultData<String> login(String username, String password) {
        ResultData<String> resultData = new ResultData<String>();
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = tokenHead + jwtTokenUtil.generateToken(userDetails);
        resultData.setMessage("登陆成功");
        resultData.setData(token);
        return resultData;
    }

    @Override
    public ResultData<String> modify(FrontUser userToModify) {
        ResultData<String> resultData = new ResultData<>();
        String username = userToModify.getUsername();
        Integer id = userToModify.getUserId();
        if(userMapper.querySameUserName(id, username)!=null) {
            resultData.setMessage("用户名已存在！");
            return resultData;
        }
        UserDao userDao = new UserDao();
        userDao.setUserId(id);
        userDao.setUsername(username);
//        设置用户的组ID
        UserGroupDao userGroupDao = userGroupMapper.queryGroupByDescription(userToModify.getGroupDescription());
        userDao.setGroupId(userGroupDao.getGroupId());
//        设置用户的权限ID
        UserAuthorityDao userAuthorityDao = userAuthorityMapper.queryAuthonrityId(userToModify.getAuthorityDescription());
        userDao.setAuthorityId(userAuthorityDao.getAuthorityId());

        userDao.setAccountNonLocked(userToModify.isAccountNonLocked());
        userDao.setEnabled(userToModify.isEnabled());
        if (userMapper.updateOne(userDao)){
            resultData.setMessage("用户信息修改成功");
        }else{
            resultData.setMessage("用户信息修改失败");
        }
        return resultData;
    }

    /**
     * 删除指定的用户信息
     * @param userDelete
     * @return
     */
    @Override
    public ResultData delete(UserDao userDelete) {
        ResultData<String> resultData = new ResultData<>();
        final Integer id = userDelete.getUserId();
        if(userMapper.queryUserById(id) == null) {
            resultData.setMessage("用户不存在");
            return resultData;
        }
        if (userMapper.deleteOne(id)){
            resultData.setMessage("用户删除成功");
        }else {
            resultData.setMessage("用户删除失败");
        }
        return resultData;
    }

    @Override
    public ResultData getAllUser(String username) {
        ResultData<List<FrontUser>> resultData = new ResultData<>();
        List<FrontUser> userList;
        UserDao currentUser = userMapper.queryUserByName(username);
        Integer groupId = currentUser.getGroupId();
        Integer grade = userMapper.queryUserAuthorityGrade(username);
        if (currentUser == null){
            resultData.setMessage("用户不存在");
            return resultData;
        }else {
            if (groupId == 1){
                // 系统级用户，可以查看所有医院用户信息,还有比自己等级低的系统用户
                Integer maxGrade = userAuthorityMapper.queryMaxGrade();
                if (grade.equals(maxGrade)){
                    // 这是系统管理员用户，权限最高
                    userList = userMapper.systemAdminQueryAllUser();
                }else {
                    // 其他系统用户查看比自己等级低的用户
                    userList = userMapper.systemQueryAllUser(grade);
                }
            }else {
                // 这是一个医院用户，只能查看本医院的用户
                Integer level = 1;
                userList = userMapper.hospitalQueryAllUser(groupId, level);
            }
        }
        if (userList.size() != 0){
            resultData.setData(userList);
            resultData.setMessage("获取" + userList.size() + "条数据");
        }else {
            resultData.setMessage("获取0条数据");
        }
        return resultData;
    }

    @Override
    public ResultData refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
//            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }
}
