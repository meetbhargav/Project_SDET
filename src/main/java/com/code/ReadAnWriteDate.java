package com.code;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadAnWriteDate {
    public static void main(String[] args) {
        List<String[]> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\files\\Data.xlsx"));
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Assuming the data is in the first sheet (index 0)
            Sheet sheet = workbook.getSheetAt(0);

            // Read data from the Excel sheet
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                List<String> rowData = new ArrayList<>();
                
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    rowData.add(cell.toString());
                }
                data.add(rowData.toArray(new String[0]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the data
        for (String[] row : data) {
            printRow(row);
        }
    }

    // Helper method to print a row
    private static void printRow(String[] data) {
        for (String cellData : data) {
            System.out.print(cellData + "\t"); // Separate cells with a tab
        }
        System.out.println(); // Move to the next row
    }
}
