package com.denovo.Pages;

import com.denovo.Base.TestBase;
import com.denovo.Util.JavascriptExecutorUtil;
import com.denovo.Util.StringUtil;
import com.denovo.Util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SteamDevicePage extends TestBase {

    @FindBy(xpath = "//*[text()='STEAM']")
    WebElement clickSteam;

    @FindBy(xpath = "//a[contains(text(),'Device')]")
    WebElement clickDevice;

    @FindBy(xpath = "(//*[@id='dropdownMenuButton'])[1]")
    WebElement clickDotIcon;

    @FindBy(xpath = "//*[@class='dropdown-menu show']")
    WebElement clickEditParam;

    @FindBy(xpath = "//*[@id='p-accordiontab-0']")
    WebElement closeReceipt;

    @FindBy(xpath = "//input[@id='exampleInputUsername1' and @placeholder='Please Enter Header 1']")
    WebElement header1;

    @FindBy(xpath = "//input[@id='exampleInputUsername1' and @placeholder='Please Enter Header 2']")
    WebElement header2;

    @FindBy(xpath = "//input[@id='exampleInputUsername1' and @placeholder='Please Enter Header 3']")
    WebElement header3;

    @FindBy(xpath = "//input[@id='exampleInputUsername1' and @placeholder='Please Enter Header 4']")
    WebElement header4;


    @FindBy(xpath = "//*[@class='input-group ng-star-inserted']/textarea")
    WebElement disclaimer;

    @FindBy(xpath = "//*[@name='MR_C' and @value='1']")
    WebElement printRadioBtn;

    @FindBy(xpath = "//*[@name='MR_C' and @value='2']")
    WebElement dontPrintRadioBtn;

    @FindBy(xpath = "//input[@type='checkbox' and @value='1']")
    WebElement smsCheckBox;

    @FindBy(xpath = "//input[@type='checkbox' and @value='2']")
    WebElement emailCheckBox;

    @FindBy(xpath = "//input[@type='checkbox' and @value='3']")
    WebElement paperCheckbox;

    @FindBy(xpath = "(//*[@class='ng-star-inserted'])[4]//div[@class='p-hidden-accessible']/input")
    List<WebElement> merchantCopy;

    @FindBy(xpath = "(//*[@class='ng-star-inserted'])[5]//div[@class='p-field-checkbox ng-star-inserted']//label")
    List<WebElement> customerCopy;

    @FindBy(xpath = "//a[@id='p-accordiontab-1']")
    WebElement openTipandTax;

    @FindBy(xpath = "//p-selectbutton[@ng-reflect-name='TIP']//div[@role='button']/span")
    List<WebElement> tip;

    @FindBy(xpath = "//p-selectbutton[@ng-reflect-name='TAX']//span")
    List<WebElement> tax;

    @FindBy(xpath = "//p-selectbutton[@ng-reflect-name='TS_PAP']//span")
    List<WebElement> tipsuggestionPaper;

    @FindBy(xpath = "//p-selectbutton[@ng-reflect-name='TS_POS']//span")
    List<WebElement> tipsuggestionPOS;

    @FindBy(xpath = "(//*[@id='p-fieldset-2']//*[@type='number'])[1]")
    WebElement sug_Field1;

    @FindBy(xpath = "(//*[@id='p-fieldset-2']//*[@type='number'])[2]")
    WebElement sug_Field2;

    @FindBy(xpath = "(//*[@id='p-fieldset-2']//*[@type='number'])[3]")
    WebElement sug_Field3;

    @FindBy(xpath = "(//*[@id='p-fieldset-2']//*[@type='number'])[4]")
    WebElement sug_Field4;

    @FindBy(xpath = "(//*[@id='exampleInputUsername1'])[9]")
    WebElement maxTPAllowed;

    @FindBy(xpath = "(//*[@id='exampleInputUsername1'])[10]")
    WebElement maxTPHigher;


    @FindBy(xpath = "(//*[@id='exampleInputUsername1'])[11]")
    WebElement stax;

    @FindBy(xpath = "(//*[@id='exampleInputUsername1'])[12]")
    WebElement ltax;

    @FindBy(xpath = "//*[@id='p-accordiontab-2']")
    WebElement openTx;

    @FindBy(xpath = "//p-fieldset[@ng-reflect-legend='Tx Type']//div[@class='panel_body ng-star-inserted']//label")
    List<WebElement> listofTxtype;

    @FindBy(xpath = "//*[@id='p-fieldset-5-content']//*[@class='p-field-radiobutton ng-star-inserted']//input")
    List<WebElement> listofAvs;

    @FindBy(xpath = "(//*[@class='ng-star-inserted'])[7]//p-checkbox//label")
    List<WebElement> listofCard;

    @FindBy(xpath = "(//a[@tabindex='0'])[10]")
    WebElement cardIndex;

    @FindBy(xpath = "(//*[@class='ng-star-inserted'])[8]//p-checkbox//label")
    List<WebElement>listofCardschemes;

    @FindBy(xpath = "//p-selectbutton[@ng-reflect-name='MKE']//div[@role='button']//span")
    List<WebElement>listofManualEntrykey;


    @FindBy(xpath = "//p-selectbutton[@ng-reflect-name='MCVV']//div[@role='button']//span")
    List<WebElement>listofMandatorycvv;

    @FindBy(xpath = "//*[@id='p-fieldset-8-content']//input[@name='SL']")
    List<WebElement>listofSL;

    @FindBy(xpath = "(//a[@tabindex='0'])[8]")
    WebElement txtypeindex;

    @FindBy(xpath = "//*[@id='p-fieldset-9-content']//*[@class='p-field-radiobutton ng-star-inserted']//input")
    List<WebElement> listofsettle_mode;

    @FindBy(xpath = "(//*[@class='ngb-tp-input form-control'])[1]")
    WebElement HH;

    @FindBy(xpath = "(//*[@class='ngb-tp-input form-control'])[2]")
    WebElement MM;

    @FindBy(xpath = "//button[@class='btn btn-outline-primary']")
    WebElement setAmorPm;

    @FindBy(xpath = "(//*[@class='ng-star-inserted'])[11]//input")
    List<WebElement>listofPrintReport;

    @FindBy(xpath = "//*[@ng-reflect-name='RT']")
    WebElement retrytimes;

    @FindBy(xpath = "//*[@ng-reflect-name='RM']")
    WebElement retryminutes;

    @FindBy(xpath = "//*[@id='p-accordiontab-3']")
    WebElement opensettlement;

    @FindBy(xpath = "//*[@id='p-accordiontab-4']")
    WebElement openFee;

    @FindBy(xpath = "//p-selectbutton[@ng-reflect-name='FEE']//div[@role='button']/span")
    List<WebElement>listofFeeSwtichBtn;

    @FindBy(xpath = "(//p-selectbutton[@ng-reflect-name='FEE']//div[@role='button'])/span[1]")
    WebElement clickEnable;

    @FindBy(xpath = "(//p-radiobutton[@ng-reflect-name='F_TYP'])[1]//input")
    WebElement clickCustomfeeRadiobtn;


    @FindBy(xpath = "//ng-select[@bindvalue='value']//span[@class='ng-arrow-wrapper']")
    WebElement clickCustomFeeCombobox;

    @FindBy(xpath = "//*[@role='listbox']//*[@role='option']//span")
     List<WebElement> listoftypesymbol;

    @FindBy(xpath = "//*[@ng-reflect-name='CF_AMT']")
    WebElement customFeeAmt;

    @FindBy(xpath = "//*[@ng-reflect-name='CF_TX_AMT']")
    WebElement cappedAmt;

    @FindBy(xpath = "//*[@ng-reflect-name='CF_DL']")
    WebElement displaylabel;


    @FindBy(xpath = "(//p-selectbutton[@optionvalue='value'])[8]//div[@role='button']//span")
    List<WebElement>listofCustomFeeDFC;

    @FindBy(xpath = "(//p-selectbutton[@optionvalue='value'])[9]//div[@role='button']//span")
    List<WebElement>listofCustomFeeAFT;

    @FindBy(xpath = "(//p-selectbutton[@optionvalue='value'])[10]//div[@role='button']//span")
    List<WebElement>listofCustomFeeMRF;

    @FindBy(xpath = "(//p-selectbutton[@optionvalue='value'])[11]//div[@role='button']//span")
    List<WebElement>listofcustomFeeAFDC;

    @FindBy(xpath = "(//p-selectbutton[@optionvalue='value'])[12]//div[@role='button']//span")
    List<WebElement>listofCustomFeePPRO;

    @FindBy(xpath = "(//p-radiobutton[@ng-reflect-name='F_TYP'])[2]//input")
    WebElement clickSur_FeeRadioBtn;

     @FindBy(xpath = "(//ng-select[@bindvalue='value']//span[@class='ng-arrow-wrapper'])[1]")
     WebElement clickSur_Feecombobox1;

    @FindBy(xpath = "//*[@ng-reflect-name='SR_AMT_C']")
    WebElement clickSur_FeeAmtfield;

    @FindBy(xpath = "//*[@ng-reflect-name='SR_TX_AMT']")
    WebElement clickSur_FeeCappedAmtfield;

    @FindBy(xpath = "//*[@ng-reflect-name='SR_DL_C']")
    WebElement clickSur_FeeDLCC;

    @FindBy(xpath = "(//ng-select[@bindvalue='value']//span[@class='ng-arrow-wrapper'])[2]")
    WebElement clickSur_Feecombobox2;

    @FindBy(xpath = "(//p-selectbutton[@optionvalue='value'])[8]//div[@role='button']//span")
    List<WebElement>listofSur_FeeDFC;

    @FindBy(xpath = "(//p-selectbutton[@optionvalue='value'])[9]//div[@role='button']//span")
    List<WebElement>listofSur_FeeAST;

    @FindBy(xpath = "(//p-selectbutton[@optionvalue='value'])[10]//div[@role='button']//span")
    List<WebElement>listofSur_FeeMRF;

    @FindBy(xpath = "(//p-selectbutton[@optionvalue='value'])[11]//div[@role='button']//span")
    List<WebElement>listofSur_FeePPRO;


    @FindBy(xpath = "//*[@ng-reflect-name='SR_AMT_D']")
    WebElement clickSur_FeeDCtxAmt;

    @FindBy(xpath = "//*[@ng-reflect-name='SR_DL_D']")
    WebElement clickSur_FeeDldc;


    @FindBy(xpath = "(//p-radiobutton[@ng-reflect-name='F_TYP'])[3]//input")
    WebElement clickDtiRadioBtn;

    @FindBy(xpath = "(//ng-select[@bindvalue='value']//span[@class='ng-arrow-wrapper'])[1]")
    WebElement clickDticombobox3;

    @FindBy(xpath = "(//p-selectbutton[@optionvalue='value'])[8]//div[@role='button']//span")
    List<WebElement>listofDtisvcDc;

   @FindBy(xpath = "//*[@ng-reflect-name='D_AMT_CR']")
   WebElement clickDtiAmt;


    @FindBy(xpath = "(//ng-select[@bindvalue='value']//span[@class='ng-arrow-wrapper'])[1]")
    WebElement clickDtiCombobox1;

    @FindBy(xpath = "//*[@ng-reflect-name='D_AMT_DDA']")
    WebElement clickDtiDscnt;

    @FindBy(xpath = "(//p-selectbutton[@optionvalue='value'])[9]//div[@role='button']//span")
    List<WebElement>listofDtiFeeontip;

    @FindBy(xpath = "(//ng-select[@bindvalue='value']//span[@class='ng-arrow-wrapper'])[2]")
    WebElement clickDtiCombobox2;


    public SteamDevicePage() {
        PageFactory.initElements(TestBase.driver, this);
    }



    public void verifyClickSteamlink() {
        clickSteam.click();
        verifyClickDevicelink();
        verifyClickDotIcon();
        verifyClickEditParams();
    }

    public void verifyClickDevicelink() {
        clickDevice.click();
    }

    public void verifyClickDotIcon() {
        clickDotIcon.click();
    }

    public void verifyClickEditParams() {
        clickEditParam.click();
    }

    public void verifySetReceipt(String h1, String h2, String h3, String h4, String dis, String value, String value2) throws InterruptedException {

        header1.clear();
        header1.sendKeys(h1);

        header2.clear();
        header2.sendKeys(h2);

        header3.clear();
        header3.sendKeys(h3);

        header4.clear();
        header4.sendKeys(h4);

        disclaimer.clear();
        disclaimer.sendKeys(dis);

        setMerchantCopy(value);

        //unClick SmsCheckbox
        JavascriptExecutorUtil.clickPrintChoices(driver, smsCheckBox);
        Thread.sleep(1000);

        //unClick emailCheckBox
        JavascriptExecutorUtil.clickPrintChoices(driver, emailCheckBox);
        Thread.sleep(1000);


        Thread.sleep(3000);
        setCustomerCopy(value2);


        //scrollpageup
        Thread.sleep(1000);
        JavascriptExecutorUtil.scrollPageUp(driver);

        Thread.sleep(2000);
        closeReceipt.click();
    }

    public void setMerchantCopy(String value) {

        for (WebElement els : merchantCopy) {
            if (els.getAttribute("value").equalsIgnoreCase(value)) {
                System.out.println(els.getAttribute("value"));
                JavascriptExecutorUtil.clickPrintChoices(driver, els);
                break;
            }
        }
    }

    public void setCustomerCopy(String value) {
        String arr[] = value.split(":");
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (WebElement els : customerCopy) {
                if (els.getText().equalsIgnoreCase(arr[i])) {
                    flag = true;
                    els.click();
                }
            }
        }
        if (flag == false) {
            System.out.println("Element not Fount");
        }
    }


    public void verifySetTipandTax(String Tip, String TipSugPap, String TipSugPos,
                                   String Sugfield1, String Sugfield2, String Sugfield3, String Sugfield4, String MaxTPAllow, String MaxTPHigh, String Tax, String stateTax, String localTax) throws InterruptedException {

        Thread.sleep(4000);
        openTipandTax.click();

        Thread.sleep(3000);
        SetTip(Tip);

        Thread.sleep(3000);
        setTipSug_Pap(TipSugPap);

        Thread.sleep(3000);
        setTipSug_Pos(TipSugPos);

        sug_Field1.clear();
        sug_Field1.sendKeys(Sugfield1);

        sug_Field2.clear();
        sug_Field2.sendKeys(Sugfield2);

        sug_Field3.clear();
        sug_Field3.sendKeys(Sugfield3);

        sug_Field4.clear();
        sug_Field4.sendKeys(Sugfield4);


        maxTPAllowed.clear();
        maxTPAllowed.sendKeys(MaxTPAllow);

        maxTPHigher.clear();
        maxTPHigher.sendKeys(MaxTPHigh);

        setTax(Tax);

        stax.clear();
        stax.sendKeys(stateTax);

        ltax.clear();
        ltax.sendKeys(localTax);
        Thread.sleep(3000);
        JavascriptExecutorUtil.scrollPageUp(driver);

        //close TipandTax
        openTipandTax.click();

    }

    public void verifySetTransaction(String TxType,String Avs,String CardType,String CardSchemes,
                                     String ManualKeyEntry,String MandatoryCVV,String SignatureLine) throws InterruptedException {

       // closeReceipt.click();
        Thread.sleep(2000);

        openTx.click();
       // JavascriptExecutorUtil.ScrollByVisibleElement(driver,txtypeindex);//
        JavascriptExecutorUtil.scrollPageUp(driver);
        setTxType(TxType);

        setAvs(Avs);
        JavascriptExecutorUtil.ScrollByVisibleElement(driver,cardIndex);

        Thread.sleep(2000);
        setCardType(CardType);

        Thread.sleep(2000);
        setCardSchemes(CardSchemes);

        setManualkeyEntry(ManualKeyEntry);
        Thread.sleep(2000);
        setMandatorycvv(MandatoryCVV);

        JavascriptExecutorUtil.scrollDownUp(driver);
        setSignatureLine(SignatureLine);

        //JavascriptExecutorUtil.scrollPageUp(driver);

        //close Tx
        //openTx.click();

    }


    public void SetTip(String value) {

        for (WebElement listofBtn : tip) {
            if (listofBtn.getText().equalsIgnoreCase(value)) {
                listofBtn.click();
                break;
            }
        }
    }

    public void setTax(String value) {

        for (WebElement listofBtn : tax) {
            if (listofBtn.getText().equalsIgnoreCase(value)) {
                listofBtn.click();
                break;
            }
        }
    }

    public void setTipSug_Pap(String value) {

        for (WebElement listofBtn : tipsuggestionPaper) {
            if (listofBtn.getText().equalsIgnoreCase(value)) {
                System.out.println(listofBtn.getText());
                listofBtn.click();
                break;
            }
        }
    }

    public void setTipSug_Pos(String value) {

        for (WebElement listofBtn : tipsuggestionPOS) {
            if (listofBtn.getText().equalsIgnoreCase(value)) {
                listofBtn.click();
                break;
            }
        }
    }

    public void setTxType(String value) throws InterruptedException {

        //Tx type
        String arr[] = value.split(",");
        boolean flag = false;
        for (String str : arr) {
            for (WebElement ele : listofTxtype) {
                Thread.sleep(1000);
                if (ele.getText().equalsIgnoreCase(str)) {
                    flag = true;
                    ele.click();
                    break;
                }
            }
        }
        if (flag == false) {
            System.out.println("element not found");
        }
    }

    public void setAvs(String value) throws InterruptedException {
        boolean flag = false;
        for (WebElement avs : listofAvs) {
            if (avs.getAttribute("value").equalsIgnoreCase(value)) {
                flag = true;
                JavascriptExecutorUtil.clickElementByJs(driver, avs);
                break;
            }
        }
        if (flag == false) {
            System.out.println("element not found");
        }
    }

    public void setCardType(String cardType) {

        String arr[] = cardType.split(",");
        for (int i = 0; i < arr.length; i++) {
            for (WebElement ele : listofCard) {
                if (ele.getText().equalsIgnoreCase(arr[i])) {
                    //multiselect
                    ele.click();
                    break;
                }
            }
        }
    }
    public void setCardSchemes(String value) {
        String arr[] = value.split(",");
        for (int i = 0; i < arr.length; i++) {
            for (WebElement ele : listofCardschemes) {
                if (ele.getText().equalsIgnoreCase(arr[i])) {
                    //multiselect
                    ele.click();
                    break;
                }
            }
        }
    }

    public void setManualkeyEntry(String value) {

        for (WebElement listofBtn :listofManualEntrykey) {
            if (listofBtn.getText().equalsIgnoreCase(value)) {
                listofBtn.click();
                break;
            }
        }
    }

    public void setMandatorycvv(String value){
        for (WebElement listofBtn :listofMandatorycvv) {
            if (listofBtn.getText().equalsIgnoreCase(value)) {
                listofBtn.click();
                break;
            }
        }
    }

    public void setSignatureLine(String value){
        boolean flag = false;
        for (WebElement sl : listofSL) {
            if (sl.getAttribute("value").equalsIgnoreCase(value)) {
                flag = true;
                JavascriptExecutorUtil.clickElementByJs(driver, sl);
                break;
            }
        }
        if (flag == false) {
            System.out.println("element not found");
        }
    }

    public void verifysetSettlement(String SettlementMode,String Set_Time_HH,String Set_Time_MM,String Set_Time_Day,
                              String PrintReport,String Retry,String EveryMinutes) throws InterruptedException {

        opensettlement.click();
        Thread.sleep(2000);

        JavascriptExecutorUtil.scrollDownUp(driver);

        setSettlementmode(SettlementMode);

        HH.clear();
        HH.sendKeys(Set_Time_HH);
        Thread.sleep(2000);
        MM.clear();
        MM.sendKeys(Set_Time_MM);
        Thread.sleep(2000);
        setAmPm(Set_Time_Day);

        Thread.sleep(2000);
        setPrintReport(PrintReport);
        JavascriptExecutorUtil.scrollDownUp(driver);
        Thread.sleep(2000);
        retrytimes.sendKeys(Retry);
        retryminutes.sendKeys(EveryMinutes);
        JavascriptExecutorUtil.scrollPageUp(driver);

        //close settlement
        opensettlement.click();

    }

    public void verifySetCustomFee(String Fee,String FeeType_Custom,String Typesysmbol,String CustomfeeAmount,
                                String CappedPercent,String DisplayLabel,String DiscloseFeetoCustomer,
                                String ApplyFeeOnTip,String MerchantCanRemoveFee,String ApplyFeeOnDebitCard,
                                String PasswordProtectRemove) throws InterruptedException{

       //closeReceipt.click();
        Thread.sleep(2000);

        openFee.click();
        //scroll down
        JavascriptExecutorUtil.scrollDownUp(driver);
        //wait
        Thread.sleep(3000);
        StringUtil.ClicklistofBtnByGetText(Fee,listofFeeSwtichBtn,driver);

        //scroll down
        JavascriptExecutorUtil.scrollDownUp(driver);

        StringUtil.ClickRadioBtnByValue(FeeType_Custom,clickCustomfeeRadiobtn,driver);

        clickCustomFeeCombobox.click();
        Thread.sleep(2000);

        StringUtil.ClicklistofBtnByGetText(Typesysmbol,listoftypesymbol,driver);


        customFeeAmt.clear();
        customFeeAmt.sendKeys(CustomfeeAmount);

        Thread.sleep(1000);
        cappedAmt.clear();
        cappedAmt.sendKeys(CappedPercent);

        Thread.sleep(1000);
        displaylabel.clear();
        displaylabel.sendKeys(DisplayLabel);


        //scrolldown
        JavascriptExecutorUtil.scrollDownUp(driver);
        Thread.sleep(2000);

        StringUtil.ClicklistofBtnByGetText(DiscloseFeetoCustomer,listofCustomFeeDFC,driver);
        Thread.sleep(2000);

        StringUtil.ClicklistofBtnByGetText(ApplyFeeOnTip,listofCustomFeeAFT,driver);

        JavascriptExecutorUtil.scrollDownUp(driver);
        Thread.sleep(1000);

        StringUtil.ClicklistofBtnByGetText(MerchantCanRemoveFee,listofCustomFeeMRF,driver);

        JavascriptExecutorUtil.scrollDownUp(driver);
        Thread.sleep(2000);

        StringUtil.ClicklistofBtnByGetText(ApplyFeeOnDebitCard,listofcustomFeeAFDC,driver);

        StringUtil.ClicklistofBtnByGetText(PasswordProtectRemove,listofCustomFeePPRO,driver);

        JavascriptExecutorUtil.scrollPageUp(driver);
        Thread.sleep(2000);

    }
    public void verifySetSurchargeFee(String FeeType_SurchargeFee,String Typesymbol,String Surchargefee,String CappedPercent,
                                      String DisplayLabel,String DiscloseFeetoCustomer,
                                      String ApplyFeeOnTip,String MerchantCanRemoveFee,
                                      String PasswordProtectRemove,String Typesymbol2,String DCTxAmt,String DLDC) throws InterruptedException {

      /*  closeReceipt.click();

        Thread.sleep(2000);
        openFee.click();

        clickEnable.click();

        //scroll down
        JavascriptExecutorUtil.scrollDownUp(driver);

        //wait
        Thread.sleep(1000);
*/

        StringUtil.ClickRadioBtnByValue(FeeType_SurchargeFee,clickSur_FeeRadioBtn,driver);



        Thread.sleep(2000);
        clickSur_Feecombobox1.click();

        StringUtil.ClicklistofBtnByGetText(Typesymbol,listoftypesymbol,driver);

        clickSur_FeeAmtfield.clear();
        clickSur_FeeAmtfield.sendKeys(Surchargefee);

        clickSur_FeeCappedAmtfield.clear();
        clickSur_FeeCappedAmtfield.sendKeys(CappedPercent);

        clickSur_FeeDLCC.clear();
        clickSur_FeeDLCC.sendKeys(DisplayLabel);

        JavascriptExecutorUtil.scrollDownUp(driver);
        Thread.sleep(2000);

        StringUtil.ClicklistofBtnByGetText(DiscloseFeetoCustomer,listofSur_FeeDFC,driver);

        StringUtil.ClicklistofBtnByGetText(ApplyFeeOnTip,listofSur_FeeAST,driver);
        Thread.sleep(1000);

        StringUtil.ClicklistofBtnByGetText(MerchantCanRemoveFee,listofSur_FeeMRF,driver);
        Thread.sleep(1000);
        StringUtil.ClicklistofBtnByGetText(PasswordProtectRemove,listofSur_FeePPRO,driver);

        clickSur_Feecombobox2.click();
        StringUtil.ClicklistofBtnByGetText(Typesymbol2,listoftypesymbol,driver);

        Thread.sleep(2000);
        clickSur_FeeDCtxAmt.clear();
        clickSur_FeeDCtxAmt.sendKeys(DCTxAmt);

        clickSur_FeeDldc.clear();
        clickSur_FeeDldc.sendKeys(DLDC);
        Thread.sleep(2000);

        JavascriptExecutorUtil.scrollPageUp(driver);
        Thread.sleep(1000);
    }


    public void verifySetDti(String FeeType_DTI,String Typesymbol,String DtiAmt,String SVConDebitcard,
                             String FeeOnTip,String DiscountType,
                             String DiscountAmount) throws InterruptedException {
/*

        closeReceipt.click();
        Thread.sleep(2000);

        openFee.click();
        clickEnable.click();


 */

        StringUtil.ClickRadioBtnByValue(FeeType_DTI,clickDtiRadioBtn,driver);

      //  JavascriptExecutorUtil.scrollDownUp(driver);

       // Thread.sleep(2000);

        clickDtiCombobox1.click();

        StringUtil.ClicklistofBtnByGetText(Typesymbol,listoftypesymbol,driver);
        Thread.sleep(1000);
        clickDtiAmt.clear();
        clickDtiAmt.sendKeys(DtiAmt);

        Thread.sleep(3000);

        JavascriptExecutorUtil.scrollDownUp(driver);
        Thread.sleep(2000);

        StringUtil.ClicklistofBtnByGetText(SVConDebitcard,listofDtisvcDc,driver);
        Thread.sleep(2000);

        StringUtil.ClicklistofBtnByGetText(FeeOnTip,listofDtiFeeontip,driver);

        clickDtiCombobox2.click();
        Thread.sleep(1000);
        StringUtil.ClicklistofBtnByGetText(DiscountType,listoftypesymbol,driver);

        clickDtiDscnt.clear();
        clickDtiDscnt.sendKeys(DiscountAmount);
        Thread.sleep(2000);

    }
    public void setSettlementmode(String value){
        boolean flag = false;
        for (WebElement sm : listofsettle_mode) {
            if (sm.getAttribute("value").equalsIgnoreCase(value)) {
                flag = true;
                JavascriptExecutorUtil.clickElementByJs(driver, sm);
                break;
            }
        }
        if (flag == false) {
            System.out.println("element not found Settlement Mode");
        }
    }

    public void setAmPm(String value){
        for(int i=2;i>0;i--) {
            if(setAmorPm.getText().equalsIgnoreCase(value)){
                System.out.println(setAmorPm);
                break;
            }
            else {
                setAmorPm.click();
            }
        }
    }

    public void setPrintReport(String value){
        boolean flag = false;
        for (WebElement PM : listofPrintReport) {
            if (PM.getAttribute("value").equalsIgnoreCase(value)) {
                flag = true;
                JavascriptExecutorUtil.clickElementByJs(driver, PM);
                break;
            }
        }
        if (flag == false) {
            System.out.println("element not found Print Report");
        }
    }

    public boolean elementIsSelected(WebElement element) {
        return element.isSelected();
    }

    public boolean verifyPrintIsSelected() {
        return elementIsSelected(printRadioBtn);

    }

    public boolean verifyDontPrintIsSelected() {
        return elementIsSelected(dontPrintRadioBtn);
    }

    public boolean verifySmsIsSelected() {
        return elementIsSelected(smsCheckBox);
    }

    public boolean verifyEmailIsSelected() {
        return elementIsSelected(emailCheckBox);
    }

    public void verifyCloseReceipt() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        closeReceipt.click();
    }
}

