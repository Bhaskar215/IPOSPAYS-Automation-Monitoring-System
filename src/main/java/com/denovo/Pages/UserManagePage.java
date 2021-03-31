package com.denovo.Pages;

import com.denovo.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagePage extends TestBase {

    @FindBy(xpath = "//p[contains(text(),'Denovo Admin')]")
    WebElement username;

    @FindBy(xpath = "//*[@class='sidebar-brand']/img")
    WebElement logo;




    public UserManagePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyUserPageTitle() {
        return driver.getTitle();
    }

    public String verifyUserName() {
        return username.getText();
    }
    public boolean verifylogo() {
        return logo.isDisplayed();


    }
}
