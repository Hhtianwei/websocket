package com.training.demo0515.service;

import com.training.demo0515.Demo0515ApplicationTests;
import com.training.demo0515.domain.Student;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class StudentServiceTest extends Demo0515ApplicationTests {

    @Resource
    private StudentService studentService;

    @Test
    public void test1(){
        System.out.println("hello world");
    }

    @Test
    public void testFindAll(){
        List<Student> all = studentService.findAll();
        System.out.println("all:" + all);
    }
}
