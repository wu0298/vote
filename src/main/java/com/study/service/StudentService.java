package com.study.service;

import com.study.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZIKOR
 * @date 2020/9/22 14:37
 * @desc
 */
public interface StudentService {
    public Student getStudentByNo(@Param("username") String username, @Param("password") String password);

    public List<Student> getStudentList(int rows, int pages);

    public List<Student> getStudentListS();
}
