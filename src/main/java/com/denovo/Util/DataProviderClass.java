package com.denovo.Util;

import com.denovo.Util.Readerlib.XLUtility;
import com.denovo.Util.Readerlib.Xls_Reader;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Array;
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
            String Role = reader.getCellData("AddUser", "Role", rowNum);

             // Object obj[] = new Object[];
            // addUserData.add(new Object[]{FirstName,LastName,Email,Phone});

            Object obj[] = {FirstName,LastName,Email,Phone,Role};
            addUserData.add(obj);

        }
        return addUserData;
    }


    public static ArrayList<Object[]>getCustomerData(){

        ArrayList<Object[]>addcustomer=new ArrayList<>();

        Xls_Reader reader = new Xls_Reader("E:\\IntelljWorkspaces\\src\\main\\java\\com\\denovo\\ExcelData\\SE_DataShett.xlsx");

        int tolrow=reader.getRowCount("AddCustomer");

        for(int rowNum=2;rowNum<=tolrow;rowNum++){

            String Dba = reader.getCellData("AddCustomer", "DBA", rowNum);
            String FirstName = reader.getCellData("AddCustomer", "FirstName", rowNum);
            String LastName = reader.getCellData("AddCustomer", "LastName", rowNum);
            String Isoidentified = reader.getCellData("AddCustomer", "Isoidentified", rowNum);
            String Address1 = reader.getCellData("AddCustomer", "Address1", rowNum);
            String Address2 = reader.getCellData("AddCustomer", "Address2", rowNum);
            String Zipcode = reader.getCellData("AddCustomer", "Zipcode", rowNum);
            String Email = reader.getCellData("AddCustomer", "Email", rowNum);

            String Processor = reader.getCellData("AddCustomer", "Processor", rowNum);

            String PhoneNumber =reader.getCellData("AddCustomer","PhoneNumber",rowNum);
            String TechSupportphoneNumber = reader.getCellData("AddCustomer","TechSupportphoneNumber",rowNum);
            String HelpDeskPhone = reader.getCellData("AddCustomer","HelpDeskPhone",rowNum);

            String HelpDeskEmail = reader.getCellData("AddCustomer", "HelpDeskEmail", rowNum);
            String TechSupportEmail = reader.getCellData("AddCustomer", "TechSupportEmail", rowNum);

            Object obj[] = {Dba,FirstName,LastName,Isoidentified,Address1,Address2,Zipcode,
                    Email,Processor,PhoneNumber,TechSupportphoneNumber,HelpDeskPhone,HelpDeskEmail,TechSupportEmail};
            addcustomer.add(obj);


        }
        return addcustomer;
    }
}