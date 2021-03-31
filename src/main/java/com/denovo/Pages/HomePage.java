package com.denovo.Pages;

import com.denovo.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    //Page Factory
    @FindBy(xpath = "//span[contains(text(),'User Management')]")
    WebElement user;


    @FindBy(xpath = "//p[contains(text(),'Denovo Admin')]")
    WebElement username;

    @FindBy(xpath = "//*[@class='sidebar-brand']/img")
    WebElement logo;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //Actions
    public String verifyhomePageTitle() {
        return driver.getTitle();
    }

    public boolean verifylogo() {
        return logo.isDisplayed();
    }

    public String verifyUserName() {
        return username.getText();
    }

    public UserManagePage clickonusermanagelink() {
        user.click();
        return new UserManagePage();
    }
}