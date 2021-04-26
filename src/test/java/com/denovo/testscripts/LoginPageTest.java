package com.denovo.testscripts;

import com.denovo.Base.TestBase;
import com.denovo.Pages.LoginPage;
import com.denovo.Util.DataProviderClass;
import com.google.gson.annotations.SerializedName;
import io.qameta.allure.*;
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
        if(loginpage.verifyLoginPageTitle().equals("Dejavoo System")) {
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
    @Story("story Name: To Check LoginPage func")
    @Description("Test Description: Invalid Username and Password,Valid Username and Invalid Password")
    @Step("Login Step with username: {0}, password :{1}")

    @Test(priority = 5,dataProvider = "webLogin",dataProviderClass = DataProviderClass.class)
    public void validateloginTest(String username,String password) {
        loginpage.verifylogin(username, password);
        logger.info("Login Is passed");
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story Name: To check ClickProfile")
    @Description("Test Description :")

    @Test(priority = 6)
    public  void validateclickprofile(){
            loginpage.verifyclickprofile();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story Name: To Check LogoutFunc")
    @Test(priority = 7)
    public void validatelogout(){
        loginpage.verifylogout();
    }


    @AfterSuite
    public void teardown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}