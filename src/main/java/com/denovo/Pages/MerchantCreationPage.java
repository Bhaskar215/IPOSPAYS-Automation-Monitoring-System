
package com.denovo.Pages;

import com.denovo.Driver.DriverManager;
import com.denovo.Util.StringUtil;
import com.denovo.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Map;


public class MerchantCreationPage extends BasePage{


    private final By clickMerchantLink =By.xpath("//*[text()='Merchants']/parent::a");


    private final By clickAddMerchantBtn =By.xpath("//span[contains(text(),'Add Merchant')]");

    private final By clickDropdownBtn =By.xpath("//button[@id='dropdownBasic1']");

    private final By dbaField =By.xpath("//input[@formcontrolname='dba']");

    private final By firstName =By.xpath("//input[@formcontrolname='firstName']");

    private final By lastName =By.xpath("//input[@formcontrolname='lastName']");

    private final By email =By.xpath("//input[@formcontrolname='email']");


    private final By address1 =By.xpath("//input[@formcontrolname='address1']");


    private final By address2 =By.xpath("//*[@formcontrolname='address2']");


    private final By zipcode =By.xpath("//*[@formcontrolname='zip_code_merchant']");

    private final By Searchbox =By.xpath("//app-search-box-filter[@placeholder='Search by dba/email/phone/state/city']//input");

    private final By city =By.xpath("//*[@formcontrolname='city']");


    private final By state =By.xpath("//*[@formcontrolname='state']");

    private final By phonefield =By.xpath("(//input[@id='phone'])[1]");

    private final By EbtField =By.xpath("//*[@formcontrolname='ebt']");

    private final By clickNextStore =By.xpath("//button[contains(text(),'Add Store')]");


    private final By clickCheckBoxSAMA =By.xpath("//*[@class='form-check mb-5']//input");


    private final By Snamefield =By.xpath("//*[@formcontrolname='dba_store']");


    private final By clickMccField =By.xpath("//*[@formcontrolname='merchantCategoryCode']");


    private final By MccDropdown =By.xpath("//div[@class='ng-option ng-star-inserted']/small");


    private final By clickNextDevice =By.xpath("//button[contains(text(),'Add Device')]");


    private final By manufacturerNameField =By.xpath("//*[@id='manufacturerName']");

    private final By manufacturerDropDown =By.xpath("//ng-select[@formcontrolname='manufacturerId']//ng-dropdown-panel[@role='listbox']//span");

    private final By deviceModel =By.xpath("//*[@formcontrolname='deviceModelId']");

    private final By applicationSign =By.xpath("//*[@formcontrolname='applicationSign']");


    private final By routingType =By.xpath("//*[@formcontrolname='routingType']");

    private final By processor =By.xpath("//*[@formcontrolname='processorId']");

    private final By profileIdDropDown =By.xpath("//ng-select[@formcontrolname='profileId']//ng-dropdown-panel[@role='listbox']//span");


    private final By processorIdDropDown =By.xpath("//ng-select[@formcontrolname='processorId']//ng-dropdown-panel[@role='listbox']//span");


    private final By deviceDropdown =By.xpath("//ng-select[@formcontrolname='deviceModelId']//ng-dropdown-panel[@role='listbox']//span");

    private final By applicationSignDropDown =By.xpath("//ng-select[@formcontrolname='applicationSign']//ng-dropdown-panel[@role='listbox']//span");

    private final By routingDropDown =By.xpath("//ng-select[@formcontrolname='routingType']//ng-dropdown-panel[@role='listbox']//span");


    private final By defaultLabel =By.xpath("//*[@formcontrolname='defaultLabel']");

    private final By binField =By.xpath("//*[@formcontrolname='bin']");


    private final By profileIdField =By.xpath("//*[@formcontrolname='profileId']");

    private final By midField =By.xpath("//*[@formcontrolname='Mid']");


    private final By agentField =By.xpath("//*[@formcontrolname='Agent']");


    private final By chainField =By.xpath("//*[@formcontrolname='Chain']");



    private final By storeField =By.xpath("//*[@formcontrolname='dba_store']");


    private final By store =By.xpath("//*[@formcontrolname='Store']");


    private final By termNoField =By.xpath("//*[@formcontrolname='TermNo']");

    private final By termIdField =By.xpath("//*[@formcontrolname='TermId']");


    private final By addProfile =By.xpath("//*[@ngbpopover='Add Profile']");

    private final By clickFinish =By.xpath("//*[@type='submit']");






    public void verifyClickMerchantLink(){
        click(clickMerchantLink, WaitStrategy.CLICKABLE);
    }


    public void verifyClickAddMerchantBtn() {
        click(clickDropdownBtn, WaitStrategy.CLICKABLE);
        click(clickAddMerchantBtn, WaitStrategy.CLICKABLE);
    }

/*this Func used for Both Merchant creation
    with withFee and WithoutFee
    */

