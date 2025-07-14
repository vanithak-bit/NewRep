package NewDemoTestNG;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class DataDriven {

    @DataProvider(name = "excelData")

    public static void main (String [] args) throws IOException{
    //Path of the excel file
    FileInputStream fs = new FileInputStream("C:\\Automation\\DemoFile.xlsx");
    //Creating a workbook
    XSSFWorkbook workbook = new XSSFWorkbook(fs);
    XSSFSheet sheet = workbook.getSheetAt(0);
    Row row = sheet.getRow(0);
    Cell cell = row.getCell(0);
    System.out.println(sheet.getRow(0).getCell(0));
    Row row1 = sheet.getRow(1);
    Cell cell1 = row1.getCell(1);
    System.out.println(sheet.getRow(0).getCell(1));
    Row row2 = sheet.getRow(1);
    Cell cell2 = row2.getCell(1);
    System.out.println(sheet.getRow(1).getCell(0));
    Row row3 = sheet.getRow(1);
    Cell cell3 = row3.getCell(1);
    System.out.println(sheet.getRow(1).getCell(1));
    //String cellval = cell.getStringCellValue();
    //System.out.println(cellval);
    }
    

    @Test(dataProvider = "excelData")
    public void testWithData(String username, String password) {
        // Use the data from Excel here
        System.out.println("Username: " + username + ", Password: " + password);
    }
}