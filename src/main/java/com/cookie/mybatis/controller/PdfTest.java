package com.cookie.mybatis.controller;

import com.cookie.mybatis.model.Employee;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Table;

import java.awt.*;

/**
 * @author Sunbing
 * @date 2019/12/24 14:19
 * @Version 1.0
 */
public class PdfTest {
    public static void main(String[] args) throws BadElementException {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setUsername("cookie");
        employee.setPassword("dwqqw2223");
        employee=new Employee();
        employee.setId(2);

    }
}
