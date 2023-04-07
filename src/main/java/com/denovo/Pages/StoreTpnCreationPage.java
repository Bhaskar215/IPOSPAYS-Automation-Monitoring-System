
package com.denovo.Pages;

import com.denovo.Driver.DriverManager;
import com.denovo.Util.StringUtil;
import com.denovo.Util.TestUtil;
import com.denovo.enums.WaitStrategy;
import com.denovo.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;


public class StoreTpnCreationPage extends BasePage{

    private final By clickMerchantLink =By.xpath("//*[text()='Merchants']/parent::a");

    private final By clickAddstore =By.xpath("//*[contains(text(),'Add Store')]");


    private final By firstName =By.xpath("//input[@formcontrolname='firstName_store']");

    private final By lastName =By.xpath("//input[@formcontrolname='lastName_store']");

    private final By address2 =By.xpath("//*[@formcontrolname='address1_store']");


    private final By Store_email =By.xpath("//input[@formcontrolname='email_store']");


    private final By address1 =By.xpath("//input[@formcontrolname='address2_store']");

    private final By Dba =By.xpath("//*[@formcontrolname='dba_store']");

    private final By zipcode =By.xpath("//*[@formcontrolname='zipcode_store']");

    private final By phonefield =By.xpath("(//input[@id='phone'])[1]");

    private final By email_store =By.xpath("//*[@formcontrolname='email_store']");


    private final By clickMccField =By.xpath("//*[@formcontrolname='merchantCategoryCode']");

    private final By MccDropdown =By.xpath("//div[@class='ng-option ng-star-inserted']/small");

    private final By AddDevices =By.xpath("//button[contains(text(),'Add Device')]");

    private final By popUpScreen =By.xpath("//*[@class='swal2-popup swal2-modal swal2-show']");


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

    private final By clickAddStore =By.xpath("//*[contains(text(),'Add Store')]");

    private final By clickYesAddTpn =By.xpath("//*[contains(text(),'Yes')]");

    private final By searchMerchant =By.xpath("//input[@placeholder='Search by dba/email/phone/state/city']");


    private final By clickSavebtn =By.xpath("//*[contains(text(),'Save')]");



    private String fillStoreInfo(Map<String,String>data) throws InterruptedException {

        verifyClickMerchantLink();

        verifySearchMerchant(data);

        click(clickAddstore,WaitStrategy.CLICKABLE);

        click(clickMccField,WaitStrategy.CLICKABLE);

        StringUtil.ClicklistofBtnByGetText(data.get("Mcc"),MccDropdown, DriverManager.getDriver());
        Thread.sleep(3000);

        String randStore = StringUtil.getRandomAlphaNumericStringMinOrMax();

        sendKeys(firstName,data.get("FirstName"),WaitStrategy.CLICKABLE);

        sendKeys(lastName,data.get("LastName"),WaitStrategy.CLICKABLE);

        sendKeys(storeField,randStore+data.get("DBA"),WaitStrategy.VISIABLE);

        sendKeys(address1,data.get("Address1"),WaitStrategy.CLICKABLE);

        sendKeys(address2,data.get("Address2"),WaitStrategy.CLICKABLE);

        sendKeys(zipcode,data.get("ZipCode"),WaitStrategy.VISIABLE);

        Thread.sleep(2000);

        DriverManager.getDriver().findElement(zipcode).sendKeys(Keys.ENTER);

        sendKeys(phonefield,data.get("Phone"),WaitStrategy.VISIABLE);

        String randemail = StringUtil.getRandomAlphaNumericStringMinOrMax();
        sendKeys(email_store,randemail+data.get("Email"),WaitStrategy.VISIABLE);

        click(clickAddstore,WaitStrategy.CLICKABLE);
        ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE,popUpScreen);

        click(clickYesAddTpn,WaitStrategy.CLICKABLE);


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



