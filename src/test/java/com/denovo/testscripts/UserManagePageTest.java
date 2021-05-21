
package com.denovo.testscripts;

import com.denovo.Base.TestBase;
import com.denovo.Pages.HomePage;
import com.denovo.Pages.LoginPage;
import com.denovo.Pages.UserManagePage;
import com.denovo.Util.DataProviderClass;
import com.denovo.Util.TestUtil;
import io.qameta.allure.*;
import org.testng.Assert;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;

public class UserManagePageTest extends TestBase {

    LoginPage loginpage;
    HomePage homePage;
    UserManagePage userManagePage;
    TestUtil testUtil;


    public UserManagePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        testUtil = new TestUtil();
        loginpage = new LoginPage();
        userManagePage = new UserManagePage();
        homePage = loginpage.verifylogin(pro.getProperty("username"), pro.getProperty("password"));
        userManagePage.verifyClickUserManagementLink();
    }

    @Feature("validate UserManagePageTitle")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify UserManagement page title")
    @Story("story Name: To Check UserManagePage Title")
    @Step("validate LoginPage Title")
    @Test(priority = 1)
    public void validateusermanagepageTitle() {

        String title=userManagePage.verifyusermanagepageTitle();
        System.out.print(title);
        Assert.assertEquals(title,"Dejavoo System");

    }

    @Feature("validate UserManagePage Logo")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate logo test on UserManagePage")
    @Story("story Name: To Check validate logo")
    @Step("validate logo is displayed  ")

    @Test(priority = 2)
    public void validatelogo() {
        boolean flag = userManagePage.verifylogo();
        Assert.assertTrue(flag,"Dejavoo logo isn't Diplayed");
    }

    @Feature("validate Dashboard Link IsDisplayed ")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate logo test on UserManagePage")
    @Story("story Name: To Check validate logo")
    @Step("validate logo isDisplayed  ")

    @Test(priority = 3)
    public void validatedashboardlinkIsDisplayed() {
        boolean dashboard = userManagePage.verifydashboardlinkIsDisplayed();
        Assert.assertTrue(dashboard);
    }



    @Feature("validate Dashboard Link IsEnable ")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: validate Add User Button on UserManagePage")
    @Story("story Name: To Check validate logo")
    @Step("validate UserButton is enabled  ")
    @Test(priority = 4)
    public void validateuserbtnISEnable() {
        boolean addUserbtn = userManagePage.verifyuserbtnIsEnable();
        Assert.assertTrue(addUserbtn);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate userManagement IsSelected test on userManagePage")
    @Story("story Name: To Check userManagement link IsSelected")
    @Test(priority = 5)
    public void validateuserManagementlinkIsSelected() throws InterruptedException {
        String actualColor =userManagePage.verifyuserManagementlinkIsHighlighted();
        Assert.assertEquals(actualColor,"#e0f7fa","userManagement Link is not Highlighted on userManagement Page");

    }

    @Step("Dataprovider method help fetch data from excel")
    @DataProvider
    public Iterator<Object[]> getUserData() {
        ArrayList<Object[]> userdata = DataProviderClass.getdatafromexcel();
        return userdata.iterator();
    }

    @Feature("validate UserData")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: validate Adding UserData on UserManagePage")
    @Story("story Name: To Check validate Adding UserData")
    @Step("Fetching the data From Excel  ")

    @Test(priority = 6, dataProvider = "getUserData")
    public void validateUserData(String fname, String lname,
                                 String email, String phonenumber,String Role) {

        userManagePage.verifyclickUserBtn();
        userManagePage.verifyclickDropdown();
        testUtil.Selectcountrydropdown("India (भारत)");

        userManagePage.verifyuserData(fname, lname, email, phonenumber,Role);
        validateRoledropdown(Role);
        validatesubmitbtn();

    }

    @Feature("validate RoleDropDown")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: validateRole Dropdown  UserManagePage")
    @Story("story Name: To Check validateRole Dropdown")
    @Step("validateRole Dropdown")

    public void validateRoledropdown(String Role) {
        userManagePage.verifyRoleDropDown(Role);
    }

    @Feature("validate Submit Button")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: validate Submit Button on  UserManagePage")
    @Story("story Name: To Check validate Submit Button")
    @Step("validate Submit Button")

    public void validatesubmitbtn()  {
        userManagePage.verifySubmitBtn();
        userManagePage.verifydatacreated();

    }

        @AfterMethod
        public void teardown () {
          try {
              Thread.sleep(4000);
              driver.quit();
          }catch (InterruptedException e){
          }

    }
}