package com.study.controller;

import com.study.bean.Result;
import com.study.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password){
        int i = userService.registerUser(username, password);
        if (i != 0){
            return "admin/regS";
        }else{
            return "reg";
        }
    }

    @RequestMapping("/getExistsUesr")
    @ResponseBody
    public Result getExistsUserName(@Param("username") String username){
        int i = userService.getUserByName(username);
        if (i == 0){
            return new Result(200,"用户名可以使用");
        }else{
            return new Result(400,"用户名已存在");
        }
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpServletRequest request){
        int i = userService.getUserLogin(username, password);
        if (i != 0){
            return new Result(200,"登录成功");
        }else{
            return new Result(400,"用户名或密码错误");
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session,
                         HttpServletRequest request){
        session = request.getSession();
        session.removeAttribute("username");

        return "login";
    }
}
