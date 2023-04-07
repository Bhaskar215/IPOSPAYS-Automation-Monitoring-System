package com.denovo.Pages;

import com.denovo.Driver.DriverManager;
import com.denovo.Reports.ExtentLogger;
import com.denovo.Util.StringUtil;
import com.denovo.enums.WaitStrategy;
import com.denovo.factories.ExplicitWaitFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.lang.reflect.Method;
import java.util.Map;

public class QuickPayWithPayNowCustomFeePage extends BasePage {

    private final By clickSteam =By.xpath("//span[contains(text(),'S.T.E.A.M')]");

    private final By clickEditParamLink =By.xpath("//a[contains(text(),'Edit Parameters')]");

    private final By searchTpn =By.xpath("(//*[@role='combobox'])[1]//input");

    private final By clickEditParamButton =By.xpath("//button[contains(text(),'Edit Parameter')]");

    private final By clickTipAndTax =By.xpath("//a[contains(text(),'Tip & Tax')]");

    private final By clickAvatarLogo =By.xpath("(//span[@class='p-avatar-text ng-star-inserted'])[1]");

    private final By clickLogout =By.xpath("//span[contains(text(),'Log Out')]");

    private final By getTipAllValue =By.xpath("(//p-selectbutton[@optionvalue='value'])[1]//span");

    private final By getTaxAllValue =By.xpath("(//p-selectbutton[@optionvalue='value'])[2]//span");

    private final By ClickFeeSection =By.xpath("//a[contains(text(),'Fee')]");

    private final By ListOfFeeBtnValues =By.xpath("(//p-selectbutton[@optionvalue='value'])[1]//span");

    private final By clickCustomFeeRadioBtn =By.xpath("//*[contains(text(),'Custom')]//parent::div/p-radiobutton");

    private final By clickFeeTypeSymbol =By.xpath("(//*[@class='ng-arrow-wrapper'])[2]");

    private final By listOfFeeTypeSymbol =By.xpath("//*[@role='listbox']//*[@role='option']//span");

    private final By cappedAmtField =By.xpath("(//*[@class='input-group mb-3 ng-star-inserted'])[1]//input");

    private final By percentageOfTxAmtField =By.xpath("(//*[@class='input-group mb-3 ng-star-inserted'])[2]//input");

    private final By displayLabelField =By.xpath("//input[@placeholder='Please Enter Display Name']");

    private final By listOfDiscloseFeevalue =By.xpath("(//p-selectbutton[@optionvalue='value'])[2]");

    private final By clickSaveBtn =By.xpath("//button[@type='submit']");

    private final By isSuccessMsg =By.xpath("//h5[@class='mt-2 mb-1 text-center']");

    private final By OpenBatchMsg =By.xpath("//*[contains(text(),' Please settle the batch to edit the Fee Section ')]");

    private final By clickGoToSettleBatch =By.xpath("//*[contains(text(),' Settle Batch ')]");

    private final By clickSettleBatch =By.xpath("//button[contains(text(),' Settle Batch ')]");

    private final By clickConfirm =By.xpath("//*[contains(text(),'Confirm')]");

    private final By clickClose =By.xpath("//button[@class='btn btn-primary mdi mdi-close btn btn-style ml-1 mr-1']");

    private final By clickOk =By.xpath("//*[contains(text(),'OK')]");

    private final By clickCloudPos =By.xpath("//*[contains(text(),'CloudPOS')]");

    private final By clickPayments =By.xpath("(//a[contains(text(),' Payments ')])[1]");

    private final By clickPaymentType =By.xpath("(//*[@class='font-weight-bold d-block'])[1]");

    private final By searchCloudPosTpn =By.xpath("//*[@class='ng-select-container']//input");

    private final By clickTpnSearch =By.xpath("//input[@id='yesno']");

    private final By isTpnPreFilled =By.xpath("//span[@class='ng-star-inserted']");

    private final By amtField =By.xpath("//input[@name='amt']");

    private final By clickOkayBtn =By.xpath("//*[contains(text(),'Okay')]");

    private final By phoneField =By.xpath("//input[@id='phone']");

    private final By cardNumber =By.xpath("//*[@name='cardNumber']");

    private final By emailField =By.xpath("//input[@formcontrolname='email']");

    private final By expirationDate =By.xpath("//input[@formcontrolname='expDate']");

    private final By clickcountrydropdown1 =By.xpath("(//div[@class='iti__selected-flag dropdown-toggle'])[1]");

    private final By clickProcessBtn =By.xpath("//button[contains(text(),'Process')]");

    private final By cloudposSuccessMsg =By.xpath("//h3[@class='text-muted mt-1 mb-3']");

