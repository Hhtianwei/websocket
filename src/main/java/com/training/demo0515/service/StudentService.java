package com.training.demo0515.service;

import com.training.demo0515.domain.Student;
import com.training.demo0515.repository.StudentRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {

    @Resource
    private StudentRepository studentRepository;

    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    //这个名称一定要加入
    @Cacheable(cacheNames = "stuAll")
    public List<Student> findAll(){
        return studentRepository.findAll();
    }


}
