package com.denovo.testscripts;

import com.denovo.Base.TestBase;
import com.denovo.Pages.HomePage;
import com.denovo.Pages.LoginPage;
import com.denovo.Pages.UserManagePage;
import com.denovo.Util.TestUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserManagePageTest extends TestBase {

    LoginPage loginpage;
    HomePage homePage;
    UserManagePage userManagePage;
    TestUtil testUtil;


    public UserManagePageTest(){
        super();
    }


    @BeforeSuite
    public void setup(){
        initialization();
        testUtil=new TestUtil();
        loginpage = new LoginPage();
        userManagePage = new UserManagePage();
              homePage = loginpage.verifylogin();
        userManagePage = homePage.clickonusermanagelink();
    }

    @Test(priority = 1)
    public void validateusermanagepageTitle(){
        if(userManagePage.verifyusermanagepageTitle().equals("Denovo System")) {
            logger.info("usermanagepage title Passed");
            Assert.assertTrue(true);
        }

        else
            {
            logger.info("usermanagepage title failed");
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 2)
    public void validatelogo(){
      boolean flag=  userManagePage.verifylogo();
      Assert.assertTrue(flag);
    }


    @Test(priority = 3)
    public void validatedashboardlinkIsDisplayed(){
        boolean dashboard= userManagePage.verifydashboardlinkIsDisplayed();
        Assert.assertTrue(dashboard);
    }

    @Test(priority = 4)
    public void validateuserbtn(){
        boolean Usertype = userManagePage.verifyuserbtnIsEnable();
        Assert.assertTrue(Usertype);
    }

    @Test(priority = 5)
    public void validateclickuserBtn(){
        userManagePage.verifyclickUserBtn();
    }


    @Test(priority = 6)
    @Parameters({"fname"})
    public void validatefirstname(String fname){
        userManagePage.verifyfirstname(fname);
    }


    @Test(priority = 7)
    @Parameters({"lname"})
    public void validatelastname(String lname){
        userManagePage.verifylastname(lname);
    }


    @Test(priority = 8)
    @Parameters({"email"})
    public void validateemail(String email){
        userManagePage.verifyemail(email);
    }


    @Test(priority = 9)
    public void validateclickdropdown(){
        userManagePage.verifyclickdropdown();
    }


    @Test(priority = 10)
    public void validateSelectcountry() throws InterruptedException {
       Thread.sleep(4000);
        testUtil.dropdown();
    }

    public void teardown(){
        driver.quit();
    }

}