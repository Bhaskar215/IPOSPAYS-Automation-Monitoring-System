/*
package com.denovo.Pages;

import com.denovo.Base.TestBase;
import com.denovo.Util.TestUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAsMerchantPage extends TestBase{


    @FindBy(xpath = "//input[@placeholder='Search by dba/email/phone/state/city']")
    WebElement searchMerchantName;

    @FindBy(xpath = "//span[text()='Merchants']")
    WebElement Merchantslinktxt;


    @FindBy(xpath = "//span[text()='My Customers']")
    WebElement MyCustomersLinkTxt;

    @FindBy(xpath = "//button[@id='dropdownBasic1']")
    WebElement clickMyCustomerbtn;


    @FindBy(xpath = "//span[contains(text(),'Export as Xlsx')]")
    WebElement excelIsDisable;

    @FindBy(xpath = "//*[@class='d-flex justify-content-between']//child::div[@class='dropdown']")
    WebElement clickDropDown;

    @FindBy(xpath = "//*[contains(text(),'Login As')]")
    WebElement clickLoginAs;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    WebElement clickConfirm;

    @FindBy(xpath = "//*[contains(text(),'Refund')]")
    WebElement RefundRadioBtn;

    @FindBy(xpath = "//*[contains(text(),'CloudPOS')]")
    WebElement clickCloudPos;

    @FindBy(xpath = "//*[contains(text(),' Card Payments ')]")
    WebElement clickCardPayment;

    @FindBy(xpath = "//*[contains(text(),'Refund')]")
    WebElement RefundText;

    @FindBy(xpath = "//*[@class='dropdown-item d-flex align-items-center disabled']")
    WebElement exportIsDisable;


    public LoginAsMerchantPage(){
        PageFactory.initElements(TestBase.driver,this);
    }

    @Step("verifying customerPage Click CustomerLink ")
    public void verifyClickMerchantLink(){
        TestUtil.waitForElementToBeVisible(Merchantslinktxt);
        Merchantslinktxt.click();
    }


    @Step("")
    public void verifySearchMerchant(String Email){
        TestUtil.waitForElementToBeVisible(searchMerchantName);
        searchMerchantName.sendKeys(Email);
    }

    @Step("")
    public void verifyClickDropDownBtn() throws InterruptedException {
        TestUtil.waitForElementToBeVisible(clickDropDown);
        Thread.sleep(2000);
        clickDropDown.click();
    }

    @Step("")
    public void verifyRefundIsEnable(){
        TestUtil.waitForElementToBeVisible(clickCloudPos);
        clickCloudPos.click();
        TestUtil.waitForElementToBeClickable(clickCardPayment);
        clickCardPayment.click();

    }



    @Step("")
    public void verifyClickLoginAsBtn(){
        TestUtil.waitForElementToBeVisible(clickLoginAs);
        clickLoginAs.click();
    }

    @Step("")
    public void verifyClickConfirmBtn() throws InterruptedException {
        TestUtil.waitForElementToBeVisible(clickConfirm);
        Thread.sleep(3000);
        clickConfirm.click();
    }

    @Step("")
    public String verifyRefundIsDisabled(){
        TestUtil.waitForElementToBeVisible(clickCloudPos);
        clickCloudPos.click();
        TestUtil.waitForElementToBeClickable(clickCardPayment);
        clickCardPayment.click();
        TestUtil.waitForElementToBeVisible(RefundRadioBtn);
        return TestUtil.getColor(RefundRadioBtn,"color");
    }

    public String verifyMyCustomerExportIsDisabled(){
        TestUtil.waitForElementToBeVisible(MyCustomersLinkTxt);
        MyCustomersLinkTxt.click();
        TestUtil.waitForElementToBeClickable(clickMyCustomerbtn);
        clickMyCustomerbtn.click();
        TestUtil.waitForElementToBeClickable(excelIsDisable);
        return TestUtil.getColor(excelIsDisable,"color");
    }
}*/
