
package com.denovo.Pages;

import com.denovo.Driver.DriverManager;
import com.denovo.Util.DynamicXpathUtils;
import com.denovo.Util.JavascriptExecutorUtil;
import com.denovo.Util.StringUtil;
import com.denovo.enums.WaitStrategy;
import com.denovo.factories.ExplicitWaitFactory;
import org.openqa.selenium.*;
import org.testng.asserts.SoftAssert;

import java.util.Map;
import java.util.Set;

public class QPayWithSendLinkOnCustomFeePage extends BasePage {


    private static String ReferenceNum;
    //Dynamic Xpaths
    private final String listOfParamSwitchBtnXpath = "//label[text()='%s']//following::p-selectbutton[1]//span";

    private final String clickParamSection ="//a[contains(text(),'%s')]";

    private final By clickSteam =By.xpath("//span[contains(text(),'S.T.E.A.M')]");

    private final By clickEditParamLink =By.xpath("//a[contains(text(),'Edit Parameters')]");

    private final By searchTpn =By.xpath("(//*[@role='combobox'])[1]//input");

    private final By searchRef =By.xpath("//*[@type='text']");

    private final By clickRefreshBtn =By.xpath("//*[@ngbpopover='Refresh']");


    private final By clickEditParamButton =By.xpath("//button[contains(text(),'Edit Parameter')]");

    private final By clickTipAndTax =By.xpath("//a[contains(text(),'Tip & Tax')]");

    private final By clickAvatarLogo =By.xpath("(//span[@class='p-avatar-text ng-star-inserted'])[1]");

    private final By clickLogout =By.xpath("//span[contains(text(),'Log Out')]");

    private final By getTipAllValue =By.xpath("(//p-selectbutton[@optionvalue='value'])[1]//span");

    private final By getTaxAllValue =By.xpath("(//p-selectbutton[@optionvalue='value'])[2]//span");

    private final By ClickFeeSection =By.xpath("//a[contains(text(),'Fee')]");

    private final By ListOfFeeBtnValues =By.xpath("(//p-selectbutton[@optionvalue='value'])[1]//span");

    private final By isCustomFeeEnable = By.xpath("//*[@type='radio'][@value='1']");

    private final By clickCustomFeeRadioBtn = By.xpath("//*[contains(text(),'Custom Fee')]//parent::div/p-radiobutton");

    private final By clickFeeTypeSymbol = By.xpath("(//*[@class='ng-arrow-wrapper'])[2]");

    private final By listOfFeeTypeSymbol =By.xpath("//*[@role='listbox']//*[@role='option']//span");

    private final By percentageOfTxAmtField =By.xpath("(//*[@class='input-group mb-3 ng-star-inserted'])[1]//input");

    private final By ClickvalueAdded = By.xpath("//*[text()='Value Add ']");

    private final By cappedAmtField =By.xpath("//*[text()=' Capped at ']//following::input[1]");

    private final By displayLabelField =By.xpath("//input[@placeholder='Please Enter Display Name']");

    private final By listOfDiscloseFeevalue =By.xpath("//*[contains(text(),'Disclose Fee')]/following::p-selectbutton[1]");

    private final By clickSaveBtn =By.xpath("//button[@type='submit']");

    private final By isSuccessMsg =By.xpath("//h5[@class='mt-2 mb-1 text-center']");

    private final By OpenBatchMsg =By.xpath("//*[contains(text(),' Please settle the batch to edit the Fee Section ')]");

    private final By clickGoToSettleBatch =By.xpath("//*[contains(text(),' Settle Batch ')]");

    private final By clickSettleBatch =By.xpath("//*[contains(text(),' Settle Batch ')]");

    private final By clickConfirm =By.xpath("//*[contains(text(),' Confirm')]");

    private final By clickClose =By.xpath("//button[@class='btn btn-primary mdi mdi-close btn btn-style ml-1 mr-1']");

    private final By clickOk =By.xpath("//*[contains(text(),'OK')]");

    private final By clickCloudPos =By.xpath("//*[contains(text(),'CloudPOS')]");

    //Payment Module
    private final By clickPayments =By.xpath("(//a[contains(text(),' Payments ')])[1]");

