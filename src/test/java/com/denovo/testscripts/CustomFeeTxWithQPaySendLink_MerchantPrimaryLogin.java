

package com.denovo.testscripts;

import com.denovo.Driver.DriverManager;
import com.denovo.Pages.LoginPage;
import com.denovo.Pages.QPayWithSendLinkOnCustomFeePage;
import com.denovo.Util.DataProviderUtil;
import com.denovo.Util.JavascriptExecutorUtil;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Map;

public class CustomFeeTxWithQPaySendLink_MerchantPrimaryLogin extends BaseTest  {


    LoginPage loginPage = new LoginPage();
    QPayWithSendLinkOnCustomFeePage qPayWithSendLinkOnCustomFeePage = new QPayWithSendLinkOnCustomFeePage();

        //PerformCustomFeeTxWithQPay_PayNow   CustomFeeTxWithQPayNow_MerchantPrimaryLogin    CustomFeeTxWithQPaySendLink_MerchantPrimaryLovin
    @Test(priority = 1,dataProvider = "getData")
    public  void customFeeTxWithQPaySendLink_MerchantPrimaryLogin(Map<String,String> data) throws Exception {

        loginPage.verifyLoginWithCorrectCredentials(data.get("ISOPrimaryEmail"), data.get("ISOPrimaryPwd"));

        String isParameterSaved =  qPayWithSendLinkOnCustomFeePage.verifyQPayWithSendLinkOnCustomFeeParamInfo(data);

        Assert.assertEquals(isParameterSaved, "Parameter Updated Successfully","Parameter Failed");

        qPayWithSendLinkOnCustomFeePage.verifyLogoutFromIso();

        loginPage.verifyLoginWithCorrectCredentials(data.get("MerchantPrimaryUser"),data.get("MerchantPrimaryPwd"));

        qPayWithSendLinkOnCustomFeePage.verifyQPayWithSendLinkOnCustomFee(data);


        //This Method will Assert All Amounts(SaleBaseAmount,CustomFee,TotalAmount)
        AssertPaymentFormAmounts(data);

        JavascriptExecutorUtil.scrollDown(DriverManager.getDriver());
        Thread.sleep(1000);

       String actualTotalOnPayBtn = qPayWithSendLinkOnCustomFeePage.verifyTotalAmtOnPayBtn();
           Assertions.assertThat(actualTotalOnPayBtn)
                   .isEqualTo(data.get("Expected TotalAmt"));


        qPayWithSendLinkOnCustomFeePage.verifyClickPayBtn();

        AssertPaymentSuccessScreenAmount(data);

        qPayWithSendLinkOnCustomFeePage.doRefreshTheScreen();
        String isExpire=qPayWithSendLinkOnCustomFeePage.verifyExpireScreen();
        Assertions.assertThat(isExpire)
                .isEqualTo("Link Expired.");

        qPayWithSendLinkOnCustomFeePage.switchToParentWindow(DriverManager.getDriver())
                .clickTheRefreshBtn()
                .searchReferenceNumber()
                .verifyInvoiceStatusAfterTx()
                .verifyInvoiceTotalAmtAfterTx(data);


    }

    @DataProvider
    public  Object[][] getData() throws IOException {
        Object[][] arrObject=null;
        arrObject= DataProviderUtil.getExcelData(System.getProperty("user.dir")+"/src/main/java/com/denovo/ExcelData/CloudPos.xlsx",
                "QPayWithSendlinkCustomFee");
        return arrObject;
    }


    public void AssertPaymentFormAmounts(Map<String,String>data) throws Exception {
        String actualFormTotalAmt=qPayWithSendLinkOnCustomFeePage.verifyFormTotalAmt();
        Assertions.assertThat(actualFormTotalAmt)
                .isEqualTo(data.get("Expected TotalAmt"));
        //Credit/Debit Amt
        String actualFormCDTotalAmt=qPayWithSendLinkOnCustomFeePage.verifyCDTotalAmt();
        Assertions.assertThat(actualFormCDTotalAmt)
                .isEqualTo(data.get("Expected TotalAmt"));

        String actualFormSaleAmt =qPayWithSendLinkOnCustomFeePage.verifyFormSaleAmt();
        Assertions.assertThat(actualFormSaleAmt)
                .isEqualTo(data.get("Expected BaseAmt"));

        String actualFormCustomAmt = qPayWithSendLinkOnCustomFeePage.verifyFormCustomFeeAmt();
        Assertions.assertThat(actualFormCustomAmt)
                .isEqualTo(data.get("Expected FeeAmt"));
    }

    public void AssertPaymentSuccessScreenAmount(Map<String,String>data) throws Exception {
        //ToDo Need to Assert Email on SuccessScreen
        String isPaymentSuccess=qPayWithSendLinkOnCustomFeePage.verifyIsPaymentSuccess();
        Assertions.assertThat(isPaymentSuccess)
                .contains("Payment Successfull")
                .doesNotContain("Failed");

        String successScreenCompleteMsg = qPayWithSendLinkOnCustomFeePage.verifySuccessScrnTotalAmt();
        Assertions.assertThat(successScreenCompleteMsg)
                .contains(data.get("Expected TotalAmt"))
                .contains("Sale");
    }
}