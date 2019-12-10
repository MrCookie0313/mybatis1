package com.cookie.mybatis.model;

import java.time.LocalDate;

/**
 * @author Sunbing
 * @date 2019/12/3 16:23
 * @Version 1.0
 */
public class Employee {
    private Integer id;
    private String username;
    private String password;

    private LocalDate entryTime= LocalDate.now();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
