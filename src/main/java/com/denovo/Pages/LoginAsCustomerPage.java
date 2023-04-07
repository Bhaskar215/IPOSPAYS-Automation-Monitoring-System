/*
package com.denovo.Pages;

import com.denovo.Base.TestBase;
import com.denovo.Util.TestUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAsCustomerPage extends TestBase{


    @FindBy(xpath = "//*[@placeholder='Search by Name/Email/DBA']")
    WebElement searchCustomerName;

    @FindBy(xpath = "//span[text()='Customers']")
    WebElement customerlinktxt;

    @FindBy(xpath = "//*[contains(text(),'More')]")
    WebElement clickMoreBtn;

    @FindBy(xpath = "//*[contains(text(),'Login As')]")
    WebElement clickLoginAs;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    WebElement clickConfirm;

    @FindBy(xpath = "//*[contains(text(),'thomas@blondemorkin.com')]")
    WebElement emailcheck;

    @FindBy(xpath = "//*[@class='navbar-nav']//child::li[3]")
    WebElement clickProfile;

    @FindBy(xpath = "//*[@class='info text-center']/p[2]")
    WebElement getloginEmail;



    public LoginAsCustomerPage(){
        PageFactory.initElements(TestBase.driver,this);
    }


    @Step("verifying customerPage Click CustomerLink ")
    public void verifyClickCustomerLink(){
        TestUtil.waitForElementToBeVisible(customerlinktxt);
        customerlinktxt.click();
    }

    @Step("")
    public void verifySearchCustomer(String Email){
        TestUtil.waitForElementToBeVisible(searchCustomerName);
        searchCustomerName.sendKeys(Email);
    }

    @Step("")
    public void verifyClickMoreBtn() throws InterruptedException {
        TestUtil.waitForElementToBeVisible(clickMoreBtn);
        Thread.sleep(2000);
        clickMoreBtn.click();
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
    public void verifyEmailAfterLogin(String emailXpath) throws InterruptedException {

        WebElement CusEmail=driver.findElement(By.xpath("//*[contains(text(),'"+emailXpath+"')]"));
        TestUtil.waitForElementToBeVisible(CusEmail);

        String expectedEmail= CusEmail.getText();
        TestUtil.waitForElementToBeVisible(getloginEmail);
        String loginEmailText=getloginEmail.getText();
        boolean flag =false;
        if(loginEmailText.equalsIgnoreCase(expectedEmail)){
            flag=true;
            System.out.println("condition Satisfied");
        }
        if(flag==false){
            System.out.println("condition Not Satisfied");
        }
    }

    @Step("")
    public void verifyLoginAsCustomer(String email) throws InterruptedException {
        verifySearchCustomer(email);
        verifyClickMoreBtn();
        verifyClickLoginAsBtn();
        verifyClickConfirmBtn();
        verifyEmailAfterLogin(email);
    }
    
}*/
