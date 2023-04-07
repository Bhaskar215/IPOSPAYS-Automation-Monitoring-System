
package com.denovo.testscripts;

import com.denovo.Pages.LoginPage;
import com.denovo.Pages.StoreTpnCreationPage;
import com.denovo.Util.DataProviderUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class StoreTpnCreation_IsoLogin_PrimaryUser extends BaseTest {

    LoginPage loginPage= new LoginPage();
    StoreTpnCreationPage storeTpnCreationPage =new StoreTpnCreationPage();


    @Test(priority = 1,dataProvider = "getData")
    public void storeTpnCreation_IsoLogin_PrimaryUser(Map<String,String>data) throws InterruptedException {

        loginPage.verifyLoginWithCorrectCredentials(data.get("ISOPrimaryEmail"), data.get("ISOPrimaryPwd"));
        storeTpnCreationPage.verifyStoreCreationInfo(data);

    }

    @DataProvider
    public  Object[][] getData() throws IOException {
        Object[][] arrObject=null;
        arrObject= DataProviderUtil.getExcelData(System.getProperty("user.dir")+"/src/main/java/com/denovo/ExcelData/SE_DataSheet.xlsx",
                "ISO(P)AddStoreWithTpn");
        return arrObject;
    }

}