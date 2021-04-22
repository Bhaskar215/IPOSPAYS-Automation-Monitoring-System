package com.denovo.testscripts;

import com.denovo.Base.TestBase;
import com.denovo.Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends TestBase {
    LoginPage loginpage;


    public LoginPageTest() {
        super();
    }

    @BeforeSuite
    public void setup() {
        initialization();
        loginpage = new LoginPage();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login page title test on Login Page")
    @Story("story Name: To Check LoginPage Title")
    @Test(priority = 1,description = "verifying login Page title test")

    public void validateloginpageTitle() {
        if(loginpage.verifyLoginPageTitle().equals("Denovo System")) {
            logger.info("LoginPage title Passed");
            Assert.assertTrue(true);
        }

        else {
            logger.info("LoginPage title failed");
            Assert.assertTrue(false);

        }
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validatedenovologo test on Login Page")
    @Story("story Name: To Check validatedenovologo")
    @Test(priority = 2,description = "verifying validatedenovolog test")
    public void validatedenovologo() {
        boolean flag = loginpage.verifyDenovoLogo();
        Assert.assertTrue(flag);
    }


    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate Rememberme  test on Login Page")
    @Story("story Name: To Check validateRememberme ")
    @Test(priority =3 ,description = "verifying validate Remember me test")
    public void validateRememberme() {
        loginpage.verifyRemembercheckbox();
        logger.info("Remembercheckbox is clicked");

    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: validateForgotlink test on Login Page")
    @Story("story Name: To Check  forgotLink")
    @Test(priority = 4,description = "verifying validate Remember me test")
    public void validateForgotlink(){
        Assert.assertTrue(loginpage.VerifyForgotlink());
    }


    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Case Description: validateloginbtn test on Login Page")
    @Story("story Name: To Check LoginPage func")
    @Test(priority = 5,description = "verifying loginCorrectCredentialsTest")
    public void validateloginCorrectCredentialsTest() {
        loginpage.verifylogin();
        logger.info("Login Is passed");
    }



    @AfterSuite
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}