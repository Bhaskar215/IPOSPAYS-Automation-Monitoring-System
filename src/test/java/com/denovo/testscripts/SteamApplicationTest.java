package com.denovo.testscripts;


import com.denovo.Base.TestBase;
import com.denovo.Pages.LoginPage;
import com.denovo.Pages.SteamApplicationPage;
import com.denovo.Util.DataProviderClass;
import com.denovo.Util.Listener.RetryAnalyzer;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

@Listeners(com.denovo.Util.Listener.TestAllureListeners.class)
public class SteamApplicationTest extends TestBase {

    SteamApplicationPage steamApplication;
    LoginPage loginPage;
    //HomePage homePage;


    public SteamApplicationTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
        steamApplication = new SteamApplicationPage();
        loginPage.verifylogin(pro.getProperty("username"),pro.getProperty("password"));
        steamApplication.verifyClickSteamlink();
        steamApplication.verifyClickSteamApplicationlink();

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate ApplicationLink Text Is HighLighted ")
    @Story("story Name: To Check validate ApplicationLink Text Is HighLighted ")
    @Test(priority = 1)
    public void validateApplicationIsHighlighted() throws InterruptedException {
        String str=steamApplication.verifyApplicationlinkIsHighlighted();
        Assert.assertEquals(str,"#e0f7fa","ApplicationLink is Not HighLighted");
    }



    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate Application SideBar color Body")
    @Story("story Name: To Check Application SideBar color Body With Cyan")
    @Test(priority = 2)
    public void validateSideBarWithCyanTheme(){
        String actualcolor=steamApplication.verifySideBarWithCyanTheme();
        Assert.assertEquals(actualcolor,"#80deea","As Per Expected CardHeader Should be cyan color" +
                "when User change CyanTheme Theme but Found" + actualcolor);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate Application CardHeader color")
    @Story("story Name: To Check Application CardHeader color with Cyan Theme")
    @Test(priority = 3)
    public void verifyCardHeaderWithCyanTheme(){
        String actualcolor=steamApplication.verifyCardHeaderWithCyanTheme();
        Assert.assertEquals(actualcolor,"#80deea","As Per Expected CardHeader Should be cyan color " +
                "when User change CyanTheme theme");
    }


    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate blueGreyTheme  test on Application")
    @Story("story Name: To Check Application SideBar color with blueGrey Theme ")
    @Test(priority = 4)
    public void validateSideBarWithBlueGreyTheme() throws InterruptedException {

        String actualcolor=steamApplication.verifySlideBarWithBlueGreyTheme();
       Assert.assertEquals(actualcolor,"#b0bec5","As Per Expected CardHeader Should be Bluegrey color " +
               "when User change Bluegrey theme");
    }


    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate blueGreyTheme  test on Application")
    @Story("story Name: To Check Application CardHeader with blueGrey Theme ")
    @Test(priority = 5)
    public void validateCardHeaderWithBlueGreyTheme() throws InterruptedException {
        String actualcolor1=steamApplication.verifyCardHeaderWithBlueGreyTheme();
        Assert.assertEquals(actualcolor1,"#b0bec5","As Per Expected CardHeader Should be blueGrey color " +
                "when User change Bluegrey theme");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate AddApplicationBtn IsEnable")
    @Story("story Name: To Check Application btn IsEnable")
    @Test(priority = 6)
    public void validateAddApplicationBtnIsEnable(){
        boolean flag=steamApplication.verifyAddApplicationBtnIsEnable();
        Assert.assertTrue(flag,"AddApplicationBtn isn't Enable");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate Manufacture Error Msg")
    @Story("story Name: To Check  Manufacture Error Msg")
    @Test(priority = 7)
    public void validateManufactureErrorMsg() throws InterruptedException {
        steamApplication.verifyClickAddApplicationBtn();
        steamApplication.verifyClickManufacturerDD();
        Thread.sleep(2000);
        steamApplication.verifyClickApplicationNamefield();
       String actualmsg=steamApplication.getManufacturerErrormsg();
        Assert.assertEquals(actualmsg," Manufacturer name is required ","Manufacturerfield Error msg is not valid");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate Device Error Msg")
    @Story("story Name: To Check  Device Error Msg")
    @Test(priority = 8)
    public void validateDeviceErrorMsg() throws InterruptedException {
        steamApplication.verifyClickAddApplicationBtn();
        String actualmsg= steamApplication.getDeviceErrormsg();
        Assert.assertEquals(actualmsg," Device Model is required ","DeviceField Error is not valid");
    }


    @DataProvider
    public Iterator<Object[]> getCreateApplication(){
        ArrayList<Object[]> ApplicationData= DataProviderClass.getApplicationData();
        return ApplicationData.iterator();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Case Description: validate Create Application")
    @Story("story Name: To Check  Application IsCreated")
    @Flaky
    @Test(priority = 9,retryAnalyzer = RetryAnalyzer.class,dataProvider = "getCreateApplication")
    public void validateCreateApplication(String Manufacturer,String DeviceModel,String ApplicationName,
                                          String ApplicationSign) throws InterruptedException, AWTException {
        steamApplication.verifyClickAddApplicationBtn();
        steamApplication.verifyCreateApplication(Manufacturer,DeviceModel,ApplicationName,
                ApplicationSign);

    }


    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}