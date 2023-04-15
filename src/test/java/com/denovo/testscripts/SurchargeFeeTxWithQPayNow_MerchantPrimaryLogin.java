package com.denovo.testscripts;

import com.denovo.Pages.LoginPage;
import com.denovo.Pages.QuickPayWithPayNowCustomFeePage;
import com.denovo.Pages.QuickPayWithSurchargeFeePage;
import com.denovo.Util.DataProviderUtil;
import com.denovo.constants.FrameWorkConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Map;

public class SurchargeFeeTxWithQPayNow_MerchantPrimaryLogin extends BaseTest {

    LoginPage loginPage  = new LoginPage();
    QuickPayWithSurchargeFeePage quickPayWithSurchargeFeePage = new QuickPayWithSurchargeFeePage();

    SoftAssert softAssert= new SoftAssert();


    @Test(priority = 1,dataProvider = "getData")
    public void surchargeFeeTxWithQPayNow_MerchantPrimaryLogin(Map<String,String>data) throws Exception {

            loginPage.verifyLoginWithCorrectCredentials(data.get("ISOPrimaryEmail"), data.get("ISOPrimaryPwd"));

            String isParameterSaved = quickPayWithSurchargeFeePage.verifyQuickPayWithSurchargeFeeFormIsoLogin(data);

            Assert.assertEquals(isParameterSaved, "Parameter Updated Successfully","Parameter Failed");

            quickPayWithSurchargeFeePage.verifyLogoutFromIso();

             loginPage.verifyLoginWithCorrectCredentials(data.get("MerchantPrimaryUser"), data.get("MerchantPrimaryPwd"));

        quickPayWithSurchargeFeePage.verifyQuickSaleTxWithSurchargeFee(data);

             //It will Surcharge Fee Amount
             String actualSurchargeFeeAmt=quickPayWithSurchargeFeePage.getActualSurchargeFee();
             softAssert.assertEquals(actualSurchargeFeeAmt,data.get("Expected FeeAmt"),"surchargeFee Amount is incorrect");

             //It will check Tx get Approved text is present.
             String  isApproved =quickPayWithSurchargeFeePage.verifyIsTxSuccess();
             softAssert.assertEquals(isApproved,"Approved !","Tx Declined");

             //It will check Total sale amount
             String actualSaleTotal =quickPayWithSurchargeFeePage.getGetSaleTotalAmt();
             softAssert.assertEquals(actualSaleTotal,data.get("Expected TotalAmt"));

             //It will check TxType(sale or pre-Auth)
              String actualTxType = quickPayWithSurchargeFeePage.getGetTxType();
              softAssert.assertEquals(actualTxType,"Card - Sale");

              //It will check Payment Successful Message
             String paymentSuccessText = quickPayWithSurchargeFeePage.getPaymentSuccessFullMsg();
             softAssert.assertEquals(paymentSuccessText,"Payment Successful");

             //Is Response Message
             String ActualResponseMsg =quickPayWithSurchargeFeePage.getResponseMsg();
             softAssert.assertTrue(ActualResponseMsg.contains("APPROVAL"),"Response Message Not viewed");
             softAssert.assertAll();
    }

    @DataProvider
    public  Object[][] getData() throws IOException {
        Object[][] arrObject=null;
        /*arrObject= DataProviderUtil.getExcelData(System.getProperty("user.dir")+"/src/main/java/com/denovo/ExcelData/CloudPos.xlsx",
                "Merchant(P)SurchargeFee_QPayNow");*/
        arrObject= DataProviderUtil.getExcelData(FrameWorkConstants.getExcelPATH(),"Merchant(P)SurchargeFee_QPayNow");
        return arrObject;
    }
}