package com.denovo.Pages;

import com.denovo.Base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    //Page Factory
    @FindBy(xpath = "//span[contains(text(),'User Management')]")
    WebElement userManagelinkTest;


    @FindBy(xpath = "//*[@class='sidebar-brand']/img")
    WebElement logo;


    public HomePage()
    {
        PageFactory.initElements(TestBase.driver, this);
    }

    //Actions
    @Step("Getting HomePagetitle step...")
    public String verifyhomePageTitle() {
        return driver.getTitle();
    }

    @Step("Getting HomePageLogo step...")
    public boolean verifylogo() {
        return logo.isDisplayed();
    }

    @Step("Getting userManagementPage step...")
    public UserManagePage clickonusermanagelink() {
        userManagelinkTest.click();
        return new UserManagePage();
    }
}