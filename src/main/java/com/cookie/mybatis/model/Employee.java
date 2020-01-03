package com.cookie.mybatis.model;

import jdk.internal.org.objectweb.asm.ClassReader;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Sunbing
 * @date 2019/12/3 16:23
 * @Version 1.0
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 3534838705214184947L;
//    private ClassLoader classLoader;
//    private ClassReader classReader;
    private Integer id;
    private String username;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(username, employee.username) &&
                Objects.equals(password, employee.password) &&
                Objects.equals(entryTime, employee.entryTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, entryTime);
    }

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