       /* Thread.sleep(5000);
        verifySearchMerchant(data);
        TestUtil.waitForElementToBeClickable(clickAddstore);
        clickAddstore.click();

        TestUtil.waitForElementToBeVisible(clickMccField);
        clickMccField.click();
        Thread.sleep(3000);
        StringUtil.ClickTextInListDropDown(storeTpnCreationForm.getMcc(), MccDropdown, driver);

        fname.clear();
        fname.sendKeys(storeTpnCreationForm.getFirstname());
        Lname.clear();
        Lname.sendKeys(storeTpnCreationForm.getLastName());

        Dba.clear();
        String randDba = StringUtil.getRandomAlphaNumericStringMinOrMax();
        Dba.sendKeys(randDba+" "+storeTpnCreationForm.getStoredba());

        Address1.clear();
        Address1.sendKeys(storeTpnCreationForm.getAddress1());
        zipcode.clear();
        zipcode.sendKeys(storeTpnCreationForm.getZipCode());
        Thread.sleep(3000);

        TestUtil.waitForElementToBeClickable(zipcode);
        zipcode.sendKeys(Keys.ENTER);


        Store_email.clear();
        String randemail = StringUtil.getRandomAlphaNumericStringMinOrMax();
        Store_email.sendKeys(randemail+storeTpnCreationForm.getEmail());


        Store_phone.clear();
        Store_phone.sendKeys(storeTpnCreationForm.getPhone());

        clickAddstore.click();

        TestUtil.waitForElementToBeVisible(popUpScreen);

        TestUtil.waitForElementToBeVisible(clickYesAddTpn);
        clickYesAddTpn.click();

        Thread.sleep(3000);

        TestUtil.waitForElementToBeClickable(manufacturerNameField);
        manufacturerNameField.click();
        StringUtil.ClickTextInListDropDown(storeTpnCreationForm.getManufacture(), manufacturerDropDown, driver);

        //Select DeviceModel
        Thread.sleep(2000);
        TestUtil.waitForElementToBeClickable(deviceModel);
        deviceModel.click();
        StringUtil.ClickTextInListDropDown(storeTpnCreationForm.getDeviceModel(), deviceDropdown, driver);

        //Select Processor
        Thread.sleep(2000);
        TestUtil.waitForElementToBeClickable(processor);
        processor.click();
        Thread.sleep(3000);
        StringUtil.ClickTextInListDropDown(storeTpnCreationForm.getProcessor(), processorIdDropDown, driver);

        TestUtil.waitForElementToBeClickable(defaultLabel);
        defaultLabel.clear();
        defaultLabel.sendKeys(storeTpnCreationForm.getDefaultLabel());

        TestUtil.waitForElementToBeClickable(binField);
        binField.clear();
        binField.sendKeys(storeTpnCreationForm.getBin());

        //Profile Info
        TestUtil.waitForElementToBeClickable(profileIdField);
        profileIdField.click();
        StringUtil.ClickTextInListDropDown(storeTpnCreationForm.getProfileId(), profileIdDropDown, driver);

        TestUtil.waitForElementToBeClickable(midField);
        midField.clear();
        midField.sendKeys(storeTpnCreationForm.getMid());

        //
        TestUtil.waitForElementToBeClickable(agentField);
        agentField.clear();
        agentField.sendKeys(storeTpnCreationForm.getAgent());

        TestUtil.waitForElementToBeClickable(chainField);
        chainField.clear();
        chainField.sendKeys(storeTpnCreationForm.getChain());

        TestUtil.waitForElementToBeClickable(store);
        store.clear();
        store.sendKeys(storeTpnCreationForm.getStore());

        TestUtil.waitForElementToBeClickable(termNoField);
        termNoField.clear();
        termNoField.sendKeys(storeTpnCreationForm.getTermNo());

        TestUtil.waitForElementToBeClickable(termIdField);
        termIdField.clear();
        termIdField.sendKeys(storeTpnCreationForm.getTermId());*/



        click(clickSavebtn,WaitStrategy.CLICKABLE);
        Thread.sleep(2000);
        return null;
    }

  public String verifyStoreCreationInfo(Map<String,String>data) throws InterruptedException {
        return fillStoreInfo(data);
  }


    public void verifySearchMerchant(Map<String,String>data){
        sendKeys(searchMerchant,data.get("Merchant Name"), WaitStrategy.VISIABLE);
    }


    public void verifyClickMerchantLink(){
        click(clickMerchantLink,WaitStrategy.CLICKABLE);

  }
}
