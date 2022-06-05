package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

public class XLUtilites {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	static String  path;
	public static CellStyle style;

	public XLUtilites (String path) {
		this.path = path;
	}
	
	public static int getRowCount (String sheetName) throws IOException {
		fis =new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;
	}

	public static int getCellCount(String sheetName ,int rowNum) throws IOException {
		fis= new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellcount;
	}
	
	public static String getCellData(String sheetName, int rowNum, int cellNum) throws IOException {
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(cellNum);
		
		DataFormatter formatter=new DataFormatter();
		String data;
		try {
		data = formatter.formatCellValue(cell);
	   }catch(Exception e) {
		data = " ";
	   }
	workbook.close();
	fis.close();
	return data;
	}
	
	public static void setCellData(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		fos= new FileOutputStream(path);
		workbook=new XSSFWorkbook();
		sheet = workbook.createSheet(sheetName);
		row=sheet.createRow(rowNum);
		cell=row.createCell(cellNum);
		cell.setCellValue(data);
		
		workbook.write(fos);
		fos.close();
	}
	
	public static void fillGreenColor(String sheetName, int rowNum, int cellNum) throws IOException {
		fis= new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet= workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(cellNum);
		
		style= workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		 
		workbook.write(fos);
		workbook.close();
		fos.close();
		fis.close();	
	}
	
	public static void fillRedColor(String sheetName, int rowNum, int cellNum) throws IOException {
		fis= new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet= workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(cellNum);
		
		style= workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		 
		workbook.write(fos);
		workbook.close();
		fos.close();
		fis.close();	
	}
}