    private final By clickSendLink =By.xpath("//*[contains(text(),'Send Payment Link')]");

    private final By listOfDisabledBtn =By.xpath("(//*[@class='form-check-input ng-untouched ng-pristine ng-valid' and @disabled])//following-sibling::label[1]");

    private final By searchCloudPosTpn =By.xpath("//*[@class='ng-select-container']//input");

    private final By clickTpnSearch =By.xpath("//input[@id='yesno']");

    private final By isTpnPreFilled =By.xpath("//span[@class='ng-star-inserted']");

    private final By amtField =By.xpath("//input[@name='amt']");

    private final By clickOkayBtn =By.xpath("//*[contains(text(),'Okay')]");

    private final By emailField =By.xpath("//input[@name='email']");

    private final By mer_BreakUpScreenTotalAmt =By.xpath("//*[contains(text(),'Total')]/following-sibling::h3");

    private final By mer_BreakUpScreenSaleAmt =By.xpath("//td[contains(text(),'Sale')]/following-sibling::td");

    private final By mer_BreakUpScreenFeeAmt =By.xpath("//td[contains(text(),'Sale')]/following-sibling::td");

    private final By mer_ProcessBtnTotalAmt =By.xpath("//*[contains(text(),'Process')]");

    private final By referencesField =By.xpath("//input[@name='referenceNum']");

    private final By description =By.xpath("//input[@formcontrolname='description']");

    private final By disclaimer =By.xpath("//input[@formcontrolname='disclaimer']");

    private final By clickSendPaymentBtn =By.xpath("//span[contains(text(),'Send Payment Link')]");

    private final By clickCloseBtn =By.xpath("//*[text()='Close']");

    private final By clickInvoices =By.xpath("//*[text()=' Invoices ']");

    private final By clickCopyLinkBtn =By.xpath("//*[contains(text(),'Copy Link')]");

    private final By clickCopyLinkBtnOnInvoice =By.xpath("(//*[contains(text(),'Copy Link')])[1]");

    private final By invoiceTotalAmount=By.xpath("(//h5[@class='mb-1'])[1]");

    private final By getStatus =By.xpath("(//*[@class='d-flex align-items-center flex-wrap text-nowrap']/span)[1]");

    private final By clickThreeDots =By.xpath("(//*[@id='dropdownMenuButton'])[1]");


    private final By isLinkGenerate =By.xpath("//h5[contains(text(),'Generate Payment Link')]");

    private final By expireTimeText =By.xpath("(//*[@formcontrolname='exipryTime']//span[2])");

    private final By clickQuickPay =By.xpath("//*[contains(text(),'Quick Pay')]");

    private final By clickPayNow =By.xpath("//*[contains(text(),'Pay now')]");

    private final By clickSale =By.xpath("//*[contains(text(),'Sale')]");

    private final By phoneField =By.xpath("//input[@id='phone']");

    private final By cardNumber =By.xpath("//input[@formcontrolname='cardNumber']");

    private final By expirationDate =By.xpath("//input[@formcontrolname='expDate']");

    private final By cvv =By.xpath("//input[@formcontrolname='cvv']");

    private final By clickcountrydropdown1 =By.xpath("(//div[@class='iti__selected-flag dropdown-toggle'])[1]");

    private final By zipcode =By.xpath("//input[@formcontrolname='zipCode']");

    private final By streetField =By.xpath("//*[@formcontrolname='street']");

    private final By clickProcessBtn =By.xpath("//button[contains(text(),'Process')]");

    private final By cloudposSuccessMsg =By.xpath("//h3[@class='text-muted mt-1 mb-3']");

    private final By getCustomFeeText =By.xpath("//*[@class='ml-3 custom-fee-body-width']/tr[2]/td[1]");

    private final By getCustomFeeTotal =By.xpath("//*[@class='ml-3 custom-fee-body-width']/tr[2]/td[2]");

    private final By getSaleTotalAmt =By.xpath("//p[@class='w-75 mx-auto mb-2 text-muted']/b[2]");

    private final By getTxType =By.xpath("//p[@class='w-75 mx-auto mb-2 text-muted']/b[1]");

