package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Mr_Zhao
 * @Description:
 * @Date: Create in  2019/6/17 10:20
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User findUser(User user) {
        User user1 = userDao.findUser(user);
        return user1;
    }

    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }
}
