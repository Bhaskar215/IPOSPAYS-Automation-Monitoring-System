package com.denovo.Pages;

import com.denovo.Base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginBtn;


    @FindBy(xpath = "//a[@class='noble-ui-logo d-block mb-2 text-center']")
    WebElement logo;

    @FindBy(xpath = "//*[contains(text(),'Forgot Password?')]")
    WebElement forgotlink;

    @FindBy(xpath = "//input[@class='form-check-input']")
    WebElement Remembercheckbox;

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement usernamefieldbox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordfielbox;

    @FindBy(xpath = "//*[@alt='profile']")
    WebElement logoutprofile;

    @FindBy(xpath = "//span[contains(text(),'Log Out')]")
    WebElement logout;

    //Initializing the page objects
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    //Actions
    @Step("Getting LoginPagetitle step...")
    public String verifyLoginPageTitle() {
        logger.info("Title element is found");
        return driver.getTitle();
    }

    @Step("verifying Sign Up Link is displayed step...")
    public boolean VerifyForgotlink(){
        return forgotlink.isDisplayed();
    }


    @Step("verifying Denovologo isdisplayed step...")
    public boolean verifyDenovoLogo() {
        return logo.isDisplayed();
    }

    @Step("verifyRemembercheckbox step...")
    public void verifyRemembercheckbox() {
        Remembercheckbox.click();
    }


    @Step("login with username and password step...")
    public HomePage verifylogin(String username,String password) {
        usernamefieldbox.clear();
        usernamefieldbox.sendKeys(username);
        passwordfielbox.clear();
        passwordfielbox.sendKeys(password);
        loginBtn.click();

       return new HomePage();
    }
        @Step("verifying ClikProfile....")
        public void verifyclickprofile(){
            logoutprofile.click();
        }


        @Step("verifying clicklogout....")
        public void verifylogout(){
            logout.click();

    }
}