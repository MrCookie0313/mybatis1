package com.cookie.mybatis.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.io.Serializable;

public class ClsModal extends BaseRowModel implements Serializable{

	private static final long serialVersionUID = -1101867141713015589L;
	@ExcelProperty(value = "班级编号", index = 0)
	private Integer cid;

	@ExcelProperty(value = "班级名称", index = 1)
	private String cname;

	@ExcelProperty(value = "地址", index = 2)
	private String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
}