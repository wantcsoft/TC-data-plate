package com.tcsoft.security.mapper;

import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.entity.FrontUser;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * 数据库的mapper实现类
 * @author big_john
 */
@Mapper
public interface UserMapper {

    /**
     * 用户注册
     * @param userDao
     * @return
     */
    @Insert("INSERT INTO `userDao` " +
            "( `groupId`, `authorityId`, `username`, `password`, `lastPasswordResetDate`, `accountNonLocked`, `enabled`)" +
            "VALUES" +
            "(#{groupId}, #{authorityId}, #{username}, #{password}, #{lastPasswordResetDate}, #{accountNonLocked}, #{enabled});")
    boolean insertOne(UserDao userDao);

    /**
     * 删除指定用户
     * @param id
     * @return
     */
    @Delete("DELETE FROM `user` WHERE `id` = #{id};")
    boolean deleteOne(@Param("id")Integer id);

    /**
     * 跟新用户数据,不更新密码
     * @param userDao
     * @return
     */
    @Update("UPDATE `user` " +
            "SET `groupId` = #{groupId}, `authorityId` = #{authorityId}, `username` = #{username}, " +
            "`accountNonLocked` = #{accountNonLocked}, `enabled` = #{enabled} " +
            "WHERE userId = #{userId};")
    boolean updateOne(UserDao userDao);

    /**
     * 通过用户名查找用户信息
     * @param username
     * @return
     */
    @Select("select * from user where `username` = #{username};")
    UserDao queryUserByName(@Param("username")String username);

    /**
     * 当用户修改用户名时检查是和否有重名
     * @param userId
     * @param username
     * @return
     */
    @Select("select * from user where `userId` != #{userId} and `username` = #{username};")
    UserDao querySameUserName(@Param("userId")Integer userId, @Param("username")String username);

    /**
     * 通过用户ID查找用户信息
     * @param id
     * @return
     */
    @Select("select * from user where `id` = #{id};")
    UserDao queryUserById(@Param("id")Integer id);

    /**
     * 医院的用户查看本医院自己所管理的用户
     * @param groupId
     * @param authorityGrade
     * @return
     */
    @Select("SELECT user.userId, user_group.description as groupId, " +
            "user.username, user.roles, user.accountNonLocked, user.enabled " +
            "from `user`, user_group " +
            "where user.`groupId` = user_group.groupId " +
            "and user.groupId = #{groupId} " +
            "and user.roleLevel > #{roleLevel};")
    List<FrontUser> hospitalQueryAllUser(@Param("groupId")Integer groupId, @Param("authorityGrade")Integer authorityGrade);

    /**
     * 系统用户查看所有等级低于自己的用户
     * @param authorityGrade
     * @return
     */
    @Select("SELECT `user`.userId, user_group.groupDescription, user_authority.authorityDescription, " +
            "`user`.username, `user`.accountNonLocked, `user`.enabled " +
            "FROM `user`, user_group, user_authority " +
            "WHERE `user`.groupId = user_group.groupId " +
            "and `user`.authorityId = user_authority.authorityId " +
            "AND user_authority.authorityGrade < #{authorityGrade};")
    List<FrontUser> systemQueryAllUser(@Param("authorityGrade")Integer authorityGrade);

    /**
     * 系统管理员查看所有的用户信息，包括自己
     * @return
     */
    @Select("SELECT `user`.userId, user_group.groupDescription, user_authority.authorityDescription, " +
            "`user`.username, `user`.accountNonLocked, `user`.enabled " +
            "FROM `user`, user_group, user_authority " +
            "WHERE `user`.groupId = user_group.groupId " +
            "and `user`.authorityId = user_authority.authorityId;")
    List<FrontUser> systemAdminQueryAllUser();

    /**
     * 根据用户名查询出他的用户权限
     * @param username
     * @return
     */
    @Select("SELECT user_authority.authorityGrade " +
            "FROM `user`, user_authority " +
            "WHERE `user`.username = #{username} " +
            "and `user`.authorityId = user_authority.authorityId")
    Integer queryUserAuthorityGrade(@Param("username")String username);

}
