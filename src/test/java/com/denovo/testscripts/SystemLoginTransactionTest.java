package com.denovo.testscripts;

import com.denovo.Pages.LoginPage;
import com.denovo.Pages.TransactionPage;
import com.denovo.Util.DataProviderUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class SystemLoginTransactionTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    TransactionPage transactionPage = new TransactionPage();

    @Test(dataProvider = "getData")
    public void validateTransactionPageOnSystemLogin(Map<String,String>data) throws Exception {

        loginPage.verifyLoginWithCorrectCredentials(data.get("SystemPrimaryEmail"),data.get("SystemPrimaryPWD"));

        transactionPage.clickTransactionPage();
        Thread.sleep(2000);

        boolean isTransactionLoaded=transactionPage.verifyIsTransactionLoaded();
        Assert.assertTrue(isTransactionLoaded);
        Thread.sleep(1000);

    }

    @DataProvider
    public  Object[][] getData() throws IOException {
        Object[][] arrObject=null;

        arrObject= DataProviderUtil.getExcelData(System.getProperty("user.dir")+"/src/main/java/com/denovo/ExcelData/SE_DataSheet.xlsx","SystemLoginTransaction");
        return arrObject;
    }
}
