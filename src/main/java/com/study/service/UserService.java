package com.study.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author ZIKOR
 * @date 2020/9/24 9:46
 * @desc
 */
public interface UserService {
    public int registerUser(String username, String password);

    public int getUserByName(String username);

    public int getUserLogin(String username, String password);

    public int updateUser(String username, String password);
}
