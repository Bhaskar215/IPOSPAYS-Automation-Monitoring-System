package com.denovo.Pages;

import com.denovo.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginBtn;


    @FindBy(xpath = "//*[@class='auth-form-wrapper px-4 py-5']")
    WebElement logo;


    @FindBy(xpath = "//input[@class='form-check-input']")
    WebElement Remembercheckbox;


    //Initializing the page objects
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    //Actions
    public String verifyLoginPageTitle() {
        logger.info("Title element is found");
        return driver.getTitle();
    }


    public boolean verifyDenovoLogo() {
        return logo.isDisplayed();

    }

    public void verifyRemembercheckbox() {
        Remembercheckbox.click();
    }

    public HomePage verifylogin() {
        loginBtn.click();
        return new HomePage();


    }
}