package com.denovo.testscripts;

import com.denovo.Base.TestBase;
import com.denovo.Pages.CustomerPage;
import com.denovo.Pages.HomePage;
import com.denovo.Pages.LoginPage;
import com.denovo.Util.DataProviderClass;
import com.denovo.Util.Listener.RetryAnalyzer;
import com.denovo.Util.TestUtil;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class CustomerPageTest extends TestBase {

    LoginPage loginPage;
    TestUtil testUtil;
    HomePage homePage;
    CustomerPage customerPage;

    public CustomerPageTest(){
        super();

    }

    @BeforeMethod
    public void setup(){
        initialization();
        testUtil=new TestUtil();
        loginPage =new LoginPage();
        homePage = new HomePage();
        customerPage=new CustomerPage();
        homePage = loginPage.verifylogin(pro.getProperty("username"),pro.getProperty("password"));
         customerPage.verifyClickCustomerLink();

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify UserManagement page title")
    @Story("story Name: To Check UserManagePage Title")
    @Step("validate LoginPage Title")
    @Test(priority = 1)
    public void validateCustomerPageTitle() {

        String title= customerPage.verifyCustomerPageTitle();
        Assert.assertEquals(title,"Dejavoo System","Dejavoo title isn't Displayed");

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate logo test on CustomerPage")
    @Story("story Name: To Check validate logo")
    @Step("validate logo is displayed  ")
    @Test(priority = 2)
    public void validatelogo() {
        boolean flag = customerPage.verifyCustomerPagelogo();
        Assert.assertTrue(flag,"Dejavoo Logo not displayed");
    }


    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate logo test on UserManagePage")
    @Story("story Name: To Check validate logo")
    @Step("validate logo is displayed  ")
    @Test(priority = 3)
    public void validatedashboardlinkIsDisplayed() {
        boolean dashboard = customerPage.verifydashboardlinkIsDisplayed();
        Assert.assertTrue(dashboard,"dashboardLink Text isn't Displayed");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate customerLink Text IsSelected test on customerPage")
    @Story("story Name: To Check customerLinkText IsSelected")
    @Test(priority = 4)
    public void validateCustomerLinkIsSelected() throws InterruptedException {
        String actualColor =customerPage.verifycustomerlinkIsHighlighted();
        Assert.assertEquals(actualColor,"#e0f7fa","customerPage Link is not Highlighted on customerPage");

    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: validate UserManagePage Link")
    @Story("story Name: To Check validate logo")
    @Step("validate UserManagement Link   ")
    @Test(priority = 5)
    public void validateUsermanagementLink(){
        boolean usermanagement=customerPage.verifyusermanagementlinkIsDisplayed();
        Assert.assertTrue(usermanagement);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate UserManagePage Link")
    @Story("story Name: To Check validate UserManagePage Link ")
    @Step("validate CustomerLink Text ")
    @Test(priority = 6)
    public void validateCustomerLink(){
        boolean CustomerLink=customerPage.verifycustomerlnkIsDisplayed();
        Assert.assertTrue(CustomerLink,"Customer Link isn't displayed");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: validate STEAM Link")
    @Story("story Name: To Check validate STEAM link Is Displayed")
    @Step("validate STEAM Link   ")
    @Test(priority = 7)
    public void validateSteamLink(){
        boolean SteamLink=customerPage.verifySteamlinkIsDisplayed();
        Assert.assertTrue(SteamLink,"STEAM link Isn't Displayed");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: validate Add Customer btn is Enable")
    @Story("story Name: To Check validate Add Customer btn is Enable ")
    @Step("validate Customer btn is Enable")
    @Test(priority = 8)
    public void validateAddcustomerBtnIsEnable(){
       boolean customerbtn=customerPage.verifyAddCustomerbtnIsEnable();
       Assert.assertTrue(customerbtn,"Add Customer btn isn't Enable ");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: validate Click CustomerButton")
    @Story("story Name: To Check CustomerButton Is Clickable")
    @Step("validate validate click CustomerButton ")
    public void validateclickcustomerBtn() {
        customerPage.verifyClickAddCustomerbtn();
    }

    @Step("DataProvider method help fetch data from excel")
    @DataProvider
    public Iterator<Object[]>getcustomerdata(){
        ArrayList<Object[]> customerdata=DataProviderClass.getCustomerData();
        return customerdata.iterator();
    }


    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Case Description: validate UserManagePage Link")
    @Story("story Name: To Check validate customer data")
    @Step("validate customer data   ")
    @Test(priority = 9, retryAnalyzer = RetryAnalyzer.class,dataProvider = "getcustomerdata")
    public void validateCustomerData(String dba,String fname,String lname,String Isoidentified,
                                     String Address1,String Address2,String Zipcode,String Email,String Processor,
                                    String PhoneNumber,String TechSupportphoneNumber,String HelpDeskPhone, String HelpDeskEmail,String TechSupportEmail) throws InterruptedException, AWTException {

        validateclickcustomerBtn();
        customerPage.verifyCustomerdata(dba,fname,lname,Isoidentified,
                Address1,Address2,Zipcode,Email,Processor,PhoneNumber,TechSupportphoneNumber,HelpDeskPhone,
                HelpDeskEmail,TechSupportEmail);

             validateUploadImage();
             validateclickFinishbtn();
             validateDataCreated();
    }

    @Step("validateUploadImage")
    public void validateUploadImage() throws AWTException {
        customerPage.verifyuploadimage(5);

    }

    @Step("validate Finish Button ")
    public void validateclickFinishbtn(){
        customerPage.verifyclickFinish();

    }

    @Step("validate data created")
    public void validateDataCreated(){
       String DataCreated=customerPage.verifydatacreated();
        Assert.assertEquals(DataCreated,"You successfully created your customer","While uploading 5 image customerData isn't Created");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
      Thread.sleep(5000);
        driver.quit();
    }
}