    private final By getCustomFeeTotal =By.xpath("//*[@class='ml-3 custom-fee-body-width']/tr[2]/td[2]");

    private final By getSaleTotalAmt =By.xpath("//p[@class='w-75 mx-auto mb-2 text-muted']/b[2]");

    private final By getTxType =By.xpath("//p[@class='w-75 mx-auto mb-2 text-muted']/b[1]");

    private final By getEmailId =By.xpath("//p[@class='w-75 mx-auto mb-2 text-muted ng-star-inserted'][1]/b");

    private final By getPaymentSuccessFullText =By.xpath("//h5[@class='ng-star-inserted']");

    private final By getResponseMsg =By.xpath("//p[@class='w-75 mx-auto mb-2 text-muted ng-star-inserted'][2]/b");


    //Global variable
    String CustomFeeAmt;


    @Step("Click the Steam Link")
    public void verifyClickSteamLink() {
        click(clickSteam, WaitStrategy.CLICKABLE);

    }

    @Step("Click the Steam Link")
    public void verifyClickEditParamLink() {

       /* TestUtil.waitForElementToBeVisible(clickEditParamLink);
        clickEditParamLink.click();*/

        click(clickEditParamLink, WaitStrategy.CLICKABLE);
    }

    @Step("Click the Edit Parameter button")
    public void verifyClickEditParamButton() throws InterruptedException {

        click(clickEditParamButton, WaitStrategy.CLICKABLE);
    }

    public void verifySearchTpn(String tpn) throws InterruptedException {
        try{
            if(!tpn.isEmpty()) {
                sendKeys(searchTpn, tpn, WaitStrategy.PRESENCE);
                Thread.sleep(3000);
                DriverManager.getDriver().findElement(searchTpn).sendKeys(Keys.ENTER);
            }
        }catch(Exception e){
            ExtentLogger.fail("TPN NOT FOUND,Check Your Excel or PageClass ");
        }

    }

    public void verifySearchCloudPosTpn(String CloudPostpn) throws InterruptedException {
        searchCloudPosTpn(isTpnPreFilled,searchCloudPosTpn,CloudPostpn,WaitStrategy.CLICKABLE);
    }

    @Step("")
    public void verifyClickTipTaxSection(){
        click(clickTipAndTax,WaitStrategy.CLICKABLE);
    }

    public void verifyClickFeeSection() throws InterruptedException {
        click(ClickFeeSection,WaitStrategy.CLICKABLE);
    }


    public void verifyLogoutFromIso() {

        click(clickAvatarLogo,WaitStrategy.CLICKABLE);

        click(clickLogout,WaitStrategy.CLICKABLE);

    }

    @Step("QuickSale Info")
    private String fillQuickSaleWithCustomFeeParamInfo(Map<String,String>data) throws InterruptedException {
        verifyClickSteamLink();
        verifyClickEditParamLink();

        verifySearchTpn(data.get("CustomFeeTPN"));

        verifyClickEditParamButton();

        verifyClickTipTaxSection();


        Thread.sleep(1000);

        StringUtil.ClicklistofBtnByGetText(data.get("Tip"),getTipAllValue,DriverManager.getDriver());//Set Tip to NO

        StringUtil.ClicklistofBtnByGetText(data.get("Tax"),getTaxAllValue,DriverManager.getDriver());//Set Tax to NO

        verifyClickFeeSection();

        StringUtil.ClicklistofBtnByGetText(data.get("Fee"),ListOfFeeBtnValues,DriverManager.getDriver());

        //StringUtil.ClickRadioBtnByValue(quickPayCustomFeeForm.getFeeType(),clickCustomFeeRadioBtn,driver);
        Thread.sleep(3000);

        click(clickCustomFeeRadioBtn,WaitStrategy.CLICKABLE);


        click(clickFeeTypeSymbol,WaitStrategy.CLICKABLE);

        StringUtil.ClicklistofBtnByGetText(data.get("typePercentageOrDollar"),listOfFeeTypeSymbol,DriverManager.getDriver());


        sendKeys(cappedAmtField,data.get("Capped At"),WaitStrategy.VISIABLE);


        sendKeys(percentageOfTxAmtField,data.get("Percentage Of Tx Amount"),WaitStrategy.VISIABLE);


        String randNum=StringUtil.getRandomNumber();

        Thread.sleep(1000);

        sendKeys(displayLabelField,data.get("DisplayLabel")+randNum,WaitStrategy.VISIABLE);

        StringUtil.ClicklistofBtnByGetText(data.get("DiscloseFee"),listOfDiscloseFeevalue,DriverManager.getDriver());

        click(clickSaveBtn,WaitStrategy.CLICKABLE);

        VerifyTpnIsOpenBatch();

        String successOrFailMsg= ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE,isSuccessMsg).getText();

