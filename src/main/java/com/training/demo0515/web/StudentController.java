package com.training.demo0515.web;

import com.training.demo0515.domain.Student;
import com.training.demo0515.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> findAll(){
        List<Student> all = studentService.findAll();
        return all;
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id){
        Student one = studentService.findById(id);
        return one;
    }
}
