package com.training.demo0515.service;

import com.github.pagehelper.PageInfo;
import com.training.demo0515.Demo0515ApplicationTests;
import com.training.demo0515.domain.Student;
import com.training.demo0515.domain.User;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.UUID;

import static org.junit.Assert.*;

public class UserServiceTest extends Demo0515ApplicationTests {

    @Resource
    private UserService userService;

    @Resource StudentService studentService;


    @Test
    public void save() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("t-" + (int)(Math.random()*100));
            user.setNickName("tianWei");
            user.setPassword(UUID.randomUUID().toString());
            user.setAge((int)(Math.random()*100));
            boolean save = userService.save(user);
            System.out.println("save:" + save);
        }
    }

    @Test
    public void testTranscation(){
        for (int i = 0; i < 30; i++) {
            studentService.testTran();
        }
    }

    @Test
    public void page(){
        PageInfo<User> itemByPage = userService.findItemByPage(3, 10);
        itemByPage.getList().stream().forEach(System.out::println);
    }

    @Test
    public void update() {
        userService.testTransaction();
    }

    @Test
    public void findById() {
        User byId = userService.findById(1);
        System.out.println("user:" + byId);
    }

    @Test
    public void findAll() {
    }
}
