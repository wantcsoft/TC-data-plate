package com.tcsoft.security.mapper;

import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.QueryUserBean;
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
    @Insert("INSERT INTO `user` " +
            "( `groupId`, `roleId`, `username`, `password`, `lastPasswordResetDate`, `accountNonLocked`, `enabled`)" +
            "VALUES" +
            "(#{groupId}, #{roleId}, #{username}, #{password}, #{lastPasswordResetDate}, #{accountNonLocked}, #{enabled});")
    boolean insertOne(UserDao userDao);

    /**
     * 根据用户名删除指定用户
     * @param username
     * @return
     */
    @Delete("DELETE FROM `user` WHERE `username` = #{username};")
    boolean deleteOneByUserName(@Param("username")String username);

    /**
     * 根据用户和Id删除指定用户
     * @param userId
     * @return
     */
    @Delete("DELETE FROM `user` WHERE `userId` = #{userId};")
    boolean deleteOneByUserId(@Param("userId")Integer userId);

    /**
     * 跟新用户数据,不更新密码
     * @param userDao
     * @return
     */
    @Update("UPDATE `user` " +
            "SET `groupId` = #{groupId}, `roleId` = #{roleId}, `username` = #{username}, " +
            "`accountNonLocked` = #{accountNonLocked}, `enabled` = #{enabled} " +
            "WHERE userId = #{userId};")
    boolean updateOneNoPassword(UserDao userDao);

    /**
     * 跟新用户数据,不更新密码
     * @param userDao
     * @return
     */
    @Update("UPDATE `user` " +
            "SET `groupId` = #{groupId}, `roleId` = #{roleId}, `username` = #{username}, " +
            "password = #{password}, `accountNonLocked` = #{accountNonLocked}, `enabled` = #{enabled} " +
            "WHERE userId = #{userId};")
    boolean updateOneWithPassword(UserDao userDao);

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
     * @param userId
     * @return
     */
    @Select("select * from user where `userId` = #{userId};")
    UserDao queryUserById(@Param("userId")Integer userId);

    /**
     * 医院的用户查看本医院的用户
     * @param groupId
     * @param roleGrade
     * @return
     */
    @Select("SELECT `user`.userId, user_group.groupDescription, user_role.roleDescription, " +
            "`user`.username, user.lastPasswordResetDate, `user`.accountNonLocked, `user`.enabled " +
            "FROM `user`, user_group, user_role " +
            "where user.`groupId` = user_group.groupId " +
            "and `user`.roleId = user_role.roleId " +
            "and user.groupId = #{groupId} ;")
    List<QueryUserBean> hospitalQueryAllUser(@Param("groupId")Integer groupId, @Param("roleGrade")Integer roleGrade);

    /**
     * 系统用户查看所有等级低于自己的用户
     * @param roleGrade
     * @return
     */
    @Select("SELECT `user`.userId, user_group.groupDescription, user_role.roleDescription, " +
            "`user`.username, user.lastPasswordResetDate, `user`.accountNonLocked, `user`.enabled " +
            "FROM `user`, user_group, user_role " +
            "WHERE `user`.groupId = user_group.groupId " +
            "and `user`.roleId = user_role.roleId " +
            "AND user_role.roleGrade < #{roleGrade};")
    List<QueryUserBean> systemQueryAllUser(@Param("roleGrade")Integer roleGrade);

    /**
     * 系统管理员查看所有的用户信息，包括自己
     * @return
     */
    @Select("SELECT `user`.userId, user_group.groupDescription, user_role.roleDescription, " +
            "`user`.username, user.lastPasswordResetDate, `user`.accountNonLocked, `user`.enabled " +
            "FROM `user`, user_group, user_role " +
            "WHERE `user`.groupId = user_group.groupId " +
            "and `user`.roleId = user_role.roleId;")
    List<QueryUserBean> systemAdminQueryAllUser();

    /**
     * 根据用户名查询出他的角色信息
     * @param username
     * @return
     */
    @Select("SELECT user_role.roleId, user_role.role, user_role.roleDescription, user_role.roleGrade" +
            "FROM `user`, user_role " +
            "WHERE `user`.username = #{username} " +
            "and `user`.roleId = user_role.roleId;")
    UserRoleDao queryUserRoleByName(@Param("username")String username);

    /**
     * 根据用户号Id查询出他的角色信息
     * @param userId
     * @return
     */
    @Select("SELECT user_role.roleId, user_role.role, user_role.roleDescription, user_role.roleGrade" +
            "FROM `user`, user_role " +
            "WHERE `user`.userId = #{userId} " +
            "and `user`.roleId = user_role.roleId;")
    UserRoleDao queryUserRoleById(@Param("userId")Integer userId);

}
