package com.denovo.Util;

import com.denovo.Util.Readerlib.XLUtility;
import com.denovo.Util.Readerlib.Xls_Reader;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.ArrayList;

public class DataProviderClass {

    @DataProvider(name = "webLogin")
    public Object[][] credentials() throws IOException {
        XLUtility xlutil = new XLUtility("E:\\IntelljWorkspaces\\src\\main\\java\\com\\denovo\\ExcelData\\SE_DataShett.xlsx");
        int tolrow = xlutil.getRowCount("Login");
        int tolcol = xlutil.getCellCount("Login", 1);

        Object logindata[][] = new Object[tolrow][tolcol];

        for (int row = 1; row <= tolrow; row++) {
            for (int col = 0; col < tolcol; col++) {
                logindata[row - 1][col] = xlutil.getCellData("Login", row, col);
            }
        }
        return logindata;
    }


    public static ArrayList<Object[]> getdatafromexcel() {

        ArrayList<Object[]> addUserData = new ArrayList<>();


        Xls_Reader reader = new Xls_Reader("E:\\IntelljWorkspaces\\src\\main\\java\\com\\denovo\\ExcelData\\SE_DataShett.xlsx");

        int tolrow = reader.getRowCount("AddUser");

        for (int rowNum = 2; rowNum <= tolrow; rowNum++) {

            String FirstName = reader.getCellData("AddUser", "FirstName", rowNum);
            String LastName = reader.getCellData("AddUser", "LastName", rowNum);
            String Email = reader.getCellData("AddUser", "Email", rowNum);
            String Phone = reader.getCellData("AddUser", "Phone", rowNum);

             // Object obj[] = new Object[];
            // addUserData.add(new Object[]{FirstName,LastName,Email,Phone});

            Object obj[] = {FirstName,LastName,Email,Phone};
            addUserData.add(obj);

        }
        return addUserData;
    }

}

