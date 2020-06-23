package com.tcsoft.security.controller;

import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 在 @PreAuthorize 可以利用内建的 SPEL 表达式：比如 'hasRole()' 来决定哪些用户有权访问。
 *  hasRole 表达式认为每个角色名字前都有一个前缀 'ROLE_'。'ADMIN' 在数据库中存储的是 'ROLE_ADMIN' 。
 *  这个 @PreAuthorize 可以修饰Controller也可修饰Controller中的方法。
 **/
@RestController
@RequestMapping("/users")
public class UserController {
    
    @Resource
    private UserMapper userMapper;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return userMapper.queryAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public boolean addUser(@RequestBody User addedUser) {
        return userMapper.insertOne(addedUser);
    }

    @PostAuthorize("returnObject.username == principal.username or hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable String id) {
        return userMapper.queryUserById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        updatedUser.setId(id);
        if (userMapper.queryUserById(id) == null)   return false;
        return userMapper.updateOne(updatedUser);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeUser(@PathVariable String id) {
        User deletedUser = userMapper.queryUserById(id);
        if (deletedUser == null)    return false;
        return userMapper.deleteOne(id);
    }

    @PostAuthorize("returnObject.username == principal.username or hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public User getUserByUsername(@RequestParam(value="username") String username) {
        return userMapper.queryUserByName(username);
    }
}
