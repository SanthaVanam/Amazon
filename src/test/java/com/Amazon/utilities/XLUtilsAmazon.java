package com.Amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilsAmazon  {

	
	static FileInputStream fis;
static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static int getRowCount(String path,String sheetno) throws Exception 
	{
		File file = new File(path);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetno);
		int getrow = sheet.getLastRowNum();
		return getrow;

	}
	public static int getColCount(String path,String sheetno,int row) throws Exception {
		File file = new File(path);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Sheet1");
		int getcol = sheet.getRow(row).getLastCellNum();		
		return getcol;

	}

	public static String getCellData(String path,String sheetno,int row,int col) throws Exception {
		File file = new File(path);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetno);
		DataFormatter df = new DataFormatter();
		String getdata = df.formatCellValue(sheet.getRow(row+1).getCell(col));
		return getdata;
	}
	

	

}
