package com.cookie.mybatis.service;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.cookie.mybatis.model.ClsModal;

public class ExportExcel {

	public void export(List<ClsModal> clsList) {
		try(OutputStream out=new FileOutputStream("D:/exportCls.xlsx")) {
			ExcelWriter writer=new ExcelWriter(out,ExcelTypeEnum.XLSX);
			
			if(!clsList.isEmpty()) {
				Sheet sheet=new Sheet(1,0,clsList.get(0).getClass());
				
				sheet.setSheetName("导出班级测试");
				writer.write(clsList, sheet);
			}
			writer.finish();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}