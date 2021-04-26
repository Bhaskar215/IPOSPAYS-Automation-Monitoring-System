package com.denovo.Pages;

import com.denovo.Base.TestBase;
import com.denovo.Util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagePage extends TestBase {


    @FindBy(xpath = "//p[contains(text(),'Denovo Admin')]")
    WebElement username;

    @FindBy(xpath = "//*[@class='sidebar-brand']/img")
    WebElement logo;


    @FindBy(xpath ="//span[text()='Dashboard ']")
    WebElement dashboardlabel;

    @FindBy(xpath ="//*[@class='link-icon feather icon-user-plus']")
    WebElement userbtn;

    @FindBy(xpath = "//div[@class='btn-group mb-3 mb-md-0 ng-star-inserted']/button")
    WebElement clickuserBtn;

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    WebElement firstname;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    WebElement lastname;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailaddress;

    @FindBy(xpath = "//div[@class='iti__selected-flag dropdown-toggle']")
    WebElement clickdropdown;


    public UserManagePage(){
        PageFactory.initElements(TestBase.driver,this);
    }

    public String verifyusermanagepageTitle() {
        return driver.getTitle();
    }

    public boolean verifylogo() {
        return logo.isDisplayed();
    }


    public boolean verifydashboardlinkIsDisplayed()
    {
        return  dashboardlabel.isDisplayed();

    }

    public boolean verifyuserbtnIsEnable(){
        return userbtn.isEnabled();
    }

    public void verifyclickUserBtn(){
         clickuserBtn.click();
    }


    public void verifyfirstname(String fname){
        firstname.sendKeys(fname);
    }

    public void verifylastname(String lname){
        lastname.sendKeys(lname);
    }

    public void verifyemail(String email){
        emailaddress.sendKeys(email);
    }

    public void verifyphone(String phonenumber){

    }

    public void verifyclickdropdown(){
        clickdropdown.click();
    }


}