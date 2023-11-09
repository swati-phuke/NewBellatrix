package com.bellatrix.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {
	/**
	 * This method will load specified excel into a 2D {@code object}array
	 * 
	 * @param filePath
	 * @return Object array representation of the specified excelsheet
	 * @throws IOException
//	 */ 
	 
		
		public Object[][] loadExcelTo2DArray(String filePath, String sheetName) throws IOException {
			String dir = System.getProperty("user.dir");// we can get current working directory
			// String filePath = "/D:/DataProviderFile.xlsx/";//File Store in src Java
			// Folder

			FileInputStream file = new FileInputStream(dir+filePath);
			Workbook book;
			Object[][] data = null;
			String[] parts = filePath.split(".");
			if (parts[1].equalsIgnoreCase("xls")) {
				book = new HSSFWorkbook(file);
				HSSFSheet sheet = (HSSFSheet) book.getSheet(sheetName);
				data = new String[sheet.getLastRowNum()][1]; // getLastRowNum return last row on the sheet

				for (int i = 0; i <= sheet.getLastRowNum(); i++) {
					HSSFRow row = sheet.getRow(i);
					int lastCell = row.getLastCellNum();// get the index of the last cell
					for (int j = 0; j < lastCell; j++) {
						HSSFCell cell = row.getCell(j);
						switch (cell.getCellTypeEnum()) {
						case STRING:
							data[i][j] = cell.getStringCellValue();
						case NUMERIC:
							data[i][j] = cell.getNumericCellValue();
							break;
						default:
							System.out.println("invalid data");
							break;
						}
					}
				}
			} else if (parts[1].equalsIgnoreCase("xlsx")) {
				book = new XSSFWorkbook("file");
				XSSFSheet sheet = (XSSFSheet) book.getSheet(sheetName);
				data = new String[sheet.getLastRowNum()][1];

				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					XSSFRow row = sheet.getRow(i);
					int lastCell = row.getLastCellNum();// get the index of the last cell
					for (int j = 0; j < lastCell; j++) {
						XSSFCell cell = row.getCell(j);
						switch (cell.getCellTypeEnum()) {
						case STRING:
							data[i][j] = cell.getStringCellValue();
						case NUMERIC:
							data[i][j] = cell.getNumericCellValue();
							break;

						default:
							System.out.println("invalid data");
							break;
						}

					}

				}

			}

			return data;

		}
		/**
		 * If we can skip any row or colomn use this method 
		 * @param fileName
		 * @param sheetName
		 * @param colNumskip
		 * @param rowNumskip
		 * @param  
		 * @return
		 * @throws IOException
		 * 
		 */
		public Object[][] loadExcelInTo2DArrayAndSkipRowAndColomun (String filePath,String sheetName,int colNumskip,int rowNumskip) throws IOException {
			String dir = System.getProperty("user.dir");// we can get current working directory
			// String filePath = "/D:/DataProviderFile.xlsx/";//File Store in src Java
			// Folder

			FileInputStream file = new FileInputStream(dir+ filePath);
			Workbook book;
			Object[][] data = null;
			String[] parts = dir.split(".");
			if (parts[1].equalsIgnoreCase("xls")) {
				book = new HSSFWorkbook(file);
				HSSFSheet sheet = (HSSFSheet) book.getSheet(sheetName);
				data = new String[sheet.getLastRowNum()][1]; // getLastRowNum return last row on the sheet

				for (int i = rowNumskip; i <= sheet.getLastRowNum(); i++) {
					HSSFRow row = sheet.getRow(i);
					int lastCell = row.getLastCellNum();// get the index of the last cell
					for (int j = colNumskip; j < lastCell; j++) {
						HSSFCell cell = row.getCell(j);
						switch (cell.getCellTypeEnum()) {
						case STRING:
							data[i][j] = cell.getStringCellValue();
						case NUMERIC:
							data[i][j] = cell.getNumericCellValue();
							break;
						default:
							System.out.println("invalid data");
							break;
						}
					}
				}
			} else if (parts[1].equalsIgnoreCase("xlsx")) {
				book = new XSSFWorkbook("file");
				XSSFSheet sheet = (XSSFSheet) book.getSheet(sheetName);
				data = new String[sheet.getLastRowNum()][1];

				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					XSSFRow row = sheet.getRow(i);
					int lastCell = row.getLastCellNum();// get the index of the last cell
					for (int j = 0; j < lastCell; j++) {
						XSSFCell cell = row.getCell(j);
						switch (cell.getCellTypeEnum()) {
						case STRING:
							data[i][j] = cell.getStringCellValue();
						case NUMERIC:
							data[i][j] = cell.getNumericCellValue();
							break;

						default:
							System.out.println("invalid data");
							break;
						}

					}

				}

			}

			return data;

			
}	
			

}
