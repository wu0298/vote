package com.study.controller;

import com.study.bean.Result;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ZIKOR
 * @date 2020/9/24 9:45
 * @desc
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    @ResponseBody
    public Result register(@RequestParam("username") String username,
                           @RequestParam("password") String password){
        int i = userService.registerUser(username, password);
        if (i != 0){
            return new Result(200,"注册成功");
        }else{
            return new Result(400,"注册失败");
        }
    }
}
