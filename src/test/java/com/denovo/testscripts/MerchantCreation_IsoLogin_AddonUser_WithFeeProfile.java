
package com.denovo.testscripts;

import com.denovo.Pages.LoginPage;
import com.denovo.Pages.MerchantCreationPage;
import com.denovo.Util.DataProviderUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class MerchantCreation_IsoLogin_AddonUser_WithFeeProfile extends BaseTest {
    LoginPage loginPage= new LoginPage();
    MerchantCreationPage merchantCreationPage= new MerchantCreationPage();


    @Test(priority = 1,dataProvider = "getData")
    public void merchantCreation_IsoLogin_AddonUser_WithFeeProfile(Map<String,String> data) throws InterruptedException {

        loginPage.verifyLoginWithCorrectCredentials(data.get("ISOPrimaryEmail"), data.get("ISOPrimaryPwd"));

        merchantCreationPage.verifyClickMerchantLink();
        merchantCreationPage.verifyClickAddMerchantBtn();

        String ActualUrl = merchantCreationPage.verifyMerchantCreationInfo(data);
        Assert.assertEquals(ActualUrl,"https://denovosystem.tech/merchant-management/list-merchant");
    }

    @DataProvider
    public  Object[][] getData() throws IOException {
        Object[][] arrObject=null;
        arrObject= DataProviderUtil.getExcelData(System.getProperty("user.dir")+"/src/main/java/com/denovo/ExcelData/SE_DataSheet.xlsx",
                "ISO(Addon)MerchantWithFee");
        return arrObject;
    }

}
