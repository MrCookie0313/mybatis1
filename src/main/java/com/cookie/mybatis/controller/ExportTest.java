package com.cookie.mybatis.controller;

import com.cookie.mybatis.model.ClsModal;
import com.cookie.mybatis.service.ExportExcel;

import java.util.ArrayList;
import java.util.List;

public class ExportTest {
	public static void main(String[] args) {
		//准备数据
		List<ClsModal> clsList=new ArrayList<ClsModal>();
		for(int i=0;i<3;i++) {
			ClsModal cls=new ClsModal();
			cls.setCid(i);
			cls.setCname("javawdjudwdudksadksasdsadsadk"+i);
			cls.setLocation("上海"+i);
			clsList.add(cls);
		}
		
		new ExportExcel().export(clsList);
	}
}

