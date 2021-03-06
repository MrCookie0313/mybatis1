package com.cookie.mybatis.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author Sunbing
 * @date 2019/12/20 9:57
 * @Version 1.0
 */

public class TableHeader extends BaseRowModel {
    @ExcelProperty(value = "姓名",index = 0)
    private String name;
    @ExcelProperty(value = "工号",index = 1)
    private String worknum;
    @ExcelProperty(value = "地址",index = 2)
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorknum() {
        return worknum;
    }

    public void setWorknum(String worknum) {
        this.worknum = worknum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
