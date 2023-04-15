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
    public void systemLoginDashboard(Map<String,String> data) throws InterruptedException {
        loginPage.verifyLoginWithCorrectCredentials(data.get("SystemPrimaryEmail"),data.get("SystemPrimaryPWD"));

        dashboardPage.setClickDashboardCustomizeBtn();

        dashboardPage.clickSaveAndCloseBtn();
        Thread.sleep(3000);

        String TransactionsVolume =dashboardPage.VerifyDashboardPageIsLoading();
        Assert.assertEquals(TransactionsVolume,"Transactions Volume");

        boolean isTxVolumeErrorFound=dashboardPage.verifyTransactionVolume();
        Assert.assertTrue(isTxVolumeErrorFound);

       boolean isTxCoundError=dashboardPage.verifyTransactionCount();
        Assert.assertTrue(isTxCoundError);

        boolean isMerchantBoardError =dashboardPage.verifyMerchantBoarding();
        Assert.assertTrue(isMerchantBoardError);

        boolean isMerchantDeactivateError=dashboardPage.verifyMerchantDeactivateBoard();
        Assert.assertTrue(isMerchantDeactivateError);

        boolean isTransactedMerchant=dashboardPage.verifyTransactedMerchantBoard();
        Assert.assertTrue(isTransactedMerchant);

        boolean MerchantHaveNotTransactedBoard=dashboardPage.verifyMerchantHaveNotTransactedBoard();
        Assert.assertTrue(MerchantHaveNotTransactedBoard);



    }

    @DataProvider
    public  Object[][] getData() throws IOException {
        Object[][] arrObject=null;
        /*arrObject= DataProviderUtil.getExcelData(System.getProperty("user.dir")+"/src/main/java/com/denovo/ExcelData/CloudPos.xlsx",
                "Merchant(P)SurchargeFee_QPayNow");*/
        arrObject= DataProviderUtil.getExcelData(System.getProperty("user.dir")+"/src/main/java/com/denovo/ExcelData/SE_DataSheet.xlsx","SystemLoginDashboard");
        return arrObject;
    }

}
