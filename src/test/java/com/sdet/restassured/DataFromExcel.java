package com.sdet.restassured;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;

public class DataFromExcel {
	
	public static String readDataFromExcel(String excelfilePath,String sheetName,int rowNum,int cellNum) throws FileNotFoundException, IOException {
		
		String cellValue=null;
		try(FileInputStream file=new FileInputStream(new File(excelfilePath))){
			Workbook workbook=WorkbookFactory.create(file);
			Sheet sheet=workbook.getSheet(sheetName);
			Row row=sheet.getRow(rowNum);
			Cell cell=row.getCell(cellNum);
			cellValue=cell.toString();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return cellValue;
		
	}

}
