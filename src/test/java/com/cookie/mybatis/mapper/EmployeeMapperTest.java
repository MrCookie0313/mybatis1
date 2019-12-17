package com.cookie.mybatis.mapper;

import com.alibaba.fastjson.JSON;
import com.cookie.mybatis.MybatisApplication;
import com.cookie.mybatis.model.Employee;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

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
        ZonedDateTime now = ZonedDateTime.now();
        LocalDateTime localDateTime = now.toLocalDateTime();
        System.out.println("now = " + now);
        Object[] array = list.toArray();
        for (int i = 0; i < array.length; i++) {
            String str = (String) array[i];
            System.out.println(str);
        }

    }

    @Test
    public void Test3() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("adbc");
        arrayList.add("123");
        arrayList.add("123L");

    }
}