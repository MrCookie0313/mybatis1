package com.cookie.mybatis.mapper;

import com.alibaba.fastjson.JSON;
import com.cookie.mybatis.MybatisApplication;
import com.cookie.mybatis.model.Employee;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Sunbing
 * @date 2019/12/3 16:29
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MybatisApplication.class})
class EmployeeMapperTest {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    void queryUserListLikeName() {
        List<Employee> employees = this.employeeMapper.queryUserListLikeName("");
        System.out.println("employees = " + employees);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    @Test
    public void Test1() {
        Page<Employee> page = PageHelper.startPage(1, 4);
        List<Employee> employees = employeeMapper.queryUserListLikeName("");
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);
        List<Employee> list = pageInfo.getList();
        System.out.println(JSON.toJSONString(list));
        System.out.println(JSON.toJSONString(pageInfo));
    }

    @Test
    public void Test2() {
        List<String> list = new ArrayList<>();
        list.add("李四");
        list.add("赵六");
        list.add("zhaoli");
        System.out.println(JSON.toJSONString(list));
        int sum = 249/50;
        System.out.println("sum = " + sum);
        ZonedDateTime now = ZonedDateTime.now();
        LocalDateTime localDateTime = now.toLocalDateTime();
        System.out.println("now = " + now);
        Object[] array = list.toArray();
        int j=0;
        for (int i = 0; i < array.length; i++) {
            String str = (String) array[i];
//            j++;
            System.out.println("j=="+j++);
            System.out.println(str);
        }

    }

    @Test
    public void Test3() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("adbc");
        arrayList.add("123");
        arrayList.add("123L");


        String s1="上海";
        if (s1.contains("杭州")){
            System.out.println("yes");
        }

        for (int i1 = 0; i1 < 10; i1++) {
            Random r = new Random();
            int i = 10+r.nextInt(10);
            System.out.println(i);
        }
        int j=2;
        if(j==3){
            System.out.println("j = " + j);
        }
        if (j==2){
            System.out.println("j = " + j);
        }else {
            System.out.println("jjjjjjj");
        }

    }
}