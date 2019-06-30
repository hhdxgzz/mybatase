package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select * from s_user where username = #{username} and password = #{password}")
    User findUser(User user);

    @Select("select * from s_user")
    List<User> findAll();
}