    private final By getEmailId =By.xpath("//p[@class='w-75 mx-auto mb-2 text-muted ng-star-inserted'][1]/b");

    private final By getPaymentSuccessFullText =By.xpath("//h5[@class='ng-star-inserted']");

    private final By getResponseMsg =By.xpath("//p[@class='w-75 mx-auto mb-2 text-muted ng-star-inserted'][2]/b");

    private final By CardNumberField =By.xpath("//*[@name='cardNumber']");

    //PaymentForm xpath
    private final By expirationFormField =By.xpath("//input[@name='expDate']");

    private final By cardHolderName =By.xpath("//input[@id='cardHolderName']");

    private final By emailFormField =By.xpath("//*[@placeholder='Email']");

    private final By clickBreakDown =By.xpath("//*[@id='isPlus']");
    private final By closeBreakDown =By.xpath("//*[@id='isMinus']");


    private final By getFormTotalAmt =By.xpath("//b[@id='totalShowAmount']");

    private final By getFormSaleAmt =By.xpath("//*[@id='addedSaleAmount']");

    private final By getFormCustomFeeAmt =By.xpath("//*[@id='addedFeeAmount']");

    private final By getPayBtnTotalAmt =By.id("pay");

    private final By getCdTotalAmt =By.id("cdShowAmt");

    private final By clickPayBtn =By.id("pay");

    private final By isPaymentSuccess =By.xpath("//h4[@class='loading']");

    private final By getSuccessScreenTotalAmt =By.xpath("(//p)[1]");

    private final By getGetSuccessScreenEmail =By.xpath("(//p)[3]");

    private final By IsLinkExpired =By.xpath("//*[@class='landing-page']/h1");

    private final By isTipDisabled =By.xpath("(//*[contains(text(),'Tip')])[2]/following::div[@role='button'][2]");

    private final By isTaxDisabled =By.xpath("(//*[contains(text(),'Tax')])[2]/following::div[@role='button'][2]");

    private final By isFeeEnabled =By.xpath("(//p-selectbutton[@optionvalue='value'])[1]//div[@role='button'][1]");




    //Global variable
    String customfeeAmt;

    String pWindow;
    String cWindow;

    public String getpWindow() {
        return pWindow;

    }

    public String getcWindow() {
        return cWindow;
    }

    SoftAssert softAssert = new SoftAssert();



    public void verifyClickSteamlink() {
        String clickSteamlink=DynamicXpathUtils.getXpath(CustomXpath.menuLinkTxt,"S.T.E.A.M");
        click(By.xpath(clickSteamlink), WaitStrategy.CLICKABLE);
    }


    public void verifyClickEditParamLink() {
        click(clickEditParamLink,WaitStrategy.CLICKABLE);
    }

    public void verifyClickEditParamButton() throws InterruptedException {
        Thread.sleep(2000);
        click(clickEditParamButton,WaitStrategy.CLICKABLE);
    }

    public void verifySearchTpn(String tpn) throws InterruptedException {
        sendKeys(searchTpn,tpn.trim(),WaitStrategy.PRESENCE);
        Thread.sleep(1000);
        DriverManager.getDriver().findElement(searchTpn).sendKeys(Keys.ENTER);
    }


    /*public void verifySearchCloudPosTpn(String tpn) throws InterruptedException {

        try {
            Thread.sleep(2000);
            ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE,isTpnPreFilled).isDisplayed();
        }catch (Exception e){
            click(clickTpnSearch,WaitStrategy.CLICKABLE);
            Thread.sleep(2000);
            sendKeys(searchCloudPosTpn,tpn,WaitStrategy.CLICKABLE,Keys.ENTER);
        }
    }
*/

    public void verifySearchCloudPosTpn(String CloudPostpn) throws InterruptedException {
        searchCloudPosTpn(isTpnPreFilled,searchCloudPosTpn,CloudPostpn.trim(),WaitStrategy.CLICKABLE);
    }


