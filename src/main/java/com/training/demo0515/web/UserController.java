package com.training.demo0515.web;

import com.training.demo0515.data.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping
    public Result index(String email){
        System.out.println("email:" + email);
        return new Result(true,"hahhaa");
    }

}
