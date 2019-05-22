package com.training.demo0515.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.training.demo0515.domain.Student;
import com.training.demo0515.repository.StudentRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
public class StudentService {

    @Resource
    private StudentRepository studentRepository;

    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void save(Student student){
        studentRepository.save(student);
    }

    @Transactional
    public void testTran(){
        Student s = new Student();
        s.setName("tw-" + (int)(Math.random()*100));
        s.setAddress("address"+(int)(Math.random()*100));
        this.save(s);

        //System.out.println("stu:" + (1/0));

        Student s2 = new Student();
        s2.setName("tw-" + (int)(Math.random()*100));
        s2.setAddress("address" + (int)(Math.random()*100));
        this.save(s2);
    }

    public PageInfo<Student> findItemByPage(int currentPage,int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<Student> allItems = studentRepository.findAll();
        PageInfo<Student> pageData = new PageInfo<>(allItems);
        return pageData;
    }


    //这个名称一定要加入
    @Cacheable(cacheNames = "stuAll")
    public List<Student> findAll(){
        return studentRepository.findAll();
    }


}
