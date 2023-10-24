package com.code;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAnWriteDate {
	
public static void main(String args[]){
		try {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\files\\Data.xlsx");
		
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		Map<String,List<String>> columnDataMap =new HashMap<String,List<String>>();
		
		Iterator <Row> rowIterator = sheet.iterator(); 
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			
			Iterator<Cell> cellIterator = row.cellIterator();
			int columnIndex = 0;
		
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = cell.toString();
				
				String columnName = "column" + columnIndex;
				columnDataMap.computeIfAbsent(columnName, k -> new ArrayList<>()).add(cellValue);
				columnIndex++;
				
			}
		}
		
		for(String columnName: columnDataMap.keySet()) {
			List<String> columnData = columnDataMap.get(columnName);
			System.out.println("column: "+columnName);
			System.out.println("Data: " + columnData);
		}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