    public void verifyClickValueSection(String value) throws InterruptedException {
        click(ClickvalueAdded,WaitStrategy.CLICKABLE);

        // String clickTagandTax =DynamicXpathUtils.getXpath(CustomXpath.ParamSection,"Tag the Tx");

        //String TagTxDisableBtn=DynamicXpathUtils.getXpath(CustomXpath.isBtnDisable,"Tag the Tx","Disable");

        /*boolean isTagTxBtnDisable=StringUtil.isBtnDisable(By.xpath(TagTxDisableBtn));

        if(isTagTxBtnDisable){
            System.out.println("Tag the Tx already Disabled");
        }else{
        */
        try {
            String clickTagTX=DynamicXpathUtils.getXpath(CustomXpath.listOfParamSwitchBtnXpath,"Tag the Tx");
            StringUtil.ClicklistofBtnByGetText(value,By.xpath(clickTagTX),DriverManager.getDriver());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void verifyClickTipTaxSection(){
        String tipAndTaxXpath=DynamicXpathUtils.getXpath(clickParamSection,"Tip & Taxes");
        try {
            click(By.xpath(tipAndTaxXpath), WaitStrategy.CLICKABLE);
        }catch (StaleElementReferenceException s){
            System.out.println("Stale element Exception on Click Fee Section");
        }
    }


    public void verifyClickFeeSection() throws InterruptedException {
        String clickFeesection =DynamicXpathUtils.getXpath(CustomXpath.ParamSection,"Fee");
        try{
            click(By.xpath(clickFeesection),WaitStrategy.CLICKABLE);
        }catch (StaleElementReferenceException s){
            System.out.println("Stale element Exception on Click Fee Section");
        }
    }



    public void verifyLogoutFromIso() {
        click(clickAvatarLogo,WaitStrategy.CLICKABLE);
        click(clickLogout,WaitStrategy.CLICKABLE);
    }


    private String fillQPayWithSendLinkCustomFeeParamInfo(Map<String,String> data) throws Exception {
        verifyClickSteamlink();
        verifyClickEditParamLink();

        verifySearchTpn(data.get("CustomFee TPN"));

        verifyClickEditParamButton();

        verifyClickTipTaxSection();

        verifyTipSetToNo(data);

        verifyTaxSetToNo(data);

        verifyClickFeeSection();

        verifyFeeEnable(data);

        click(By.xpath(DynamicXpathUtils.getXpath(CustomXpath.ParamRadioBtn,"Custom Fee")),WaitStrategy.CLICKABLE);

        click(clickFeeTypeSymbol,WaitStrategy.CLICKABLE);

        StringUtil.ClicklistofBtnByGetText(data.get("typePercentageOrDollar"),listOfFeeTypeSymbol,DriverManager.getDriver());

        sendKeys(percentageOfTxAmtField,data.get("Percentage Of Tx Amount"),WaitStrategy.VISIABLE);

        sendKeys(cappedAmtField,data.get("Capped At"),WaitStrategy.VISIABLE);

        String randNum=StringUtil.getRandomNumber();

        sendKeys(displayLabelField,data.get("DisplayLabel")+randNum,WaitStrategy.VISIABLE);

        StringUtil.ClicklistofBtnByGetText(data.get("DiscloseFee"),listOfDiscloseFeevalue,DriverManager.getDriver());

        verifyClickValueSection(data.get("ValueAdd"));


        String clickSaveBtn=DynamicXpathUtils.getXpath(CustomXpath.buttonXpath,"Save");
        click(By.xpath(clickSaveBtn),WaitStrategy.CLICKABLE);

        VerifyTpnIsOpenBatch();
        Thread.sleep(1000);
        // ExplicitWaitFactory.waitForTextToBePresent(isSuccessMsg,"Parameter Updated Successfully");

        // String successOrFailMsg =ExplicitWaitFactory.performExplicityWait(WaitStrategy.NONE,isSuccessMsg).getText();

        String successOrFailMsg = getTexts(isSuccessMsg,WaitStrategy.VISIABLE);

        click(clickOk,WaitStrategy.CLICKABLE);
        return successOrFailMsg;
    }

    public void verifyTipSetToNo(Map<String,String>data) throws InterruptedException {

        //If Tip Set already No , then don't need to FindElement ,
        // If Tip Set to Yes , then we need to FindElement ,and Set to YES.

        String IsTipsetToNO =DynamicXpathUtils.getXpath(CustomXpath.isBtnDisable,"Tip","No");
        System.out.println(IsTipsetToNO);
        boolean isTipDisable=StringUtil.isBtnDisable(By.xpath(IsTipsetToNO));
        System.out.println(isTipDisable);
        if(isTipDisable) {
            System.out.println("Already Tip disable");
        }
        else{
            Thread.sleep(1000);
            StringUtil.ClicklistofBtnByGetText(data.get("Tip"),
                    By.xpath(DynamicXpathUtils.getXpath(CustomXpath.listOfParamSwitchBtnXpath,"Tip")),
                    DriverManager.getDriver());
        }
    }

    public void verifyTaxSetToNo(Map<String,String>data) throws InterruptedException {

        //If Tax Set already No , then don't need to FindElement ,
        // If Tax Set to Yes , then we need to FindElement ,and Set to YES.

        String TaxDisableElement=DynamicXpathUtils.getXpath(CustomXpath.isBtnDisable,"Tax","No");

        boolean isTaxDisable=StringUtil.isBtnDisable(By.xpath(TaxDisableElement));

        if(isTaxDisable) {
            System.out.println("Already Tax disable");
        }
        else{
            Thread.sleep(1000);
            StringUtil.ClicklistofBtnByGetText(data.get("Tax"),
                    By.xpath(DynamicXpathUtils.getXpath(CustomXpath.listOfParamSwitchBtnXpath,"Tax")),
                    DriverManager.getDriver());
        }
    }

    public void verifyFeeEnable(Map<String,String>data) throws InterruptedException {

        //If Fee Set already Enable , then don't need to FindElement ,
        // If Fee Set to Disable , then we need to FindElement ,and Set to Enable.

        String FeeEnableElement=DynamicXpathUtils.getXpath(CustomXpath.isBtnDisable,"Fee","Enable");

        boolean isFeeEnable=StringUtil.isBtnDisable(By.xpath(FeeEnableElement));

        if(isFeeEnable) {
            System.out.println("Already Fee Enable");
        }
        else{
            Thread.sleep(1000);
            StringUtil.ClicklistofBtnByGetText(data.get("Fee"),
                    By.xpath(DynamicXpathUtils.getXpath(CustomXpath.listOfParamSwitchBtnXpath,"Fee")),
                    DriverManager.getDriver());
        }
    }

    public void verifyCustomFeeEnable(Map<String,String>data) throws InterruptedException {

        //If CustomFee Set already Enable , then don't need to FindElement,
        // If CustomFee Set to Disable , then we need to FindElement ,and Set to Enable.

        String FeeEnableElement=DynamicXpathUtils.getXpath(CustomXpath.isBtnDisable,"Fee","Enable");

        boolean isFeeEnable=StringUtil.isBtnDisable(By.xpath(FeeEnableElement));

        if(isFeeEnable) {
            System.out.println("Already Fee Enable");
        }
        else{
            Thread.sleep(1000);
            StringUtil.ClicklistofBtnByGetText(data.get("Fee"),
                    By.xpath(DynamicXpathUtils.getXpath(CustomXpath.listOfParamSwitchBtnXpath,"Fee")),
                    DriverManager.getDriver());
        }
    }

    private String fillQPaySendLinkOnCustomFee(Map<String,String>data) throws Exception {


        click(clickCloudPos,WaitStrategy.CLICKABLE);

        click(clickPayments,WaitStrategy.CLICKABLE);

        ExplicitWaitFactory.waitForTextToBePresent(clickSendLink,"Send Payment Link");

        click(clickSendLink,WaitStrategy.CLICKABLE);

        verifySearchCloudPosTpn(data.get("CustomFee TPN"));

        sendKeys(amtField,data.get("Amount"),WaitStrategy.VISIABLE);

        click(emailField,WaitStrategy.CLICKABLE);

        click(clickOkayBtn,WaitStrategy.CLICKABLE);

        String randEmail = StringUtil.getRandomAlphaNumericStringMinOrMax();

        sendKeys(emailField,randEmail + data.get("Email"),WaitStrategy.VISIABLE);

        sendKeys(referencesField,randEmail + data.get("References"),WaitStrategy.VISIABLE);

        setReferenceNum(randEmail+data.get("References"));

        String ExpireTime=verifyExpireTimeIsOneWeek();

        sendKeys(description,data.get("Description"),WaitStrategy.VISIABLE);

        sendKeys(disclaimer,data.get("Disclaimer"),WaitStrategy.VISIABLE);

        click(clickSendPaymentBtn,WaitStrategy.VISIABLE);

        click(clickCloseBtn,WaitStrategy.VISIABLE);

        goToInvoiceModule();

        searchReferenceNumber();

        verifyInvoiceStatusBeforeTx();

        verifyInvoiceTotalAmtBeforeTx(data);

        // verifyClickCopyLinkBtn();

        JavascriptExecutorUtil.doCopyPasteUrlOnNewWindow(DriverManager.getDriver());

        switchToChildWindow(DriverManager.getDriver(),data);

        fillSendLinkPaymentForm(data);

        Thread.sleep(2000);

        return null;
    }

    /*
     * This module will verify Sendlink Tx IsPresent invoice or Not
     * Search Reference
     * Verify Total Amount
     * Pending Status
     * And CopyLink From Three Dots.
     *
     */

    public QPayWithSendLinkOnCustomFeePage goToInvoiceModule(){
        click(clickInvoices,WaitStrategy.VISIABLE);
        return this;
    }

    public QPayWithSendLinkOnCustomFeePage searchReferenceNumber(){
        sendKeys(searchRef,getReferenceNum(),WaitStrategy.VISIABLE);
        return this;
    }

    public QPayWithSendLinkOnCustomFeePage clickTheRefreshBtn(){
    /*    try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        click(clickRefreshBtn,WaitStrategy.CLICKABLE);
        return this;
    }


    /**
     *
     * This method will Check Status If status Pending ity allow to CopyClick
     *
     *
     */
    public QPayWithSendLinkOnCustomFeePage verifyInvoiceStatusBeforeTx(){

        String isStatuspendingTxt = getTexts(getStatus,WaitStrategy.VISIABLE);
        if(isStatuspendingTxt.equalsIgnoreCase("Pending")){
            click(clickThreeDots,WaitStrategy.VISIABLE);
            click(clickCopyLinkBtnOnInvoice,WaitStrategy.VISIABLE);
        }else{
            try {
                throw new Exception("SendlinkInvoice Unavailable in the invoice module");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public void verifyInvoiceTotalAmtBeforeTx(Map<String,String>data){
        String invoiceTotalAmt=getTexts(invoiceTotalAmount,WaitStrategy.VISIABLE);
       String acutalTotalAmt =StringUtil.ExtractOnlyNumbers(invoiceTotalAmt);
       if(acutalTotalAmt.equalsIgnoreCase(data.get("Expected TotalAmt").trim())){
           System.out.println("Amount Exact Match");
       }else{
           try {
               throw new Exception("Before Tx Amount Not Match");
           } catch (Exception e){
               e.printStackTrace();
           }
       }
    }

    public void verifyInvoiceTotalAmtAfterTx(Map<String,String>data){
        boolean falg = false;
        String invoiceTotalAmt=getTexts(invoiceTotalAmount,WaitStrategy.VISIABLE);
        String acutalTotalAmt =StringUtil.ExtractOnlyNumbers(invoiceTotalAmt);
        if(acutalTotalAmt.equalsIgnoreCase(data.get("Expected TotalAmt").trim())){
            falg=true;
            System.out.println("Invoice Amount Exact Match,After the tx completed");
        }else{
            try {
                throw new Exception("Before Tx Amount Not Match");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public QPayWithSendLinkOnCustomFeePage verifyInvoiceStatusAfterTx() throws InterruptedException {
        Thread.sleep(2000);
        String isStatuspendingTxt = getTexts(getStatus,WaitStrategy.VISIABLE);
        if(isStatuspendingTxt.equalsIgnoreCase("Success")){
            System.out.println("Payment Status Exact Match");
        }else{
            try {
                throw new Exception("Failure to Change From Pending Status to Success");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public void verifyBreakUpScreenOnMerchantView(Map<String,String>data) throws Exception {

        String actualTotalAmt=verifyTotalAmtOnMer_BreakUpScreen();
        softAssert.assertEquals(actualTotalAmt,data.get(""),"");

        String actualSaleAmt= verifySaleAmtOnMer_BreakUpScreen();
        softAssert.assertEquals(actualSaleAmt,data.get("Expected BaseAmt"),"");

        String actualFeeAmt= verifyFeeAmtOnMer_BreakUpScreen();
        softAssert.assertEquals(actualFeeAmt,data.get("Expected FeeAmt"),"");
    }

    public String verifyTotalAmtOnMer_BreakUpScreen(){
        ExplicitWaitFactory.waitForTextToBePresent(mer_BreakUpScreenTotalAmt,"Total");
        String actualTotalAmt;
        WebElement getActualTotalAmt=ExplicitWaitFactory.performExplicityWait(WaitStrategy.NONE,mer_BreakUpScreenTotalAmt);
        actualTotalAmt =getActualTotalAmt.getText();
        return StringUtil.ExtractOnlyNumbers(actualTotalAmt);
    }

    public String verifySaleAmtOnMer_BreakUpScreen() throws Exception {
        ExplicitWaitFactory.waitForTextToBePresent(mer_BreakUpScreenSaleAmt,"Break Up");
        String  actualSaleAmt= getTexts(mer_BreakUpScreenSaleAmt,WaitStrategy.VISIABLE);
        return StringUtil.ExtractOnlyNumbers(actualSaleAmt);
    }

    public String verifyFeeAmtOnMer_BreakUpScreen() throws Exception {
        ExplicitWaitFactory.waitForTextToBePresent(mer_BreakUpScreenFeeAmt,"Break Up");
        String actualFeeAmt =getTexts(mer_BreakUpScreenSaleAmt,WaitStrategy.VISIABLE);
        return StringUtil.ExtractOnlyNumbers(actualFeeAmt);
    }

    public String verifyTotalAmtOnMer_ProcessBtn() throws Exception {
        String actualTotalAmt =getTexts(mer_ProcessBtnTotalAmt,WaitStrategy.VISIABLE);
        return StringUtil.ExtractOnlyNumbers(actualTotalAmt);
    }


    public  QPayWithSendLinkOnCustomFeePage switchToParentWindow(WebDriver driver) {
        String childWindow = driver.getWindowHandle();
        String MainWindow = null;
        Set<String> allWindows = driver.getWindowHandles();

        for (String currentWindow : allWindows) {
            if (!currentWindow.equalsIgnoreCase(childWindow)) {
                MainWindow = currentWindow;
                driver.close();
                driver.switchTo().window(MainWindow);
                break;
            }
        }
        return this;
    }
    public void switchToChildWindow (WebDriver driver, Map < String, String > data) throws InterruptedException {
        //Get handles of the windows
        String parentWindowHandle = driver.getWindowHandle();
        pWindow = parentWindowHandle;
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String ChildWindow : allWindowHandles) {
            if (!parentWindowHandle.equalsIgnoreCase(ChildWindow)) {
                cWindow = ChildWindow;
                driver.switchTo().window(ChildWindow);
            }
        }
    }

    public void fillSendLinkPaymentForm(Map<String,String>data) throws Exception {

        verifyFormTotalAmt();
        verifyClickBreakUpScreenForm();

        Thread.sleep(2000);

        sendKeys(CardNumberField,data.get("CardNumber"),WaitStrategy.VISIABLE);
        sendKeys(expirationFormField,data.get("Expiration"),WaitStrategy.VISIABLE);

    }


/*
JavascriptExecutor js = (JavascriptExecutor) driver;
        String emailValue= (String) js.executeScript("document.getElementById('emailInput').value;", emailFormField);
        System.out.println(emailValue);

*/


    public static String getReferenceNum() {
        return ReferenceNum;
    }

    public void setReferenceNum(String ref){
        ReferenceNum=ref;
    }

    public String verifyFormTotalAmt() throws Exception {
        String actualTotalAmt= getTexts(getFormTotalAmt,WaitStrategy.VISIABLE);
        return StringUtil.ExtractOnlyNumbers(actualTotalAmt);
    }

    public String verifyFormSaleAmt() throws Exception {
        return getTexts(getFormSaleAmt,WaitStrategy.VISIABLE);
    }

    public String verifyFormCustomFeeAmt(){
        String getCustFee=null;
        try {
            getCustFee=getTexts(getFormCustomFeeAmt, WaitStrategy.VISIABLE);
        }catch (Exception e){
            System.out.println("");
        }
        return getCustFee;
    }

    public String verifyTotalAmtOnPayBtn() throws Exception {
        String  actualTotalAmt =getTexts(getPayBtnTotalAmt,WaitStrategy.VISIABLE);
        return StringUtil.ExtractOnlyNumbers(actualTotalAmt);
    }

    //Credit/Debit=CD
    public String verifyCDTotalAmt() throws Exception {
        String  actualTotalAmt =getTexts(getCdTotalAmt,WaitStrategy.VISIABLE);
        return StringUtil.ExtractOnlyNumbers(actualTotalAmt);
    }

    public void verifyClickPayBtn(){
        click(clickPayBtn,WaitStrategy.CLICKABLE);
    }

    public void verifyClickBreakUpScreenForm() throws InterruptedException {
        //Open BreakUpScreen On Sendlink Form
        Thread.sleep(1000);
        click(clickBreakDown,WaitStrategy.CLICKABLE);
    }

    public void verifyCloseBreakUpScreenForm() {
        //Close BreakUpScreen On Sendlink Form
        click(closeBreakDown,WaitStrategy.CLICKABLE);
    }


    public String verifySuccessScrnTotalAmt() throws Exception {
        return getTexts(getSuccessScreenTotalAmt,WaitStrategy.VISIABLE);
        //Your Sale Transaction of $0.33 has been processed successfully.
    }
    public String verifySuccessScreenEmail() throws Exception {
        return getTexts(getGetSuccessScreenEmail,WaitStrategy.VISIABLE);  //Receipt has been sent to: bm@denovosystme.com
    }

    public String verifyIsPaymentSuccess() throws Exception {
        ExplicitWaitFactory.waitForTextToBePresent(isPaymentSuccess,"Payment Successfull");
        Thread.sleep(2000);
        return getTexts(isPaymentSuccess,WaitStrategy.VISIABLE);
    }

    public void verifyClickCopyLinkBtn () {
        try {
            click(clickCopyLinkBtn,WaitStrategy.VISIABLE);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Payment Failed or Link not Generated");
        }
    }


    public String verifyQPayWithSendLinkOnCustomFeeParamInfo (Map<String,String>data) throws Exception {
        return fillQPayWithSendLinkCustomFeeParamInfo(data);
    }

    public String verifyQPayWithSendLinkOnCustomFee(Map<String,String>map) throws Exception {
        return fillQPaySendLinkOnCustomFee(map);
    }


    private String verifyExpireTimeIsOneWeek() throws Exception {
        return  getTexts(expireTimeText,WaitStrategy.VISIABLE);
    }


    public void generateRandomEmail (Map<String,String>data){
        String randEmail = StringUtil.getRandomAlphaNumericStringMinOrMax();
        sendKeys(emailField,randEmail+data.get("Email"),WaitStrategy.VISIABLE);
    }


/*
 *
    public void VerifyTpnIsOpenBatch(){

        try {
            ExplicitWaitFactory.waitForTextToBePresent(OpenBatchMsg,"Please settle the batch to edit the Fee Section");
            if (ExplicitWaitFactory.performExplicityWait(WaitStrategy.NONE,OpenBatchMsg).isDisplayed()){
                click(clickGoToSettleBatch,WaitStrategy.CLICKABLE);
                click(clickSettleBatch,WaitStrategy.CLICKABLE);
                click(clickConfirm,WaitStrategy.CLICKABLE);
                click(clickClose,WaitStrategy.CLICKABLE);
                click(clickSaveBtn,WaitStrategy.CLICKABLE);
            }
        }catch (Exception e){
            System.out.println("Open Batch Not Found");
        }
    }*/


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

    public void doRefreshTheScreen(){
        DriverManager.getDriver().navigate().refresh();
    }

    public String verifyExpireScreen() throws Exception {
        // WebElement getLinkExpiredTxt=ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE,IsLinkExpired);
        return getTexts(IsLinkExpired,WaitStrategy.VISIABLE);
    }

}