        //SuccessOrFailureMsg

        click(clickOk,WaitStrategy.CLICKABLE);

        return successOrFailMsg;
    }

    private String fillQuickSaleWithCustomFeeFeeTx(Map<String,String>data) throws InterruptedException {


        click(clickCloudPos,WaitStrategy.CLICKABLE);

        click(clickPayments,WaitStrategy.CLICKABLE);

        verifySearchCloudPosTpn(data.get("CustomFeeTPN"));

        sendKeys(amtField,data.get("Amount"),WaitStrategy.VISIABLE);

        verifyCutomFeeAmt();

        generateRandomEmail(data);

        click(clickOkayBtn,WaitStrategy.VISIABLE);

        click(clickcountrydropdown1,WaitStrategy.VISIABLE);

        //TODO Currently Phone field should be ignore.
       /* TestUtil.Selectcountrydropdown(data.get("country"),DriverManager.getDriver());
        sendKeys(phoneField,quickPayWithSurchargeForm.(),WaitStrategy.VISIABLE);
*/
        sendKeys(cardNumber,data.get("Card Number"),WaitStrategy.VISIABLE);

        sendKeys(expirationDate,data.get("Exp Date"),WaitStrategy.VISIABLE);

        click(clickProcessBtn,WaitStrategy.VISIABLE);

        return null;

    }


    public void generateRandomEmail(Map<String,String>data){

        String randEmail = StringUtil.getRandomAlphaNumericStringMinOrMax();
        sendKeys(emailField,randEmail+data.get("Email"),WaitStrategy.VISIABLE);
    }

    public String verifyQuickPayWithCustomFeeFormIsoLogin(Map<String,String>data) throws InterruptedException {
        return fillQuickSaleWithCustomFeeParamInfo(data);
    }

    public void verifyCutomFeeAmt() throws InterruptedException {
        click(clickPaymentType,WaitStrategy.CLICKABLE);
        Thread.sleep(1000);
        CustomFeeAmt =ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE, getCustomFeeTotal).getText()
                .replace("$","");
    }

    public String getActualCustomFee(){
        return CustomFeeAmt;
    }

    public String getGetSaleTotalAmt(){
        return ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE,getSaleTotalAmt)
                .getText()
                .replace("$","");
    }

    public String getGetTxType() {
        return ExplicitWaitFactory
                .performExplicityWait(WaitStrategy.VISIABLE,getTxType)
                .getText();
    }

    public String getGetEmailId(){
        return ExplicitWaitFactory
                .performExplicityWait(WaitStrategy.VISIABLE,getEmailId)
                .getText();
    }

    public String getPaymentSuccessFullMsg(){
        return ExplicitWaitFactory
                .performExplicityWait(WaitStrategy.VISIABLE,getPaymentSuccessFullText)
                .getText();

    }

    public String getResponseMsg(){
        return ExplicitWaitFactory
                .performExplicityWait(WaitStrategy.VISIABLE,getResponseMsg)
                .getText();
    }

    public String verifyIsTxSuccess() throws Exception {
        String  successMsgText = null;
        try{
            successMsgText =ExplicitWaitFactory
                    .performExplicityWait(WaitStrategy.VISIABLE,cloudposSuccessMsg)
                    .getText();
        }catch (Exception e){
            throw new Exception("tx declined");

        }
        return successMsgText;
    }

    public String verifyQuickSaleTxWithCustomFee(Map<String,String>data) throws InterruptedException {
        return fillQuickSaleWithCustomFeeFeeTx(data);
    }


    public void VerifyTpnIsOpenBatch(){
        try{
            Thread.sleep(1000);
            ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE,OpenBatchMsg);
            boolean isOpenBatch =DriverManager.getDriver().findElement(OpenBatchMsg).isDisplayed();
            if(isOpenBatch){
                click(clickGoToSettleBatch,WaitStrategy.CLICKABLE);
                //It click Settles on Batch module

                Thread.sleep(1000);
                click(clickSettleBatch,WaitStrategy.CLICKABLE);

                click(clickConfirm,WaitStrategy.CLICKABLE);

                Thread.sleep(2000);
                click(clickClose,WaitStrategy.CLICKABLE);

                click(clickSaveBtn,WaitStrategy.CLICKABLE);
            }else{
                System.out.println("Open batch Not Found");
            }
        }catch (Exception e){
            System.out.println("");
        }
    }
}

