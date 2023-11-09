package com.bellatrix.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.base.CaseFormat;

import org.apache.poi.ss.usermodel.Cell;


/**
 * This code is read the file
 * @author DELL
 *
 */
public class FileUtil {
	
	public String getProperty(String filePath,String key) {
		String baseDir	=System.getProperty("user.dir");
		//Read properties file
		FileInputStream file=null;
		try {
			file = new FileInputStream(baseDir+filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Locator- is fileName. and properties is extension
		Properties prop = new Properties();
		String value = "";
		try {
			prop.load(file);
	 value =	prop.getProperty(key);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
		
		
		
	}
	
	
	public String getLocator(String locatorName) throws FileNotFoundException {
	String baseDir	=System.getProperty("user.dir");
		//Read properties file
		FileInputStream file = new FileInputStream(baseDir+"/src/main/resources/Locator.properties");
		//Locator- is fileName. and properties is extension
		Properties prop = new Properties();
		String value = "";
		try {
			prop.load(file);
	 value =	prop.getProperty(locatorName);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
		
	}
public String[]	getRowFromExcel(String filepath,String sheetName,int rowNum) throws IOException{
	String[] data ;
	Workbook book =null;
	
	try {
	 book = new XSSFWorkbook(filepath);
	}catch (Exception e) {
		e.printStackTrace();
	}
	 Sheet sheet = (Sheet) book.getSheet(sheetName);
    Row row =  sheet.getRow(rowNum);
    data = new String[row.getLastCellNum()];
    for(int i = 0;i<row.getLastCellNum();i++) {
    	Cell cell =  row.getCell(i);
    	switch(cell.getCellTypeEnum()) {
    	case STRING:
    	data[i] = cell.getStringCellValue();
    	break;
    	case NUMERIC:
    		data[i] = String.valueOf(cell.getNumericCellValue());
    		break;
    		
    	
    }
    	    
		
	}
	return data;
    
   
}
public String getConfiguration(String key) {
	return getProperty("/src/main/resources/config.properties", key);
}



}

