package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

public interface UserService {


    User findUser(User user);

    List<User> findAll();
}
