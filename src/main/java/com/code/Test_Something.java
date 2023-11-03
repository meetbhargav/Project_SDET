package com.code;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test_Something {
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

        // headers definition for the table
        String[] headers = {"", "", ""};

        int[] columnWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            columnWidths[i] = headers[i].length();
        }
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                if (row[i].length() > columnWidths[i]) {
                    columnWidths[i] = row[i].length();
                }
            }
        }

        printRow(headers, columnWidths);
        for (String[] row : data) {
            printRow(row, columnWidths);
        }
    }

    private static void printRow(String[] data, int[] columnWidths) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(padRight(data[i], columnWidths[i] + 2));
        }
        System.out.println();
    }

    private static String padRight(String s, int width) {
        return String.format("%-" + width + "s", s);
    }
}
