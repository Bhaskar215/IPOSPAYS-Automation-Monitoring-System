package com.denovo.Util;

import com.denovo.constants.FrameWorkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {

    private ExcelUtils(){}


    public static List<Map<String,String>>getTestDetails(){

        FileInputStream fis;
        XSSFWorkbook workbook = null;


        try {
            fis = new FileInputStream(FrameWorkConstants.getExcelPATH());
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
            String sheetName = "RunManager";
            assert workbook != null;
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int lastRowNum = sheet.getLastRowNum();
            int lastCellNum = sheet.getRow(0).getLastCellNum();

        List<Map<String,String>> list = new ArrayList<>();
        Map<String, String> map = null;


            for (int i = 1; i <= lastRowNum; i++) {
                map=new HashMap<>();
                for (int j = 0; j<lastCellNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key,value);
                }
                list.add(map);
            }
        System.out.println(list);
        return list;
    }
}
