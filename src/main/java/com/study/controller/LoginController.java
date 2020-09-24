package com.study.controller;

import com.study.bean.Result;
import com.study.bean.Student;
import com.study.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZIKOR
 * @date 2020/9/22 14:14
 * @desc
 */
@RestController
public class LoginController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/logins")
    //@CrossOrigin
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password){
        Student stu = new Student();
        stu.setPassword(password);
        stu.setUsername(username);
        Student student = studentService.getStudentByNo(username, password);
        if (student != null){
            return new Result(200,"登录成功",student);
        }else{
            return new Result(400,"登录失败");
        }
    }
}
