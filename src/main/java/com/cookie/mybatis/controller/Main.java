package com.cookie.mybatis.controller;

import com.cookie.mybatis.model.Student;
import com.cookie.mybatis.service.TestServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        for (int i = 0; i < 1010; i++) {
            Student stu = new Student();
            stu.setId(Long.valueOf(i));
            stu.setName("张三" + i);
            list.add(stu);
        }


        TestServiceImpl s = new TestServiceImpl();
        s.addList(list);
        System.out.println("==执行了完成==");
    }
}