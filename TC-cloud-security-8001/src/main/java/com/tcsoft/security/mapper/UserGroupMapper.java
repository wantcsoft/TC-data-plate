package com.tcsoft.security.mapper;

import com.tcsoft.security.dao.UserGroupDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author big_john
 */
@Mapper
public interface UserGroupMapper {

    /**
     * 获取所有的组的信息
     * @return
     */
    @Select("select * from user_group;")
    List<UserGroupDao> queryAllGroup();

    /**
     * 根据groupId查询用户组的信息
     * @param groupId
     * @return
     */
    @Select("select * from user_group where groupId = #{groupId};")
    List<UserGroupDao> queryGroupById(@Param("groupId") Integer groupId);

    /**
     * 根据组描述，查询组的信息
     * @param groupDescription
     * @return
     */
    @Select("select * from user_group where groupDescription = #{groupDescription};")
    UserGroupDao queryGroupByDescription(@Param("groupDescription")String groupDescription);

    /**
     * 根据userId查询组信息
     * @param userId
     * @return
     */
    @Select("select user_group.groupId, user_group.groupDescription " +
            "from `user`, user_group " +
            "where userId = #{userId} " +
            "and `user`.groupId = user_group.groupId;")
    UserGroupDao queryGroupByUserId(@Param("userId")Integer userId);

    /**
     * 根据userId查询组信息
     * @param userName
     * @return
     */
    @Select("select user_group.groupId, user_group.groupDescription " +
            "from `user`, user_group " +
            "where userName = #{userName} " +
            "and `user`.groupId = user_group.groupId;")
    UserGroupDao queryGroupByUserName(@Param("userName")String userName);
}
