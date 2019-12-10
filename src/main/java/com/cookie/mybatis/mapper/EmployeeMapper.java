package com.cookie.mybatis.mapper;

import com.cookie.mybatis.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Sunbing
 * @date 2019/12/3 16:22
 * @Version 1.0
 */
@Mapper
public interface EmployeeMapper {
    List<Employee> queryUserListLikeName(@Param("username") String username);
}
