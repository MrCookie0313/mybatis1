package com.cookie.mybatis.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.io.Serializable;

/**
 * @author Sunbing
 * @date 2019/12/20 9:57
 * @Version 1.0
 */

public class TableHeader extends BaseRowModel implements Serializable {
    private static final long serialVersionUID = 1248912000701382172L;
    @ExcelProperty(value = "姓名",index = 0)
    private String name;
    @ExcelProperty(value = "工号2",index = 1)
    private String workNum;
    @ExcelProperty(value = "地址",index = 2)
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
