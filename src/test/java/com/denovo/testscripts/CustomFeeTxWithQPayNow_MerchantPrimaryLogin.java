package com.denovo.testscripts;

import com.denovo.Pages.LoginPage;
import com.denovo.Pages.QuickPayWithPayNowCustomFeePage;
import com.denovo.Util.DataProviderUtil;
import com.denovo.constants.FrameWorkConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Map;

public class CustomFeeTxWithQPayNow_MerchantPrimaryLogin extends BaseTest {

    LoginPage loginPage  = new LoginPage();;
    QuickPayWithPayNowCustomFeePage quickPayWithCustomFeePage = new QuickPayWithPayNowCustomFeePage();
    SoftAssert softAssert= new SoftAssert();

    //CustomFeeTxWithPayNow_MerchantPrimaryLogin
    @Test(priority = 1,dataProvider = "getData")
    public void customFeeTxWithQPayNow_MerchantPrimaryLogin(Map<String,String>data) throws Exception {

        loginPage.verifyLoginWithCorrectCredentials(data.get("ISOPrimaryEmail"), data.get("ISOPrimaryPwd"));

        String isParameterSaved = quickPayWithCustomFeePage.verifyQuickPayWithCustomFeeFormIsoLogin(data);

        Assert.assertEquals(isParameterSaved, "Parameter Updated Successfully","Parameter Failed");

        quickPayWithCustomFeePage.verifyLogoutFromIso();

        loginPage.verifyLoginWithCorrectCredentials(data.get("MerchantPrimaryUser"), data.get("MerchantPrimaryPwd"));

        quickPayWithCustomFeePage.verifyQuickSaleTxWithCustomFee(data);

        //It will Surcharge Fee Amount
        String actualSurchargeFeeAmt=quickPayWithCustomFeePage.getActualCustomFee();
        softAssert.assertEquals(actualSurchargeFeeAmt,data.get("Expected FeeAmt"),"CustomFee Amount is incorrect");

        //It will check Tx get Approved text is present.
        String  isApproved =quickPayWithCustomFeePage.verifyIsTxSuccess();
        softAssert.assertEquals(isApproved,"Approved !","Tx Declined");

        //It will check Total sale amount
        String actualSaleTotal =quickPayWithCustomFeePage.getGetSaleTotalAmt();
        softAssert.assertEquals(actualSaleTotal,data.get("Expected TotalAmt"));

        //It will check TxType(sale or pre-Auth)
        String actualTxType = quickPayWithCustomFeePage.getGetTxType();
        softAssert.assertEquals(actualTxType,"Card - Sale");

        //It will check Payment Successful Message
        String paymentSuccessText = quickPayWithCustomFeePage.getPaymentSuccessFullMsg();
        softAssert.assertEquals(paymentSuccessText,"Payment Successful");

        //Is Response Message
        String ActualResponseMsg =quickPayWithCustomFeePage.getResponseMsg();
        softAssert.assertTrue(ActualResponseMsg.contains("APPROVAL"),"Response Message Not viewed");

        softAssert.assertAll();
    }

    @DataProvider(parallel = true)
    public  Object[][] getData() throws IOException {
        Object[][] arrObject=null;
        arrObject= DataProviderUtil.getExcelData(FrameWorkConstants.getExcelPATH(),
                "Merchant(P)CustomFee_QPayNow");
        return arrObject;
    }
}
