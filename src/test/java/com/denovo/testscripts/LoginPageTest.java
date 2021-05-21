package com.denovo.testscripts;

import com.denovo.Base.TestBase;
import com.denovo.Pages.LoginPage;
import com.denovo.Util.DataProviderClass;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends TestBase {
    LoginPage loginpage;


    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginpage = new LoginPage();
    }



    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login page title test on Login Page")
    @Story("story Name: To Check LoginPage Title")
    @Step("validate LoginPage Title")
    @Test(priority = 1,description = "verifying login Page title test")
    public void validateloginpageTitle() {

        String title=loginpage.verifyLoginPageTitle();
        System.out.print(title);
        Assert.assertEquals(title,"Dejavoo System");

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validatedenovologo test on Login Page")
    @Story("story Name: To Check validatedenovologo")
    @Step("validate logo is displyed ")
    @Test(priority = 2,description = "verifying validatedenovolog test")
    public void validatedenovologo() {
        boolean flag = loginpage.verifyDenovoLogo();
        Assert.assertTrue(flag,"Dejavoo Logo Is not Display");
    }


    @Description("Test Case Description: validate RememberMe checkbox ")
    @Severity(SeverityLevel.NORMAL)
    @Story("story Name: To Check validateRememberme ")
    @Step("validate RememberMe CheckBox ")
    @Test(priority =3 ,description = "verifying validate RememberMe CheckBox")
    public void validateRememberme() {
        loginpage.verifyRemembercheckbox();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: validateForgotlink test on Login Page")
    @Story("story Name: To Check  forgotLink")
    @Step("validateForgotlink test on Login Page")
    @Test(priority = 4,description = "verifying validate Remember me test")
    public void validateForgotlink(){
        Assert.assertTrue(loginpage.verifyForgotlink(),"Forgot link is not displayed");
    }

    @Severity(SeverityLevel.BLOCKER)
    @Story("story Name: To Check LoginPage func")
    @Description("Test Description: Invalid Username and Password,Valid Username and Invalid Password")
    @Step("Login Step with username: {0}, password :{1}")
    @Test(priority = 5,dataProvider = "webLogin",dataProviderClass = DataProviderClass.class)
    public void validateloginTest(String username,String password) {
       try {
           loginpage.verifylogin(username, password);
           validateclickprofile();
           validatelogout();
       }catch (Exception e){

       }

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story Name: To check ClickProfile")
    @Description("Test Description :")
    public  void validateclickprofile(){
            loginpage.verifyclickprofile();
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("story Name: To Check LogoutFunc")
    public void validatelogout(){
        loginpage.verifylogout();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}