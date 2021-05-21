
package com.denovo.testscripts;

import com.denovo.Base.TestBase;
import com.denovo.Pages.HomePage;
import com.denovo.Pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homepage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homepage = loginPage.verifylogin(pro.getProperty("username"),pro.getProperty("password"));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Homepage title Test ")
    @Story("story Name: To Check HomePage Title")
    @Test(priority = 1)
    public void validatehomepageTitle() {
        String title=homepage.verifyhomePageTitle();
        System.out.print(title);
        Assert.assertEquals(title,"Dejavoo System");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Home page Logo test on Home Page")
    @Story("story Name: To Check HomePage Logo")
    @Test(priority = 2 )
    public void validatehomepagelogo() {
        boolean flag= homepage.verifylogo();
        Assert.assertTrue(flag,"Dejavoo logo is not displayed");
    }



    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate DashboardLink IsSelected test on Home Page")
    @Story("story Name: To Check Dashboard link IsSelected")
    @Test(priority = 3)
    public void validateDashboardlinkIsSelected() {
        String actualColor = homepage.verifyDashboardlinkIsHighlighted();
        Assert.assertEquals(actualColor,"#e0f7fa","DashBoard Link is not Highlighted on DashBoard Page");

    }



    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Dashboard test on Home Page")
    @Story("story Name: To Check Dashboard link IsSelected")
    @Test(priority = 4)
    public void validateDashboardlinkIsDisplayed() {
        boolean flag = homepage.verifyDashboardIsDisplaed();
        Assert.assertTrue(flag,"Dashboard Link is not Displayed");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify UserManagement Link test on Home Page")
    @Story("story Name: To Check  link UserManagement link IsDisplayed")
    @Test(priority = 5)
    public void validateusermanagelinkIsDisplayed(){
        boolean flag=homepage.verifyUsermanagelinkIsdisplayed();
        Assert.assertTrue(flag,"UserManagment Link is not displayed");

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Customer Link test on Home Page")
    @Story("story Name: To Check  link customer link IsDisplayed")
    @Test(priority = 6)
    public void validateCustomerlinkIsDisplayed(){
        boolean flag=homepage.verifyCustomerIsDispalyed();
        Assert.assertTrue(flag,"Customer link is not displayed");

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate Steams Link test on Home Page")
    @Story("story Name: To Check validate Steams Link IsDisplayed")
    @Test(priority = 7)
    public void validateSteamsLinkIsDisolayed(){
        boolean flag=homepage.verifySteamsIsDisplayed();
        Assert.assertTrue(flag,"Steam Link is not displayed");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate Transactions Link test on Home Page")
    @Story("story Name: To Check validate Transactions Link IsDisplayed")
    @Test(priority = 8)
    public void validateTransactionsLinkIsDisplayed(){
        boolean flag=homepage.verifySteamsIsDisplayed();
        Assert.assertTrue(flag,"Transactions Link is not displayed");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}