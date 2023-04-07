
package com.denovo.testscripts;

import com.denovo.Pages.LoginPage;
import com.denovo.Pages.TpnCreationPage;
import com.denovo.Util.DataProviderUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class TpnCreation_AgentLogin_AddonUser extends BaseTest {

    LoginPage loginPage = new LoginPage();
    TpnCreationPage tpnCreationPage=new TpnCreationPage();


    @Test(priority = 1,dataProvider = "getData")
    public void tpnCreation_AgentLogin_AddonUser(Map<String,String> data) throws InterruptedException {

        loginPage.verifyLoginWithCorrectCredentials(data.get("AgentAddonEmail"), data.get("AgentAddonPwd"));
        tpnCreationPage.verifyTpnCreationInfo(data);
    }

    @DataProvider
    public  Object[][] getData() throws IOException {
        Object[][] arrObject=null;
        arrObject= DataProviderUtil.getExcelData(System.getProperty("user.dir")+"/src/main/java/com/denovo/ExcelData/SE_DataSheet.xlsx",
                "AgentOffice(A)AddTpn");
        return arrObject;
    }

}
