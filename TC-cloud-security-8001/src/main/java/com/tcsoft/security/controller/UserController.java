package com.tcsoft.security.controller;

import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.mapper.UserMapper;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 在 @PreAuthorize 可以利用内建的 SPEL 表达式：比如 'hasRole()' 来决定哪些用户有权访问。
 *  hasRole 表达式认为每个角色名字前都有一个前缀 'ROLE_'。'ADMIN' 在数据库中存储的是 'ROLE_ADMIN' 。
 *  这个 @PreAuthorize 可以修饰Controller也可修饰Controller中的方法。
 *
 * @author big_john*/
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserMapper userMapper;

//    @PreAuthorize("hasRole('ADMIN')")
//    @RequestMapping(method = RequestMethod.GET)
//    public List<UserDao> getUsers() {
//        return userMapper.queryAllUser();
//    }

    /**
     * 新增用户，只有管理员有操作权限
     * @param addedUser
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public boolean addUser(@RequestBody UserDao addedUser) {
        return false;
//        return userMapper.insertOne(addedUser);
    }

    @PostAuthorize("returnObject.username == principal.username or hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDao getUser(@PathVariable Integer id) {
        return userMapper.queryUserById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean updateUser(@PathVariable Integer id, @RequestBody UserDao updatedUser) {
        updatedUser.setUserId(id);
        if (userMapper.queryUserById(id) == null) {
            return false;
        }
        return userMapper.updateOne(updatedUser);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeUser(@PathVariable Integer id) {
        UserDao deletedUser = userMapper.queryUserById(id);
        if (deletedUser == null) {
            return false;
        }
        return userMapper.deleteOne(id);
    }

    @PostAuthorize("returnObject.username == principal.username or hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public UserDao getUserByUsername(@RequestParam(value="username") String username) {
        return userMapper.queryUserByName(username);
    }
}
