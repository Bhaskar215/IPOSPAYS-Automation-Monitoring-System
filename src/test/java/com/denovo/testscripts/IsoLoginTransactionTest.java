package com.denovo.testscripts;

import com.denovo.Pages.LoginPage;
import com.denovo.Pages.TransactionPage;
import com.denovo.Util.DataProviderUtil;
import com.denovo.Util.ELKUtils;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.util.Map;

public class IsoLoginTransactionTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    TransactionPage transactionPage = new TransactionPage();

    @Test(dataProvider = "getData",description = "To Check Transaction Page Loading On ISo Login ")
    public void validateTransactionPageOnIsoLogin(Map<String,String>data) throws Exception {

        loginPage.verifyLoginWithCorrectCredentials(data.get("ISOPrimaryEmail"),data.get("ISOPrimaryPWD"));

        transactionPage.clickTransactionPage();
        Thread.sleep(2000);
        String isTxPageLoadMoreThan5Sec=transactionPage.verifyIsTransactionLoaded();

        Assertions.assertThat(isTxPageLoadMoreThan5Sec)
                        .withFailMessage("Transaction Loading TimeTaken More that 6 seconds on ISO Login")
                .isLessThanOrEqualTo("6");
        Thread.sleep(1000);
    }

    @DataProvider
    public  Object[][] getData() throws IOException {
        Object[][] arrObject=null;

        arrObject= DataProviderUtil.getExcelData(System.getProperty("user.dir")+"/src/main/java/com/denovo/ExcelData/SE_DataSheet.xlsx","IsoLoginTransaction");
        return arrObject;
    }
}