package com.tcsoft.security.mapper;

import com.tcsoft.security.dao.UserAuthorityDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author big_john
 */
@Mapper
public interface UserAuthorityMapper {

    /**
     * 查询出权限表中的最高权限
     * @return
     */
    @Select("SELECT MAX(authorityGrade) FROM user_authority;")
    Integer queryMaxGrade();

    /**
     * 根据用户名查询他的权限
     * @param username
     * @return
     */
    @Select("SELECT user_authority.authority, user_authority.authorityDescription, user_authority.authorityGrade " +
            "FROM `user`, user_authority " +
            "WHERE `user`.username = #{username} " +
            "and `user`.authorityId = user_authority.authorityId")
    UserAuthorityDao queryAuthorityByName(@Param("username")String username);

    /**
     * 根据用户名查询出所有比他低的权限
     * @param username
     * @return
     */
    @Select("SELECT authorityId, authorityGrade, authorityDescription, authority " +
            "FROM user_authority " +
            "where authorityGrade < (SELECT user_authority.authorityGrade " +
            "FROM `user`, user_authority " +
            "WHERE `user`.username = #{username} " +
            "and `user`.authorityId = user_authority.authorityId);")
    List<UserAuthorityDao> queryOwnAuthority(@Param("username")String username);

    /**
     * 根据权限描述查询权限id
     * @param authorityDescription
     * @return
     */
    @Select("select * from user_authority where authorityDescription = #{authorityDescription}")
    UserAuthorityDao queryAuthonrityId(@Param("authorityDescription")String authorityDescription);
}
