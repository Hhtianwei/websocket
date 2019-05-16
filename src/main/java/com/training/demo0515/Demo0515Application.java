package com.training.demo0515;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.training.demo0515.repository")
@SpringBootApplication
@EnableCaching
public class Demo0515Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo0515Application.class, args);
    }

}
