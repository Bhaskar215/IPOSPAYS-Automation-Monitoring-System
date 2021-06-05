package com.denovo.Pages;

import com.denovo.Base.TestBase;
import com.denovo.Util.DataProviderClass;
import com.denovo.Util.JavascriptExecutorUtil;
import com.denovo.Util.StringUtil;
import com.denovo.Util.TestUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SteamApplicationPage extends TestBase {


    @FindBy(xpath = "//*[text()='STEAM']")
    WebElement steamLinkTxt;

    @FindBy(xpath = "//a[contains(text(),'Application')]")
    WebElement applicationLinkTxt;

    @FindBy(xpath = "//input[@id='applicationSignLbl']")
    WebElement applicationsign;

    @FindBy(xpath = "//input[@formcontrolname='applicationName']")
    WebElement applicationname;

    @FindBy(xpath = "//input[@formcontrolname='buildNumber']")
    WebElement buildnumber;

    @FindBy(xpath = "//ngb-alert[@class='alert show alert-info fade ng-star-inserted']")
    WebElement buildalert;

    @FindBy(xpath = "//button[@type='button'][1]")
    WebElement addApplicationBtn;

    @FindBy(xpath = "//*[@class='sidebar-brand']/img")
    WebElement logo;

    @FindBy(xpath = "//span[text()='Dashboard ']")
    WebElement dashboardlinktxt;

    @FindBy(xpath = "//span[text()='User Management ']")
    WebElement usermanagementlinktxt;

    @FindBy(xpath = "//span[text()='Customer ']")
    WebElement customerlinktxt;

    @FindBy(xpath = "//*[text()=' Device Modal is required ']")
    WebElement deviceErrorMsg;

    @FindBy(xpath = "//*[@id='manufacturerName']")
    WebElement manufacturerDD;

    @FindBy(xpath = "(//*[@type='text'])[3]")
    WebElement deviceDD;

    @FindBy(xpath = "//input[@formcontrolname='fileLocation']")
    WebElement fileupload;


    @FindBy(xpath = "//input[@formcontrolname='templateJson']")
    WebElement fileuploadJSON;

    @FindBy(xpath = "//span[contains(text(),'Create Application')]")
    WebElement createApplicationBtn;

    @FindBy(xpath = "//i[@class='link-icon feather icon-settings']")
    WebElement clickeSettionIcon;

    @FindBy(xpath = "(//div[@class='dropdown-body'])[4]//input[@id='checkbox2']")
    WebElement clickCyan;

    @FindBy(xpath = "(//div[@class='dropdown-body'])[4]//input[@id='checkbox3']")
    WebElement clickBlueGrey;

    @FindBy(xpath = "/html/body/app-root/app-base/div/app-sidebar/nav/div[2]")
    WebElement sidebarcolor;

    @FindBy(xpath = "(//*[@class='card-header'])[1]")
    WebElement bgCardHeaderColor;

    @FindBy(xpath = "(//ngb-alert[@role='alert'])[1]")
    WebElement manufacturerErrormsg;

    @FindBy(xpath = "//*[@id='navbarForm']")
    WebElement searchbox;

    public SteamApplicationPage(){
        PageFactory.initElements(TestBase.driver,this);
    }


    @Step("verify steamApplication Title.")
    public String verifysteamApplication(){
        return driver.getTitle();
    }

    @Step("Verify  SteamApplicationlogo Is Displayed...")
    public boolean verifysteamApplicationlogo(){
        return logo.isDisplayed();
    }

    @Step("Verify Applicationlink is IsSelected or Not")
    public String verifyApplicationlinkIsHighlighted() throws InterruptedException {
        searchbox.click();
        Thread.sleep(3000);
        return TestUtil.getFontcolor(applicationLinkTxt,"color");
    }

    @Step("Verify Steamlink navigate to correct page")
    public void verifyClickSteamlink(){
        TestUtil.waitForElementToBeClickable(steamLinkTxt);
        steamLinkTxt.click();
    }

    @Step("verify Click SteamApplication")
    public void verifyClickSteamApplicationlink(){
        applicationLinkTxt.click();
    }

    @Step("Verify Application Btn")
    public void verifyClickAddApplicationBtn(){
        addApplicationBtn.click();
    }

    @Step("verify Application Btn is Enable")
    public boolean verifyAddApplicationBtnIsEnable(){
       return addApplicationBtn.isEnabled();
    }


    public void verifyClickManufacturerDD(){
       WebDriverWait wait = new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.elementToBeClickable(manufacturerDD));
        manufacturerDD.click();

    }

    public void verifyClickDeviceDD(){
        deviceDD.click();
    }

    public void verifyClickApplicationNamefield(){
        applicationname.click();
    }

    @Step("Get Manufacturer Error Msg")
    public String getManufacturerErrormsg(){
       return manufacturerErrormsg.getText();
    }

    @Step("Get Device Error Msg")
    public String getDeviceErrormsg(){
        TestUtil.waitForElementToBeClickable(manufacturerDD);
        manufacturerDD.click();
        manufacturerDD.sendKeys("kozen");
        TestUtil.waitForElementToBeClickable(manufacturerDD);
        manufacturerDD.click();
        manufacturerDD.sendKeys(Keys.ENTER);

        TestUtil.waitForElementToBeClickable(deviceDD);
        deviceDD.click();
        TestUtil.waitForElementToBeClickable(applicationname);
        applicationname.click();
        //Action
        String str  = deviceErrorMsg.getText();
        return str;
    }

    @Step("Check Cyan Theme Sidebar Color")
    public String verifySideBarWithCyanTheme(){
        clickeSettionIcon.click();
        JavascriptExecutorUtil.clickElementByJs(driver,clickCyan);
        String color=sidebarcolor.getCssValue("background").trim();
        String color_hex[];
        color_hex = color.replace("rgb(", "")
                .replace(") none repeat scroll 0% 0% / auto padding-box border-box","")
                .trim().split(",");
        String actual_hex = String.format("#%02x%02x%02x",Integer.parseInt(color_hex[0].trim()),
                Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));

        return actual_hex;
    }

    @Step("Check theme cyan bG color")
    public String verifyCardHeaderWithCyanTheme(){
        String color=bgCardHeaderColor.getCssValue("background-color").trim();
        String color_hex[];
        color_hex = color.replace("rgba(", "")
                .replace(") none repeat scroll 0% 0% / auto padding-box border-box","")
                .split(",");
        String actual_hex = String.format("#%02x%02x%02x",Integer.parseInt(color_hex[0].trim()),
                Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));

        return actual_hex;

    }

    @Step("check blue grey theme sidebar body colour")
    public String verifySlideBarWithBlueGreyTheme() throws InterruptedException {
        clickeSettionIcon.click();
        JavascriptExecutorUtil.clickElementByJs(driver,clickBlueGrey);
        Thread.sleep(3000);
        String color=sidebarcolor.getCssValue("background").trim();
        String color_hex[];
        color_hex = color.replace("rgb(", "").replace(") none repeat scroll 0% 0% / auto padding-box border-box","")
                .split(",");
        String actual_hex = String.format("#%02x%02x%02x",Integer.parseInt(color_hex[0].trim()),
                Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));

        return actual_hex;
    }

    @Step("Check blue grey theme bG color")
    public String verifyCardHeaderWithBlueGreyTheme() throws InterruptedException {
        clickeSettionIcon.click();
        JavascriptExecutorUtil.clickElementByJs(driver,clickBlueGrey);
        String color=bgCardHeaderColor.getCssValue("background-color").trim();
        String color_hex[];
        color_hex = color.replace("rgba(", "").split(",");
        String actual_hex = String.format("#%02x%02x%02x",Integer.parseInt(color_hex[0].trim()),
                Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));

        return actual_hex;

    }

    @Step("Verify Create Application ")
    public void verifyCreateApplication(String Manufacturer,String DeviceModel,String ApplicationName,
                                        String ApplicationSign) throws InterruptedException, AWTException {

       Thread.sleep(2000);
        //Enter manufacturer Data
        verifyClickManufacturerDD();
        TestUtil.waitForPageElementPresent(By.xpath("//*[@id='manufacturerName']"));
        manufacturerDD.sendKeys(Manufacturer);
        TestUtil.waitForPageElementPresent(By.xpath("//*[@id='manufacturerName']"));
        manufacturerDD.click();
        manufacturerDD.sendKeys(Keys.ENTER);

        TestUtil.waitForElementToBeClickable(deviceDD);
        //deviceDD.click();

       deviceDD.sendKeys(DeviceModel);
        TestUtil.waitForElementToBeClickable(deviceDD);
        deviceDD.click();

        TestUtil.waitForElementToBeClickable(deviceDD);
        deviceDD.sendKeys(Keys.ENTER);

        Thread.sleep(5000);


        applicationname.sendKeys(ApplicationName);
        applicationsign.sendKeys(ApplicationSign);
        applicationsign.click();
        applicationsign.sendKeys(Keys.ENTER);

        int buildNo =StringUtil.getBuildNo(buildalert);
        buildnumber.sendKeys(String.valueOf(buildNo));

        TestUtil.uploadfile(fileupload,1,"C:\\Users\\MY PC\\Downloads\\minimal_params (2)");

        TestUtil.uploadfile(fileuploadJSON,1,"C:\\Users\\MY PC\\Downloads\\paramV1 (4).json");

        createApplicationBtn.click();
    }

}