/*
package com.denovo.Pages;

import com.denovo.Base.TestBase;
import com.denovo.Util.JavascriptExecutorUtil;
import com.denovo.Util.StringUtil;
import com.denovo.Util.TestUtil;
import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MerchantLoginPage extends TestBase {


    @FindBy(xpath = "//*[contains(text(),'Quick Sale')]")
    WebElement clickQuickSale;

    @FindBy(xpath = "(//*[@class='justify-content-row'])[3]//label")
    List<WebElement> listofRadioBtn;

    @FindBy(xpath = "//*[contains(text(),'Cloud Pos')]")
    WebElement clickCloudPos;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement usernamefieldbox;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passwordfielbox;

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement loginBtn;

    @FindBy(xpath = "//*[contains(text(),'Cloud Pos')]")
    WebElement clickcloudPos;

    @FindBy(xpath = "//ng-select[@placeholder='Select any TPN']")
    WebElement clickTpnField;

    @FindBy(xpath = "//*[@formcontrolname='amt']")
    WebElement enterAmt;

    @FindBy(xpath = "//*[@id='phone']")
    WebElement enterPhone;

    @FindBy(xpath = "//*[@formcontrolname='email']")
    WebElement enterEmail;

    @FindBy(xpath = "//*[@formcontrolname='cardNumber']")
    WebElement enterCardNumber;

    @FindBy(xpath = "//*[@formcontrolname='expDate']")
    WebElement enterExpDate;


    @FindBy(xpath = "//*[@name='cvv']")
    WebElement entercvv;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement clickSubmit;

    @FindBy(xpath = "//h5[@class='ng-star-inserted']")
    WebElement validateResponseMsg;

    @FindBy(xpath = "//*[contains(text(),'Close')]")
    WebElement clickClose;

    @FindBy(xpath = "//*[contains(text(),'Transactions ')]")
    WebElement clickTransaction;

    @FindBy(xpath = "//ng-dropdown-panel[@role='listbox']//span")
    List<WebElement> listofTpns;

    @FindBy(xpath = "//*[@class='card list-view card-list-bg card-full-width mb-4 ng-star-inserted']")
    List<WebElement> numberofRows;

    @FindBy(xpath = "//div[@class='dropdown-menu show']//span[contains(text(),'View Detail')]")
    WebElement viewDetail;

    @FindBy(xpath = "//*[@class='iti__flag-container']/div[1]/div[2]")
    WebElement getcountrycode;

    @FindBy(xpath = "//*[contains(text(),'Mobile')]/parent::div/dd")
    WebElement viewDetailMobile;


    @FindBy(xpath = "//*[contains(text(),'Email')]/parent::div/dd")
    WebElement viewDetailEmail;

    @FindBy(xpath = "//div[@class='iti__selected-flag dropdown-toggle']")
    WebElement clickdropdown;





    private String cardDetail = "";
    private String txType = "";
    private String tpnNo = "";
    private String txAmt = "";
    private String phone = "";
    private String email = "";

    private String countrycode="";


    public MerchantLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Click Login Button ")
    public void clickLoginbtn() {
        TestUtil.waitForElementToBeClickable(loginBtn);
        loginBtn.click();
    }

    @Step("login with username and password step...")
    public void verifyLoginWithCorrectCredentials(String username, String password) {
        usernamefieldbox.clear();
        usernamefieldbox.sendKeys(username);
        passwordfielbox.clear();
        passwordfielbox.sendKeys(password);
        loginBtn.click();
    }

    @Step("")
    public void verifyClickCloudPoslink() {
        clickcloudPos.click();
    }

    @Step("")
    public void verifySelectTpn(String Tpn) throws InterruptedException {
        TestUtil.waitForElementToBeVisible(clickTpnField);
        clickTpnField.click();
        TestUtil.waitForListOfElementToBevisible(listofTpns);
        StringUtil.ClickTextInListDropDown(Tpn, listofTpns, driver);

    }

    @Step("")
    public boolean verifyPerformQuickSale(String PaymentType,String  TransactionType,String  TPN,String country,String Amount,String Phone,String Email,String CardNumber,String ExpDate,String CVV) throws InterruptedException {

        int doOneMoreTx = 0;
        int retryLimit = 2;

        boolean txflag=false;


        while (doOneMoreTx < retryLimit) {

            TestUtil.waitForElementToBeVisible(clickcloudPos);
            clickcloudPos.click();

            TestUtil.waitForElementToBeVisible(clickQuickSale);
            clickQuickSale.click();


            StringUtil.ClicklistofBtnByGetText(TransactionType, listofRadioBtn, driver);

            //Set Transaction type
            setTxType(TransactionType);

            TestUtil.waitForElementToBeVisible(clickTpnField);
            clickTpnField.click();

            TestUtil.waitForListOfElementToBevisible(listofTpns);
            StringUtil.ClickTextInListDropDownBySplit(TPN, listofTpns, driver);

            //set Tpn
            setTpnNo(TPN);

            TestUtil.waitForElementToBeVisible(enterAmt);
            enterAmt.sendKeys(Amount);

            //set Amt
            setTxAmt(Amount);

            //TestUtil.Selectcountrydropdown("India (भारत)");

            verifyclickDropdown();

            TestUtil.Selectcountrydropdown(country);

            String countrycode=getcountrycode.getText();
            setCountrycode(countrycode);

            TestUtil.waitForElementToBeVisible(enterPhone);
            enterPhone.sendKeys(Phone);

            //setPhone
            setPhone(Phone);

            TestUtil.waitForElementToBeVisible(enterEmail);
            enterEmail.sendKeys(Email);

            //setEmail
            setEmail(Email);

            TestUtil.waitForElementToBeVisible(enterCardNumber);
            enterCardNumber.sendKeys(CardNumber);

            //Set CardDetail
            setCardDetail(CardNumber);

            TestUtil.waitForElementToBeVisible(enterExpDate);
            enterExpDate.sendKeys(ExpDate);
            TestUtil.waitForElementToBeVisible(entercvv);
            entercvv.sendKeys(CVV);

            TestUtil.waitForElementToBeVisible(clickSubmit);
            clickSubmit.click();

            boolean flag = verifyResponseMsg();
            if (!flag) {
                doOneMoreTx++;
            }

            if (flag) {
                boolean flagValue= verifyTxDetails(TransactionType, TPN, Amount, Phone, Email, CardNumber);
                txflag = flagValue;
                break;
            }
        }
        return txflag;
    }

    @Step("")
    public boolean verifyResponseMsg(){
        boolean flag = false;
        TestUtil.waitForElementToBeVisible(validateResponseMsg);
        String resposemsg = validateResponseMsg.getText();
        if (resposemsg.equalsIgnoreCase("Payment Successful")) {
            flag = true;
            TestUtil.waitForElementToBeVisible(clickClose);
            clickClose.click();
        } else {
            TestUtil.waitForElementToBeVisible(clickClose);
            clickClose.click();
        }
        return flag;
    }

    @Step("Verifying Tx Detail")
    public boolean verifyTxDetails(String TransactionType, String TPN, String Amount, String Phone, String Email, String CardNumber) throws InterruptedException {
        TestUtil.waitForElementToBeVisible(clickTransaction);
        clickTransaction.click();
        setTxType(TransactionType);
        setTpnNo(TPN);
        setTxAmt(Amount);
        setPhone(Phone);
        setEmail(Email);
        setCardDetail(CardNumber);

        String ActTxType = getTxType();
        String ActTpn = getTpnNo();
        String ActAmt = getTxAmt();
        String ActCardNo = getCardDetail();

        String ExpmobileNo = getPhone();
        String ExpActEmailId = getEmail();

        int tolrow = verirynumberofrows();

        boolean flag=false;

        for (int p = 1; p <= tolrow; p++) {
            Thread.sleep(3000);
            // Get TxType
            WebElement getTxType = driver.findElement(By.xpath("(//*[@class='card list-view card-list-bg card-full-width mb-4 ng-star-inserted'])[" + p + "]//h5/span"));
            TestUtil.waitForElementToBeVisible(getTxType);
            String ExpTxType = getTxType.getText();

            //Get CardDetail
            WebElement getMaskedPan = driver.findElement(By.xpath("(//*[@class='row'])[3]/div[1]//span"));
            TestUtil.waitForElementToBeVisible(getMaskedPan);
            String ExpMaskedPan = getMaskedPan.getText();

            //Get Tpn
            WebElement getTpn = driver.findElement(By.xpath("(//*[@class='row'])[3]/div[4]//span"));
            TestUtil.waitForElementToBeVisible(getTpn);
            String ExpTpn = getTpn.getText();

            //Get Amt
            WebElement getAmt = driver.findElement(By.xpath("(//*[@class='row'])[3]/div[5]//span"));
            TestUtil.waitForElementToBeVisible(getAmt);
            String ExpAmt = getAmt.getText().replaceAll("[^\\d+]", "");
            System.out.println(ExpAmt);

            if (ActTxType.equalsIgnoreCase(ExpTxType) && ActTpn.equalsIgnoreCase(ExpTpn) && ActAmt.equalsIgnoreCase(ExpAmt) && ExpMaskedPan.equalsIgnoreCase(ExpMaskedPan)) {
                WebElement clickdropdown = null;
                try {
                    clickdropdown = driver.findElement(By.xpath("(//button[@id='dropdownMenuButton'])[" + p + "]"));
                    clickdropdown.click();
                } catch (StaleElementReferenceException e) {
                    clickdropdown = driver.findElement(By.xpath("(//button[@id='dropdownMenuButton'])[" + p + "]"));
                    JavascriptExecutorUtil.clickElementByJs(driver, clickdropdown);
                    clickdropdown.click();
                } catch (Exception e) {
                    System.out.println("Some error Occurred while waiting for the Element" + clickdropdown.toString());
                }

                try {
                    TestUtil.waitForElementToBeVisible(viewDetail);
                    viewDetail.click();
                } catch (StaleElementReferenceException e) {
                    wait.until(ExpectedConditions.visibilityOf(viewDetail));
                    driver.findElement(By.xpath("//div[@class='dropdown-menu show']//span[contains(text(),'View Detail')]")).click();
                }catch ( Exception e){
                    System.out.println("Some error Occurred while waiting for the Element" + viewDetail.toString());
            }
                TestUtil.waitForElementToBeVisible(viewDetailMobile);
                String ActMobileNo= viewDetailMobile.getText();
                TestUtil.waitForElementToBeVisible(viewDetailEmail);
                String ActEmailId= viewDetailEmail.getText();

                if(ActMobileNo.equalsIgnoreCase(ExpmobileNo) && ActEmailId.equalsIgnoreCase(ExpActEmailId)){
                    System.out.println("Mobile and Email Is Present");
                    flag=true;
                    break;
                }
        }
            if(!flag){
                System.out.println("Mobile and Email Is Present");
                break;
            }
    }
        return flag;
    }


    @Step("verify the Total Rows of Current Page")
    public int verirynumberofrows() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(numberofRows));
            int toltxperpage = numberofRows.size();
            return toltxperpage;
        } catch (StaleElementReferenceException e) {
            return driver.findElements(By.xpath("//*[@class='card list-view card-list-bg card-full-width mb-4 ng-star-inserted']")).size();
        }
    }

    @Step("verifying ClickDropdown")
    public void verifyclickDropdown() {
        TestUtil.waitForElementToBeVisible(clickdropdown);
        clickdropdown.click();
    }

    public String getCardDetail() {
        return cardDetail;
    }

    public String getTxType() {
        return txType;
    }

    public String getTpnNo() {
        return tpnNo;
    }

    public String getTxAmt() {
        return txAmt;
    }

    public void setCardDetail(String cardDetail) {
        this.cardDetail = cardDetail;
    }

    public void setTxType(String txType) {
        this.txType = txType;
    }

    public void setTpnNo(String tpnNo) {
        this.tpnNo = tpnNo;
    }

    public void setTxAmt(String txAmt) {
        this.txAmt = txAmt;
    }

    public String getPhone() {
        String coutrycode=getCountrycode();
        return coutrycode+phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

}*/
