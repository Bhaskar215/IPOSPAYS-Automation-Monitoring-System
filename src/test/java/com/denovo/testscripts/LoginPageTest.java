package com.denovo.testscripts;

import com.denovo.Config.ReadPropertyFile;
import com.denovo.Pages.LoginPage;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {
    LoginPage loginpage = new LoginPage();

    @Test(priority = 1)
    public void loginTestWithCorrectCredentials() {
        loginpage.verifyLoginWithCorrectCredentials(ReadPropertyFile.pro.getProperty("system_Dev_un"),ReadPropertyFile.pro.getProperty("system_Dev_pwd"));
        loginpage.clickLoginbtn();
    }
}