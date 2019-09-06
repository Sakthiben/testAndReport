package com.karya.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DownloadTemplate {
	
	public Workbook ProcessExcelFormat(List<String> tableColumnList) throws SQLException, FileNotFoundException,IOException {
		 /* Create Blank WorkBook */
		 XSSFWorkbook workbook = new XSSFWorkbook(); 
		 
		 /* Create Blank Sheet in WorkBook */
		 XSSFSheet sheet = workbook.createSheet("Color Test");
		 
		 /* Create new Row in a Sheet */
		 XSSFRow row = sheet.createRow(0);
		 
		 /* Set Font Style */
	     Font font = workbook.createFont();
	     font.setFontHeightInPoints((short) 10);
	     font.setFontName("TIMES NEW ROMAN");
	     font.setBoldweight(Font.BOLDWEIGHT_BOLD);
	     font.setColor(HSSFColor.BLACK.index);
	     
	     CellStyle style = workbook.createCellStyle();
		 style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		 style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		 style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		 style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		 style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		 style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		 style.setFont(font);
		 
	 	 for (int i=0;i<tableColumnList.size();i++) {
	 	   Cell c = row.createCell(i);
	       c.setCellValue(tableColumnList.get(i));
	       c.setCellStyle(style);
	       sheet.autoSizeColumn(i);
	 	 }
	 	return workbook;
	}
	
	public void ProcessEntityMapping(String tableName,Workbook workbook) throws SQLException, FileNotFoundException,IOException {
		if(tableName.equals("employee001mb")) {
			
		}
	}
}
