package com.denovo.Pages;

import com.denovo.Base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class UserManagePage extends TestBase {


    @FindBy(xpath = "//p[contains(text(),'Denovo Admin')]")
    WebElement username;

    @FindBy(xpath = "//*[@class='sidebar-brand']/img")
    WebElement logo;

    @FindBy(xpath = "//span[text()='User Management ']")
    WebElement clickUserManagementLinkText;

    @FindBy(xpath = "//span[text()='User Management ']")
    WebElement userManagementFontcolor;

    @FindBy(xpath = "//span[text()='Dashboard ']")
    WebElement dashboardlabel;

    @FindBy(xpath = "/html/body/app-root/app-base/div/div/div/div/app-users/div[1]/div[1]/div[1]/button/i")
    WebElement userbtn;

    @FindBy(xpath = "(//button[@class='btn btn-outline-primary btn-xs d-none d-md-block mr-4'])[1]")
    WebElement clickuserBtn;

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    WebElement firstname;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    WebElement lastname;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailaddress;

    @FindBy(xpath = "//div[@class='iti__selected-flag dropdown-toggle']")
    WebElement clickdropdown;


    @FindBy(xpath = "//*[@id='phone']")
    WebElement phonenumber;

    @FindBy(xpath = "//select[@formcontrolname='userTypeRoleId']")
    WebElement Roledropdown;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement clicksubmit;

    @FindBy(xpath ="//*[contains(text(),'Data created successfully.')]")
    WebElement datacreated;

    @FindBy(xpath = "//*[contains(text(),'This email is already taken.')]")
    WebElement datainvalid;

    @FindBy(xpath = "//*[@alt='profile']")
    WebElement logoutprofile;

    @FindBy(xpath = "//span[contains(text(),'Log Out')]")
    WebElement logout;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    WebElement randomclick;

    public UserManagePage() {
        PageFactory.initElements(TestBase.driver, this);
    }

    @Step("verifying UsermanagePage Title")
    public String verifyusermanagepageTitle() {
        return driver.getTitle();
    }

    @Step("verifying logo is displayed")
    public boolean verifylogo() {
        return logo.isDisplayed();
    }

    @Step("verifying DashboardLink IsDisplayed")
    public boolean verifydashboardlinkIsDisplayed() {
        return dashboardlabel.isDisplayed();

    }

    @Step("verifying ")
    public String verifyuserManagementlinkIsHighlighted() throws InterruptedException {
        randomclick.click();
        Thread.sleep(2000);
        String color=userManagementFontcolor.getCssValue("color").trim();
        String color_hex[];
        color_hex = color.replace("rgba(", "").split(",");
        String actual_hex = String.format("#%02x%02x%02x",Integer.parseInt(color_hex[0].trim()),
                Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));

        return actual_hex;
    }

    @Step("verifying UserButton is Enable")
    public boolean verifyuserbtnIsEnable() {
        return userbtn.isEnabled();
    }

    @Step("verifying UserManagement Link")
    public void verifyClickUserManagementLink(){
            clickUserManagementLinkText.click();
    }


    @Step("verifying UserButton")
    public void verifyclickUserBtn() {
        clickuserBtn.click();
    }

    @Step("fetching data from excel Firstname:{0} Lastname:{1} Email: {2} Phone : {3}")
    public void verifyuserData(String fname, String lname,
                               String email, String phone,String Role) {

        firstname.clear();
        firstname.sendKeys(fname);
        lastname.clear();
        lastname.sendKeys(lname);
        emailaddress.clear();
        emailaddress.sendKeys(email);
        phonenumber.clear();
        phonenumber.sendKeys(phone);

        verifyRoleDropDown(Role);
    }

    @Step("verifying ClickDropdown")
    public void verifyclickDropdown() {
        clickdropdown.click();
    }

    @Step("verifying RoleDropdown")
    public void verifyRoleDropDown(String Role) {
        Select select = new Select(Roledropdown);
        List<WebElement> listofOption = select.getOptions();
        boolean flag= false;
        for (WebElement option : listofOption)
        {
            String list = option.getText().trim();
            if (list.equalsIgnoreCase(Role.trim()))
            {
                flag=true;
                select.selectByVisibleText(list);
            }

        }
        if(flag==false){
            System.out.println("element not found");
        }
    }

    @Step("verifying submit button")
    public void verifySubmitBtn() {
        clicksubmit.click();
    }

    @Step("verifying data created")
    public  void verifydatacreated(){
        try{
            String Datacreated =datacreated.getText();
            Assert.assertEquals(Datacreated,"Data created successfully.","After SuccessFulTry, Data Created Pop up Message Not displayed");
        }catch (Exception e){
            System.out.println("Data is Invalid or Email is already taken");
        }
    }

    @Step("verifying ClikProfile....")
    public void verifyclickprofile() {
        logoutprofile.click();
    }

    @Step("verifying clicklogout....")
    public void verifylogout() {
        logout.click();

    }
}