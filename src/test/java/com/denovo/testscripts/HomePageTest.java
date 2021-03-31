package com.denovo.testscripts;

import com.denovo.Base.TestBase;
import com.denovo.Pages.HomePage;
import com.denovo.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homepage;

    public HomePageTest() {
        super();
    }

    @BeforeSuite
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homepage = loginPage.verifylogin();
    }

    @Test(priority = 1)
    public void validatehomepageTitle() {

        if(homepage.verifyhomePageTitle().equals("Denovo System")) {
            logger.info("Homepage title Passed");
            Assert.assertTrue(true);
        }
        else {
            logger.info("Homepage title failed");
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 2 )
    public void validatehomepagelogo() {
        boolean flag= homepage.verifylogo();
        Assert.assertTrue(flag);

    }

    @Test(priority = 3)
    public void validatehomepageusername() {
        homepage.verifyUserName();
    }

    @Test(priority = 4)
    public void validateusermanagelink(){
        homepage.clickonusermanagelink();

    }

    @AfterSuite
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}