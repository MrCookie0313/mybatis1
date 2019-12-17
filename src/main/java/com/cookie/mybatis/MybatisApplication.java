package com.cookie.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisApplication {

    static {
        System.setProperty("java.version","1.7.0");
    }
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
