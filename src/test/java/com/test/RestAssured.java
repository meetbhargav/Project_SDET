package com.test;

import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class RestAssured {

    @Test(dataProvider = "userData")
    public void testRegisterAPI(String email, String password) {
        // Base URL of the API
        io.restassured.RestAssured.baseURI = "https://reqres.in/api";

        // Create a request  JSON with the data from the Excel sheet
        String requestBody = "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";

        // Send a POST request to the API
        Response response = io.restassured.RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/register");
        //response.then().log().all();
        
       String id = response.jsonPath().getString("id");
      //  System.out.println(id);
        String token = response.jsonPath().getString("token");
       // System.out.println(token);
       // System.out.println(response.getStatusCode());

        // Verify the response for positive cases
        	if (response.getStatusCode() == 200) {

	            Assert.assertTrue(Integer.parseInt(id) > 0 );
	            Assert.assertTrue(token != null && !token.isEmpty() && token instanceof String);
	            //System.out.println("For \n email : "+email+"\n password : "+password+ "\n\n Output : \n id : "+id+ "\n token : "+token+"\n Response Code : "+response.getStatusCode());
	            response.then().log().all();
        	} 
        // Add assertions for negative cases here
        	if (response.getStatusCode() == 400) {
                Assert.assertNull(id);// Code to be modified
                Assert.assertNull(token);
                //System.out.println("\n\nFor \n email : "+email+"\n password : "+password+ "\n\n Output : \n id : "+id+ "\n token : "+token + "\n Response Code : "+response.getStatusCode());
                response.then().log().all();
        	} 
    };

    @DataProvider(name = "userData")
    public Object[][] userData() {
        String excelFilePath = System.getProperty("user.dir")+"\\files\\Data.xlsx";
        String sheetName = "Sheet2";

        Object[][] testData = null;

        try (FileInputStream fileInputStream = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            testData = new Object[rowCount][2];

            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                String email = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();
                testData[i][0] = email;
                testData[i][1] = password;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testData;
    }
}
