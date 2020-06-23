package com.tcsoft.service01.Mapper;


import com.tcsoft.service01.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name};")
    public User queryUserByName(String name);
}
