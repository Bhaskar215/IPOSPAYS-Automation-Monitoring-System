package com.denovo.Util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProviderUtil {


    public static String path;
    public static String sheetName;


    public  static  Object[][] getExcelData(String fName,String sName) throws IOException {

        File file = new File(fName);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sName);

        // QPayWithSendLinkCustomFee
        int lastRowNum = sheet.getLastRowNum();
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        Object[][] addData = new Object[lastRowNum][1];

        Map<String,String> map;

        for(int i=1;i<=lastRowNum;i++){
            map = new HashMap<>();
            for (int j=0; j< lastCellNum;j++){
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value= sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key,value);
            }
            System.out.println(map);
            addData[i-1][0] = map;
        }
        return addData;
    }

}