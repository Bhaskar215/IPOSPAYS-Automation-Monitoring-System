package com.denovo.testscripts;

import com.denovo.Pages.LoginPage;
import com.denovo.Pages.MerchantPage;
import com.denovo.Pages.TransactionPage;
import com.denovo.Util.DataProviderUtil;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class SystemLoginMerchantTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    MerchantPage merchantPage = new MerchantPage();

    @Test(dataProvider = "getData",description = "To Check Merchant Page Loading On System Login ")
    public void validateMerchantPageOnSystemLogin(Map<String,String>data) throws Exception {

        loginPage.verifyLoginWithCorrectCredentials(data.get("SystemPrimaryEmail"),data.get("SystemPrimaryPWD"));

        merchantPage.clickMerchantPage();
        Thread.sleep(2000);
        String isMerchantPageLoadMoreThan5Sec = merchantPage.verifyIsMerchantLoaded();

        Assertions.assertThat(isMerchantPageLoadMoreThan5Sec)
                        .withFailMessage("Merchant Module Loading TimeTaken More that " + isMerchantPageLoadMoreThan5Sec + " seconds on ISO Login")
                .isLessThanOrEqualTo("6");
        Thread.sleep(1000);
    }

    @DataProvider
    public  Object[][] getData() throws IOException {
        Object[][] arrObject=null;
        arrObject= DataProviderUtil.getExcelData(System.getProperty("user.dir")+"/src/main/java/com/denovo/ExcelData/SE_DataSheet.xlsx","SystemLoginMerchant");
        return arrObject;
    }
}