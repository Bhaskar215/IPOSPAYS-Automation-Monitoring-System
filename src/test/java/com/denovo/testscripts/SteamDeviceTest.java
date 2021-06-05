package com.denovo.testscripts;

import com.denovo.Base.TestBase;
import com.denovo.Pages.LoginPage;
import com.denovo.Pages.SteamDevicePage;
import com.denovo.Util.DataProviderClassForParams;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;

public class SteamDeviceTest extends TestBase {

    LoginPage loginPage;
    SteamDevicePage steamDevicePage;

    public SteamDeviceTest() {
        super();
    }

    @BeforeTest
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        steamDevicePage = new SteamDevicePage();
        loginPage.verifylogin(pro.getProperty("username"), pro.getProperty("password"));
        steamDevicePage.verifyClickSteamlink();
    }


    @DataProvider
    public Iterator<Object[]> getReceiptData() {
        ArrayList<Object[]> getreceiptdata = DataProviderClassForParams.getReceiptData();
        return getreceiptdata.iterator();
    }


    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Receipt in SteamDevice")
    @Story("story Name: To Check Receipt")
    @Step("validate SetReceipt")
    @Test(priority = 1,description = "validate SetReceipt test",dataProvider = "getReceiptData")
    public void validateSetReceipt(String h1, String h2, String h3, String h4, String dis,String value,String value2) throws InterruptedException {
        steamDevicePage.verifySetReceipt(h1, h2, h3, h4, dis,value,value2);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify TipAndTax in SteamDevice")
    @Story("story Name: To Check TipAndTax")
    @Step("validate SetTipAndTax")
    @Test(priority = 2,description = "validate SetReceipt test",dataProvider="getTipandTax")
    public void validateSetTipandTax(String tip,String TipSugPap,String TipSugPos,
                                     String Sugfield1,String Sugfield2,String Sugfield3,String Sugfield4,String MaxTPAllow,
                                     String MaxTPHigh,String Tax,String stateTax,String localTax) throws InterruptedException {
        steamDevicePage.verifySetTipandTax(tip,TipSugPap,TipSugPos,
                Sugfield1,Sugfield2,Sugfield3,Sugfield4,MaxTPAllow,MaxTPHigh,Tax,stateTax,localTax);
    }

    @DataProvider
    public Iterator<Object[]> getTipandTax(){
        ArrayList<Object[]> tipandtax =DataProviderClassForParams.getTipandTax();
        return tipandtax.iterator();
    }


    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Transaction in SteamDevice")
    @Story("story Name: To Check Transaction")
    @Step("validate Transaction")
    @Test(priority = 3,dataProvider = "getTransaction",description = "validate Receipt test")
    public void validateSetTransaction(String TxType,String Avs,String CardType,String CardSchemes,
                                       String ManualKeyEntry,String MandatoryCVV,String SignatureLine) throws InterruptedException {

        steamDevicePage.verifySetTransaction(TxType,Avs,CardType,CardSchemes,ManualKeyEntry,MandatoryCVV,SignatureLine);

    }

    @DataProvider
    public Iterator<Object[]> getTransaction(){
      ArrayList<Object[]> gettransaction=DataProviderClassForParams.getTransaction();
      return gettransaction.iterator();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Settlement in SteamDevice")
    @Story("story Name: To Check Settlement")
    @Step("validate Settlement")
    @Test(priority = 4,dataProvider = "getSettlement",description = "validate Settlement test")
    public void validateSettlement(String SettlementMode,String Set_Time_HH,String Set_Time_MM,String Set_Time_Day,
                                   String PrintReport,String Retry,String EveryMinutes) throws InterruptedException {

        steamDevicePage.verifysetSettlement(SettlementMode,Set_Time_HH,Set_Time_MM,Set_Time_Day,PrintReport,Retry,EveryMinutes);

    }

    @DataProvider
    public Iterator<Object[]> getSettlement() {
        ArrayList<Object[]> getsettlement = DataProviderClassForParams.getSettlement();
        return getsettlement.iterator();

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify CustomFee in SteamDevice")
    @Story("story Name: To Check CustomFee")
    @Step("validate CustomFee")
    @Test(priority = 5,dataProvider = "getCustomfee",description = "validate CustomFee test ")
    public void validateSetCustomFee(String Fee,String FeeType_Custom,String Typesysmbol,String CustomfeeAmount,
                                       String CappedPercent,String DisplayLabel,String DiscloseFeetoCustomer,
                                       String ApplyFeeOnTip,String MerchantCanRemoveFee,String ApplyFeeOnDebitCard,
                                       String PasswordProtectRemove) throws InterruptedException {

        steamDevicePage.verifySetCustomFee(Fee,FeeType_Custom,Typesysmbol,CustomfeeAmount,CappedPercent,DisplayLabel,DiscloseFeetoCustomer,
                ApplyFeeOnTip, MerchantCanRemoveFee,ApplyFeeOnDebitCard,PasswordProtectRemove);

    }

    @DataProvider
    public Iterator<Object[]> getCustomfee() {
        ArrayList<Object[]> getCustomfee = DataProviderClassForParams.getCustomFee();
        return getCustomfee.iterator();

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify SurchargeFee in SteamDevice")
    @Story("story Name: To Check SurchargeFee")
    @Step("validate SurchargeFee")
    @Test(priority = 6, dataProvider = "getSurchargefee",description = "validate SurchargeFee test ")
    public void validateSetSurchargeFee(String FeeType_SurchargeFee,String Typesymbol,String Surchargefee,String CappedPercent,
                                        String DisplayLabel,String DiscloseFeetoCustomer,
                                        String ApplyFeeOnTip,String MerchantCanRemoveFee,
                                        String PasswordProtectRemove,String Typesymbol2,String DCTxAmt,String DLDC) throws InterruptedException {

        steamDevicePage.verifySetSurchargeFee(FeeType_SurchargeFee,Typesymbol,Surchargefee,CappedPercent,DisplayLabel,
                DiscloseFeetoCustomer,ApplyFeeOnTip,MerchantCanRemoveFee,PasswordProtectRemove,Typesymbol2,DCTxAmt,DLDC);
    }

    @DataProvider
    public Iterator<Object[]> getSurchargefee() {
        ArrayList<Object[]> getsurchargefee = DataProviderClassForParams.getSurchargeFee();
        return getsurchargefee.iterator();

    }


    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify DTI in SteamDevice")
    @Story("story Name: To Check DTI")
    @Step("validate DTI")
    @Test(priority = 7,dataProvider = "getDti",description = "validate DTI test ")
    public void validateSetDti(String FeeType_DTI,String Typesymbol,String DtiAmt,String SVConDebitcard,
                                        String FeeOnTip,String DiscountType,
                                        String DiscountAmount) throws InterruptedException {

        steamDevicePage.verifySetDti(FeeType_DTI,Typesymbol,DtiAmt,SVConDebitcard,FeeOnTip,
                DiscountType,DiscountAmount);

    }

    @DataProvider
    public Iterator<Object[]> getDti() {
        ArrayList<Object[]> getdti = DataProviderClassForParams.getDTI();
        return getdti.iterator();

    }

    public void validatePrintRadioBtnIsSelected() {
        boolean flag = steamDevicePage.verifyPrintIsSelected();
        Assert.assertTrue(flag, "Print Radio button Isn't Selected");
    }

    public void validateDontPrintRadioBtnIsSelected() {
        boolean flag = steamDevicePage.verifyDontPrintIsSelected();
        Assert.assertTrue(flag, "Print Radio button Isn't Selected");
    }


    public void validateSmsCheckboxIsSelected() {
        boolean flag = steamDevicePage.verifySmsIsSelected();
        Assert.assertTrue(flag, "Don't Print Radio button Isn't Selected");
    }

    public void validateEmailCheckIsSelected() {
        boolean flag = steamDevicePage.verifyEmailIsSelected();
        Assert.assertTrue(flag, "Email checkbox Isn't Selected");
    }

    @AfterTest
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}