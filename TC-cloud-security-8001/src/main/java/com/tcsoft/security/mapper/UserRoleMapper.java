package com.tcsoft.security.mapper;

import com.tcsoft.security.dao.UserRoleDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author big_john
 */
@Mapper
public interface UserRoleMapper {

    /**
     * 查询出权限表中的最高权限
     * @return
     */
    @Select("SELECT MAX(roleGrade) FROM user_role;")
    Integer queryMaxGrade();

    /**
     * 根据用户名查询他的权限
     * @param username
     * @return
     */
    @Select("SELECT user_role.roleId, user_role.role, user_role.roleDescription, user_role.roleGrade " +
            "FROM `user`, user_role " +
            "WHERE `user`.username = #{username} " +
            "and `user`.roleId = user_role.roleId")
    UserRoleDao queryRoleByUserName(@Param("username")String username);

    /**
     * 根据roleId查询角色信息
     * @param roleId
     * @return
     */
    @Select("select * from user_role where roleId = #{roleId}")
    UserRoleDao queryRoleById(@Param("roleId")Integer roleId);

    /**
     * 根据用户名查询出所有比他低的权限
     * @param username
     * @return
     */
    @Select("SELECT roleId, roleGrade, roleDescription, role " +
            "FROM user_role " +
            "where roleGrade < (SELECT user_role.roleGrade " +
            "FROM `user`, user_role " +
            "WHERE `user`.username = #{username} " +
            "and `user`.roleId = user_role.roleId);")
    List<UserRoleDao> queryOwnRole(@Param("username")String username);

    /**
     * 根据权限描述查询权限id
     * @param roleDescription
     * @return
     */
    @Select("select * from user_role where roleDescription = #{roleDescription}")
    UserRoleDao queryRoleId(@Param("roleDescription")String roleDescription);
}
