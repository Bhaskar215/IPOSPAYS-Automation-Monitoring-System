package com.denovo.Pages;

import com.denovo.Base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends TestBase {
    //Page Factory
    @FindBy(xpath = "//span[contains(text(),'User Management')]")
    WebElement userManagelinkTest;

    @FindBy(xpath = "//*[@class='sidebar-brand']/img")
    WebElement logo;

    @FindBy(xpath = "//span[text()='Dashboard ']")
    WebElement dashBoardIsDisplayed;

    @FindBy(xpath = "//span[text()='Customer ']")
    WebElement customerIsDisplayed;

    @FindBy(xpath = "//span[text()='Transactions ']")
    WebElement TransactionsIsDiplayed;

    @FindBy(xpath = "//span[text()='STEAM']")
    WebElement steamsIsDisplayed;

    @FindBy(xpath = "//span[text()='Dashboard ']")
    WebElement dashboardFontcolor;

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

    public String verifyDashboardlinkIsHighlighted(){
        String color=dashboardFontcolor.getCssValue("color").trim();
        String color_hex[];
        color_hex = color.replace("rgba(", "").split(",");
        String actual_hex = String.format("#%02x%02x%02x",Integer.parseInt(color_hex[0].trim()),
                Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));

        return actual_hex;
    }

    public boolean isElementPresent(WebElement element,String value){
        return element.isDisplayed() && element.getText().equalsIgnoreCase(value);

    }

    @Step("Getting userManagementPage step...")
    public boolean verifyUsermanagelinkIsdisplayed() {
       return   isElementPresent(userManagelinkTest,"User Management");
    }

    @Step("Getting Dashboardlink is IsSelected or Not")
    public boolean verifyDashboardIsDisplaed(){
        return isElementPresent(dashBoardIsDisplayed,"Dashboard");
    }

    @Step("Getting CustomerLinks isDisplayed or Not")
    public boolean verifyCustomerIsDispalyed() {
        return isElementPresent(customerIsDisplayed,"Customer");
    }

    @Step("Getting ParamsLinks is IsSelected or Not")
    public boolean verifyTranscationIsDisplayed() {
        return isElementPresent(TransactionsIsDiplayed,"Transactions");
    }

    @Step("Getting SteamsLink is IsSelected or Not")
    public boolean verifySteamsIsDisplayed(){
        return isElementPresent(steamsIsDisplayed,"STEAM");
    }
}