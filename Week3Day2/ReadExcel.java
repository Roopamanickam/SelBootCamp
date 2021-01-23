package Week3Day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData() throws IOException{
		//Get into WorkBook
		XSSFWorkbook wb =new XSSFWorkbook("./data/CreateWorkSheet.xlsx");
		
		//Get into WorkSheet
		XSSFSheet sheet = wb.getSheet("Sheet1");
				/*	//get into  sheet using index
				wb.getSheetAt(0);*/
		
		//get number of rows
		int rowCount = sheet.getLastRowNum(); //(Header row is excluded)
		//int physicalNumberOfRows = sheet.getPhysicalNumberOfRows(); //to get count including header row
		System.out.println("===="+rowCount);
		
		short cellCount = sheet.getRow(0).getLastCellNum(); //column count
		System.out.println("===="+cellCount);
		
		//declare 2D array
		String[][] data = new String[rowCount][cellCount];
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
				
			}
			
		}
		
		/*//Get into row
		XSSFRow row = sheet.getRow(0);
		
		//Get into firstCell
		XSSFCell cell = row.getCell(1);
		
		//GEt the value in cell
		String CellValue = cell.getStringCellValue();
		System.out.println("=====CellValue====:"+CellValue);*/
		
		//close workbook
		wb.close();
		return data;
	}

}
