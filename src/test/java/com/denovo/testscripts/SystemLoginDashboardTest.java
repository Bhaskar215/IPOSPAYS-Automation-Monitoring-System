package com.denovo.testscripts;

import com.denovo.Pages.DashboardPage;
import com.denovo.Pages.LoginPage;
import com.denovo.Util.DataProviderUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class SystemLoginDashboardTest extends BaseTest{

    LoginPage loginPage  = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();


    @Test(dataProvider = "getData")
    public void validateDashboardOnSystemLogin(Map<String,String> data) throws InterruptedException {
        loginPage.verifyLoginWithCorrectCredentials(data.get("SystemPrimaryEmail"),data.get("SystemPrimaryPWD"));
        boolean isDashboardPage=dashboardPage.verifyDashboardIsLoaded();
        Assert.assertTrue(isDashboardPage);

    }

    @DataProvider
    public  Object[][] getData() throws IOException {
        Object[][] arrObject=null;
        arrObject= DataProviderUtil.getExcelData(System.getProperty("user.dir")+"/src/main/java/com/denovo/ExcelData/SE_DataSheet.xlsx","SystemLoginDashboard");
        return arrObject;
    }

}
