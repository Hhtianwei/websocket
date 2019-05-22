package com.training.demo0515.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.training.demo0515.domain.Student;
import com.training.demo0515.domain.User;
import com.training.demo0515.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private StudentService studentService;

    @Transactional
    public boolean save(User user){
        int insert = userMapper.insert(user);
        //System.out.println("test..............." + (1/0));
        //int insert2 = userMapper.insert(user);
        return insert > 0;
    }

    public boolean update(){

        return false;
    }

    public User findById(int id){
        User user = userMapper.findById(id);

        return user;
    }

    @Transactional
    public void testTransaction(){

        studentService.testTran();

        User u = new User();
        u.setPassword("aaaaaaaaaaaaaaaaaa");
        u.setNickName("noah....");
        this.save(u);
    }

    public List<User> findAll(){
        List<User> all = userMapper.findAll();
        return all;
    }

    public PageInfo<User> findItemByPage(int currentPage, int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<User> allItems = userMapper.findAll();
        PageInfo<User> pageData = new PageInfo<>(allItems);
        return pageData;
    }

}

