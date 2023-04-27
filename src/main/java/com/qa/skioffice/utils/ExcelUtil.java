package com.qa.skioffice.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static final String Test_Data = "C:/Users/jyothirmai.sunkara/eclipse-workspace/Skioffice2023/src/test/resources/testdata/AddEmp.xlsx";

	private static Workbook book;
	private static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		
		Object data[][] = null;
	
		try {
			FileInputStream ip = new FileInputStream(Test_Data);
			
				book = WorkbookFactory.create(ip);
				sheet = book.getSheet(sheetName);
				
				data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//				int i=0;
				System.out.println("sheet.getLastRowNum() : "+sheet.getLastRowNum());
				for(int i = 0; i<sheet.getLastRowNum(); i++) {
					for(int j = 0; j<sheet.getRow(0).getLastCellNum(); j++){
						
						data[i][j] = sheet.getRow(i+1).getCell(j).toString();
						System.out.println("data["+i+"]["+j+"] : "+data[i][j]);
					}
					
				}
				
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return data;
		
	}

}
