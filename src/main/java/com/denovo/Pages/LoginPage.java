package com.denovo.Pages;

import com.denovo.enums.WaitStrategy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    //Page Factory


    private final By loginBtn = By.xpath("//span[contains(text(),'Login')]");

    private final By usernamefieldbox = By.xpath("//input[@formcontrolname='email']");

    private final By passwordfielbox = By.xpath("//input[@formcontrolname='password']");



    @Step("Click Login Button ")
    public LoginPage clickLoginbtn(){
       // TestUtil.waitForElementToBeClickable(loginBtn);
        click(loginBtn, WaitStrategy.CLICKABLE);
       // DriverManager.getDriver().findElement(loginBtn).click();
        return this;
    }


    @Step("login with username and password step...")
    public LoginPage verifyLoginWithCorrectCredentials(String username,String password) {
      //  TestUtil.waitForElementToBeVisible(usernamefieldbox);
        sendKeys(usernamefieldbox,username,WaitStrategy.VISIABLE);
        //usernamefieldbox.sendKeys(username);
        sendKeys(passwordfielbox,password,WaitStrategy.VISIABLE);
        //TestUtil.waitForElementToBeVisible(loginBtn);
        click(loginBtn,WaitStrategy.CLICKABLE);
        return this;
    }
}