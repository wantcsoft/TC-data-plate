package com.tcsoft.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.entity.UserServiceBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 数据库的mapper实现类，数据库操作模型
 * @author big_john
 */
public interface UserMapper extends BaseMapper<UserDao> {

    /**
     * 查询出所有的医院用户
     * @return
     */
    @Select("select User.UserID as userId, User.GroupID as groupId, User.RoleID as roleId,\n" +
            "       User.UserName as userName,\n" +
            "       User.LastPasswordResetDate as lastPasswordResetDate, User.IsEnabled as enable,\n" +
            "       UserGroup.GroupDescription as groupDescription,\n" +
            "       User.AccountNonLocked as accountNonLocked,\n" +
            "       UserRole.RoleDescription as roleDescription, UserRole.Role as role\n" +
            "from User, UserRole, UserGroup\n" +
            "where User.GroupID = UserGroup.GroupID\n" +
            "and  User.RoleID = UserRole.RoleID\n" +
            "and UserGroup.`Group` != 'system';")
    List<UserServiceBean> selectUserAllGroupId();

    /**
     * 根据组的ID查询出该组所有的用户
     * @param group
     * @return
     */
    @Select("select User.UserID as userId, User.GroupID as groupId, User.RoleID as roleId,\n" +
            "       User.UserName as userName,\n" +
            "       User.LastPasswordResetDate as lastPasswordResetDate, User.IsEnabled as enabled,\n" +
            "       UserGroup.GroupDescription as groupDescription, UserGroup.Group as `group`,\n" +
            "       User.AccountNonLocked as accountNonLocked,\n" +
            "       UserRole.RoleDescription as roleDescription, UserRole.Role as role\n" +
            "from User, UserRole, UserGroup\n" +
            "where User.GroupID = UserGroup.GroupID\n" +
            "and User.RoleID = UserRole.RoleID\n" +
            "and UserGroup.Group = #{group};")
    List<UserServiceBean> selectUserByGroup(@Param("group")String group);

    /**
     * 查询和自己同意医院的用户（不包括自己）
     * @param group
     * @param userId
     * @return
     */
    @Select("select User.UserID as userId, User.GroupID as groupId, User.RoleID as roleId,\n" +
            "       User.UserName as userName,\n" +
            "       User.LastPasswordResetDate as lastPasswordResetDate, User.IsEnabled as enabled,\n" +
            "       UserGroup.GroupDescription as groupDescription, UserGroup.Group as `group`,\n" +
            "       User.AccountNonLocked as accountNonLocked,\n" +
            "       UserRole.RoleDescription as roleDescription, UserRole.Role as role\n" +
            "from User, UserRole, UserGroup\n" +
            "where User.GroupID = UserGroup.GroupID\n" +
            "and User.RoleID = UserRole.RoleID\n" +
            "and User.UserID != #{userId}\n" +
            "and UserGroup.Group = #{group};")
    List<UserServiceBean> selectSameGroup(@Param("group")String group, @Param("userId")Integer userId);

    /**
     * 查询出所有的用户除了系统管理员
     * @return
     */
    @Select("select User.UserID as userId, User.GroupID as groupId, User.RoleID as roleId,\n" +
            "       User.UserName as userName,\n" +
            "       User.LastPasswordResetDate as lastPasswordResetDate, User.IsEnabled as enabled,\n" +
            "       UserGroup.GroupDescription as groupDescription, UserGroup.Group as `group`,\n" +
            "       User.AccountNonLocked as accountNonLocked,\n" +
            "       UserRole.RoleDescription as roleDescription, UserRole.Role as role\n" +
            "from User, UserRole, UserGroup\n" +
            "where User.GroupID = UserGroup.GroupID\n" +
            "and  User.RoleID = UserRole.RoleID\n" +
            "and UserRole.Role != 'ROLE_system_admin';")
    List<UserServiceBean> selectAllUsers();

    /**
     * 根据userId查询系统用户
     * @param userId
     * @return
     */
    @Select("select User.UserID as userId, User.GroupID as groupId, User.RoleID as roleId,\n" +
            "       User.UserName as userName,\n" +
            "       User.LastPasswordResetDate as lastPasswordResetDate, User.IsEnabled as enabled,\n" +
            "       UserGroup.GroupDescription as groupDescription, UserGroup.Group as `group`,\n" +
            "       User.AccountNonLocked as accountNonLocked,\n" +
            "       UserRole.RoleDescription as roleDescription, UserRole.Role as role\n" +
            "from User, UserRole, UserGroup\n" +
            "where User.GroupID = UserGroup.GroupID\n" +
            "and  User.RoleID = UserRole.RoleID\n" +
            "and User.UserID = #{userId}")
    List<UserServiceBean> selectUserById(@Param("userId")Integer userId);

}
