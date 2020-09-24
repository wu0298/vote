package com.study.dao;

import com.study.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZIKOR
 * @date 2020/9/22 14:21
 * @desc
 */
@Repository
@Mapper
public interface StudentDao {
    public Student getStudentByNo(@Param("username") String username, @Param("password") String password);

    public List<Student> getStudentList(@Param("rows") int rows, @Param("pages") int pages);

    public List<Student> getStudentListS();

}
