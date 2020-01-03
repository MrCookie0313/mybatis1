package com.cookie.mybatis.repository;

import com.cookie.mybatis.mapper.EmployeeMapper;
import com.cookie.mybatis.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author Sunbing
 * @date 2019/12/27 11:27
 * @Version 1.0
 */
public class ThreadDemo implements Callable<Boolean> {
    @Autowired
    private EmployeeMapper employeeMapper;
    private int pageIndex;
    private List<Employee> list;

    public ThreadDemo(int pageIndex,List<Employee> list){
        this.pageIndex=pageIndex;
        this.list=list;
    }

    @Override
    public Boolean call() throws Exception {

        if (list.size()>0 && list!=null){

        }
        return null;
    }
}
