package com.denovo.Pages;

import com.denovo.Base.TestBase;
import com.denovo.Util.TestUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class CustomerPage extends TestBase {

    @FindBy(xpath = "//*[@class='sidebar-brand']/img")
    WebElement logo;

    @FindBy(xpath = "//span[text()='Dashboard ']")
    WebElement dashboardlinktxt;

    @FindBy(xpath = "//span[text()='User Management ']")
    WebElement usermanagementlinktxt;

    @FindBy(xpath = "//span[text()='Customer ']")
    WebElement customerlinktxt;

    @FindBy(xpath = "//span[text()='Customer ']")
    WebElement customerLinkFontcolor;

    @FindBy(xpath = "//span[text()='STEAM']")
    WebElement Steamslinktxt;


    @FindBy(xpath = "(//button[@class='btn btn-outline-primary btn-xs d-none d-md-block mr-4'])[1]")
    WebElement addcustomerbtn;


    @FindBy(xpath = "//input[@formcontrolname='dba']")
    WebElement Dba;

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@formcontrolname='isoIdentified']")
    WebElement isoIdentified;

    @FindBy(xpath = "//input[@formcontrolname='address1']")
    WebElement address1;

    @FindBy(xpath = "//input[@formcontrolname='address2']")
    WebElement address2;

    @FindBy(xpath = "//input[@formcontrolname='zipcode']")
    WebElement zipcode;

    @FindBy(xpath = "//*[@formcontrolname='processor']")
    WebElement processor;


    @FindBy(xpath = "(//div[@class='iti__selected-flag dropdown-toggle'])[1]")
    WebElement clickcountrydropdown1;

    @FindBy(xpath = "(//div[@class='iti__selected-flag dropdown-toggle'])[2]")
    WebElement clickcountrydropdown2;

    @FindBy(xpath = "(//div[@class='iti__selected-flag dropdown-toggle'])[3]")
    WebElement clickcountrydropdown3;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement email;

    @FindBy(xpath = "(//button[text()='Continue'])[1]")
    WebElement continuebtn1;

    @FindBy(xpath = "(//button[text()='Continue'])[2]")
    WebElement continuebtn2;

    @FindBy(xpath = "(//button[text()='Continue'])[3]")
    WebElement continuebtn3;

    @FindBy(xpath = "(//*[@id='phone'])[1]")
    WebElement phonenumber;

    @FindBy(xpath = "(//*[@id='phone'])[2]")
    WebElement techsupportphonenumber;

    @FindBy(xpath = "(//*[@id='phone'])[3]")
    WebElement helpdiskphone;

    @FindBy(xpath = "//*[@formcontrolname='helpDeskEmail']")
    WebElement helpDeskEmail;

    @FindBy(xpath = "//*[@formcontrolname='techSupportEmail']")
    WebElement techSupportEmail;

    @FindBy(xpath = "//button[text()='Go Customers List']")
    WebElement buttonIsDisplayed;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement clickFinishbtn;

    @FindBy(xpath = "//*[@class='custom-dropzone']")
    WebElement clickaddimage;

    @FindBy(xpath = "//*[contains(text(),'You successfully created your customer')]")
    WebElement customerDataCreated;


    public CustomerPage(){
        PageFactory.initElements(TestBase.driver,this);

    }

    @Step("verifying CustomerPage Title")
    public String verifyCustomerPageTitle() {
        return driver.getTitle();
    }

    @Step("verifying CustomerPage logo is displayed")
    public boolean verifyCustomerPagelogo() {
        return logo.isDisplayed();
    }

    public String verifycustomerlinkIsHighlighted() throws InterruptedException {
        addcustomerbtn.click();
        Thread.sleep(2000);
        String color=customerLinkFontcolor.getCssValue("color").trim();
        String color_hex[];
        color_hex = color.replace("rgba(", "").split(",");
        String actual_hex = String.format("#%02x%02x%02x",Integer.parseInt(color_hex[0].trim()),
                Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));

        return actual_hex;
    }


    @Step("verifying CustomerPage DashboardLink IsDisplayed")
    public boolean verifydashboardlinkIsDisplayed() {
        return dashboardlinktxt.isDisplayed();

    }

    @Step("verifying CustomerPage Steamslinktxt IsDisplayed")
    public boolean verifySteamlinkIsDisplayed() {
        return Steamslinktxt.isDisplayed();
    }



    @Step("verifying customerPage customerlink is displayed")
    public boolean verifycustomerlnkIsDisplayed(){
        return customerlinktxt.isDisplayed();

    }

    @Step("verifying customerPage usermanagementlink is displayed ")
    public boolean verifyusermanagementlinkIsDisplayed(){
        return usermanagementlinktxt.isDisplayed();
    }

    @Step("verifying customerPage Click CustomerLink ")
    public void verifyClickCustomerLink(){
        customerlinktxt.click();
    }


    @Step("verifying UserButton is Enable")
    public boolean verifyAddCustomerbtnIsEnable() {
        return addcustomerbtn.isEnabled();
    }

    @Step("verifying ClickAddcustomerBtn")
    public void verifyClickAddCustomerbtn(){
        addcustomerbtn.click();
    }

    @Step("verifying customer data")
    public void verifyCustomerdata(String dba,String fname,String lname,String Isoidentified,
                                   String Address1,String Address2,String Zipcode,String Email,String Processor,String PhoneNumber,
                             String TechSupportphoneNumber,String HelpDeskPhone,String HelpDeskEmail,String TechSupportEmail) throws InterruptedException {
        Dba.clear();
        Dba.sendKeys(dba);
        firstName.clear();
        firstName.sendKeys(fname);
        lastName.clear();
        lastName.sendKeys(lname);
        isoIdentified.clear();
        isoIdentified.sendKeys(Isoidentified);
        address1.clear();
        address1.sendKeys(Address1);
        address2.clear();
        address2.sendKeys(Address2);


        zipcode.clear();
        zipcode.sendKeys(Zipcode);
        Thread.sleep(10000);
        zipcode.sendKeys("5");
        zipcode.sendKeys("58");
        Thread.sleep(10000);
        zipcode.sendKeys(Keys.ENTER);


        email.clear();
        email.sendKeys(Email);

        continuebtn1.click();

        processor.clear();
        processor.sendKeys(Processor);
        Thread.sleep(2000);
        processor.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        continuebtn2.click();


        clickcountrydropdown1.click();
        TestUtil.Selectcountrydropdown("India (भारत)");
        phonenumber.clear();
        phonenumber.sendKeys(PhoneNumber);


        clickcountrydropdown2.click();
        TestUtil.Selectcountrydropdown("United States");
        techsupportphonenumber.clear();
        techsupportphonenumber.sendKeys(TechSupportphoneNumber);



        helpdiskphone.clear();
        helpdiskphone.sendKeys(HelpDeskPhone);

        helpDeskEmail.clear();
        helpDeskEmail.sendKeys(HelpDeskEmail);

        techSupportEmail.clear();
        techSupportEmail.sendKeys(TechSupportEmail);

        clickcountrydropdown3.click();
        TestUtil.Selectcountrydropdown("United States");

        Thread.sleep(3000);
        continuebtn3.click();



    }

    @Step
    public void verifyuploadimage(int value) throws AWTException {

        int n=value;

        while (n!=0){
            clickaddimage.click();
            Robot rb = new Robot();
            rb.delay(2000);

            StringSelection ss = new StringSelection("C:\\Users\\MY PC\\Downloads\\samplepngfile");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.delay(2000);

            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);
            rb.delay(2000);

            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            rb.delay(3000);
            n--;
        }
    }

    @Step("enter zipcode")
    public void verifyzipcode(WebElement element,String zip){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+zip+"');",element);
    }


    @Step
    public void verifyclickFinish(){
        clickFinishbtn.click();
    }

    @Step("verifying data created")
    public  String verifydatacreated(){
       return customerDataCreated.getText();

    }
}