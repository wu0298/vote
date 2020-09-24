package com.study.service;

import com.study.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZIKOR
 * @date 2020/9/24 9:55
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public int registerUser(String username, String password) {
        return userDao.registerUser(username, password);
    }
}
