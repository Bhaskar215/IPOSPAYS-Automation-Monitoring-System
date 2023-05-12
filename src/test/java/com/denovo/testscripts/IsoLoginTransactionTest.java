package com.denovo.testscripts;

import com.denovo.Pages.LoginPage;
import com.denovo.Pages.TransactionPage;
import com.denovo.Util.DataProviderUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class IsoLoginTransactionTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    TransactionPage transactionPage = new TransactionPage();

    @Test(dataProvider = "getData")
    public void validateTransactionPageOnIsoLogin(Map<String,String>data) throws Exception {

        loginPage.verifyLoginWithCorrectCredentials(data.get("ISOPrimaryEmail"),data.get("ISOPrimaryPWD"));

        transactionPage.clickTransactionPage();
        Thread.sleep(2000);

        transactionPage.verifyIsTransactionLoaded();
        Thread.sleep(2000);
    }

    @DataProvider
    public  Object[][] getData() throws IOException {
        Object[][] arrObject=null;

        arrObject= DataProviderUtil.getExcelData(System.getProperty("user.dir")+"/src/main/java/com/denovo/ExcelData/SE_DataSheet.xlsx","IsoLoginTransaction");
        return arrObject;
    }
}