    private String  fillMerchantInfo(Map<String,String>data) throws InterruptedException {

        //Merchant Info
        sendKeys(dbaField,data.get("DBA"),WaitStrategy.VISIABLE);
        sendKeys(firstName,data.get("FirstName"),WaitStrategy.VISIABLE);
        sendKeys(lastName,data.get("LastName"),WaitStrategy.VISIABLE);

        String randemail = StringUtil.getRandomAlphaNumericStringMinOrMax();
        sendKeys(email,randemail+data.get("Email"),WaitStrategy.VISIABLE);

        sendKeys(address1,data.get("Address1"),WaitStrategy.VISIABLE);
        sendKeys(address2,data.get("Address2"),WaitStrategy.VISIABLE);


        sendKeys(zipcode,data.get("ZipCode"),WaitStrategy.VISIABLE);


    /*    TestUtil.waitForElementToBeClickable(zipcodeDropdownText);
        zipcode.sendKeys(Keys.ENTER);*/

        Thread.sleep(2000);

        DriverManager.getDriver().findElement(zipcode).sendKeys(Keys.ENTER);

        sendKeys(phonefield,data.get("Phone"),WaitStrategy.VISIABLE);

        sendKeys(EbtField,data.get("Ebt"),WaitStrategy.VISIABLE);


        //Next Store Button


        click(clickNextStore,WaitStrategy.CLICKABLE);

        //Same As Merchant Address

/*
        if(!ExplicitWaitFactory.performExplicityWait(By.xpath(clickCheckBoxSAMA).isSelected()){
           clickCheckBoxSAMA.click();
        }
*/


        click(clickMccField,WaitStrategy.CLICKABLE);

        StringUtil.ClicklistofBtnByGetText(data.get("Mcc"),MccDropdown,DriverManager.getDriver());
        Thread.sleep(3000);

        String randStore = StringUtil.getRandomAlphaNumericStringMinOrMax();

        sendKeys(storeField,randStore+data.get("StoreName"),WaitStrategy.VISIABLE);


        //NextDevice

        click(clickNextDevice,WaitStrategy.CLICKABLE);

        Thread.sleep(3000);

        //Store Info

       /* StringUtil.ClickTextInListDropDown(mCreationForm.getManufacture(),manufacturerDropDown,driver);*/

        click(manufacturerNameField,WaitStrategy.CLICKABLE);

        StringUtil.ClicklistofBtnByGetText(data.get("Manufacturer"),manufacturerDropDown,DriverManager.getDriver());


        //Select DeviceModel
        Thread.sleep(3000);
        click(deviceModel,WaitStrategy.CLICKABLE);

        StringUtil.ClicklistofBtnByGetText(data.get("Device Model"),deviceDropdown,DriverManager.getDriver());

        //Select ApplicationSign
        Thread.sleep(3000);

        click(applicationSign,WaitStrategy.CLICKABLE);

        StringUtil.ClicklistofBtnByGetText(data.get("Application Sign"),applicationSignDropDown,DriverManager.getDriver());

        //Select RoutingType

        Thread.sleep(2000);

        click(routingType,WaitStrategy.CLICKABLE);

        StringUtil.ClicklistofBtnByGetText(data.get("Routing Type"),routingDropDown,DriverManager.getDriver());

        //Select Processor
        Thread.sleep(2000);

        click(processor,WaitStrategy.CLICKABLE);
        StringUtil.ClicklistofBtnByGetText(data.get("Processor"),processorIdDropDown,DriverManager.getDriver());


        sendKeys(defaultLabel,data.get("Default Label"),WaitStrategy.VISIABLE);


        sendKeys(binField,data.get("Bin"),WaitStrategy.VISIABLE);

        //Profile Info
        click(profileIdField,WaitStrategy.CLICKABLE);


        StringUtil.ClicklistofBtnByGetText(data.get("Select Profile"),profileIdDropDown,DriverManager.getDriver());


        sendKeys(midField,data.get("MID"),WaitStrategy.VISIABLE);

        //
        sendKeys(agentField,data.get("Agent"),WaitStrategy.VISIABLE);


        sendKeys(chainField,data.get("Chain"),WaitStrategy.VISIABLE);


        sendKeys(store,data.get("Store"),WaitStrategy.VISIABLE);

        sendKeys(termNoField,data.get("TermNo"),WaitStrategy.VISIABLE);


        sendKeys(termIdField,data.get("TermID"),WaitStrategy.VISIABLE);

        //Finish Button

        click(clickFinish,WaitStrategy.CLICKABLE);

        Thread.sleep(5000);
        // Wait 4 sec page will routing to Merchant listing. Reason if Merchant created page will Routed automatically.
        return DriverManager.getDriver().getCurrentUrl();
    }

    public String verifyMerchantCreationInfo(Map<String,String>data) throws InterruptedException {
       return fillMerchantInfo(data);
    }

}
