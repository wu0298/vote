package com.study.service;

import com.study.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ZIKOR
 * @date 2020/9/24 9:55
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpServletRequest request;

    @Override
    public int registerUser(String username, String password) {
        return userDao.registerUser(username, password);
    }

    @Override
    public int getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public int getUserLogin(String username, String password) {
        HttpSession session = request.getSession();
        int i = userDao.getUserLogin(username,password);
        if (i!=0){
            session.setAttribute("username",username);
        }

        return i;
    }
}
