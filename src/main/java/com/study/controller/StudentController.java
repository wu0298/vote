package com.study.controller;

import com.alibaba.fastjson.JSON;
import com.study.bean.BootstrapData;
import com.study.bean.Result;
import com.study.bean.Student;
import com.study.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZIKOR
 * @date 2020/9/23 15:49
 * @desc
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/studentList")
    public Result getStudentList(@RequestParam("rows") int rows,
                                 @RequestParam("pages") int pages){
        List<Student> list = studentService.getStudentList(rows,pages);
        BootstrapData bd = new BootstrapData(list.size(),list);
        String json = JSON.toJSONString(bd);
        if (list!=null){
            return new Result(200,"查询成功",json);
        }else{
            return new Result(200,"查询失败");
        }
    }

    @RequestMapping("/getStudentList")
    public Result getStudentListS(){
        List<Student> list = studentService.getStudentListS();
        BootstrapData bd = new BootstrapData(list.size(),list);
        String json = JSON.toJSONString(bd);
        if (list!=null){
            return new Result(200,"查询成功",json);
        }else{
            return new Result(200,"查询失败");
        }
    }
}
