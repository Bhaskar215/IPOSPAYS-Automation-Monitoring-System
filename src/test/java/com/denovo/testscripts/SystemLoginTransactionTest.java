package com.denovo.testscripts;

import com.denovo.Pages.LoginPage;
import com.denovo.Pages.TransactionPage;
import com.denovo.Util.DataProviderUtil;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class SystemLoginTransactionTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    TransactionPage transactionPage = new TransactionPage();

    @Test(dataProvider = "getData",description = "To Check Transaction Page Loading On System Login ")
    public void validateTransactionPageOnSystemLogin(Map<String,String>data) throws Exception {

        loginPage.verifyLoginWithCorrectCredentials(data.get("SystemPrimaryEmail"),data.get("SystemPrimaryPWD"));

        transactionPage.clickTransactionPage();
        Thread.sleep(2000);

        String isTxPageLoadMoreThan5Sec=transactionPage.verifyIsTransactionLoaded();

        Assertions.assertThat(isTxPageLoadMoreThan5Sec)
                .withFailMessage("Transaction loading took more then  " + isTxPageLoadMoreThan5Sec + " seconds on System Login")
                .isLessThanOrEqualTo("6");
        Thread.sleep(1000);

    }

    @DataProvider
    public  Object[][] getData() throws IOException {
        Object[][] arrObject=null;

        arrObject= DataProviderUtil.getExcelData(System.getProperty("user.dir")+"/src/main/java/com/denovo/ExcelData/SE_DataSheet.xlsx","SystemLoginTransaction");
        return arrObject;
    }
}
