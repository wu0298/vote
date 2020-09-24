package com.study.service;

import com.study.bean.Student;
import com.study.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZIKOR
 * @date 2020/9/22 14:38
 * @desc
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getStudentByNo(String username, String password) {
        Student student = studentDao.getStudentByNo(username,password);
        return student;
    }

    @Override
    public List<Student> getStudentList(int rows,int pages) {
        pages = (pages-1) * rows;
        return studentDao.getStudentList(rows,pages);
    }

    @Override
    public List<Student> getStudentListS() {
        return studentDao.getStudentListS();
    }
}
