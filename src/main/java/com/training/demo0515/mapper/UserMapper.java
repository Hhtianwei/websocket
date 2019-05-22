package com.training.demo0515.mapper;

import com.training.demo0515.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User user);

    User findById(int id);

    List<User> findAll();

}
