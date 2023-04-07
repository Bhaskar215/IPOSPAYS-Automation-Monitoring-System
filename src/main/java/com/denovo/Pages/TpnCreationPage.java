
package com.denovo.Pages;


import com.denovo.Driver.DriverManager;
import com.denovo.Util.DynamicXpathUtils;
import com.denovo.Util.StringUtil;
import com.denovo.enums.WaitStrategy;
import com.denovo.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class TpnCreationPage extends BasePage{

    private final By clickMerchantLink =By.xpath("//*[text()='Merchants']/parent::a");

    private final By searchMerchant =By.xpath("//input[@placeholder='Search by dba/email/phone/state/city']");


    private final By searchStore =By.xpath("//input[@placeholder='Search by Store DBA']");

    private final By clickFilter =By.xpath("//*[@ngbpopover='Filter']");


    private final By AddDevices =By.xpath("//button[contains(text(),'Add Device')]");

    private final By clickStoreDropdown =By.xpath("(//*[contains(text(),'Select Store')]//parent::div)[1]");

    private final By selectStoreField =By.xpath("//*[@id='storeLbl']");


    private final By getListofstore =By.xpath("//ng-dropdown-panel[@role='listbox']//span");

    private final By list =By.xpath("//ng-select[@placeholder='Select Store']//span[@class='ng-value-label ng-star-inserted']");

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

    private final By clickSavebtn =By.xpath("//*[contains(text(),'Save')]");


    private String filltpninfo(Map<String,String> data) throws InterruptedException {

        verifyClickMerchantLink();
        Thread.sleep(2000);

        searchStore(data);

        verifySearchMerchant(data);

        Thread.sleep(2000);

        click(AddDevices,WaitStrategy.CLICKABLE);


        verifyIfStoreIsSelected(data);
        //verifySelectStore(tpnCreationForm);

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

        click(clickSavebtn,WaitStrategy.CLICKABLE);

        return null;
    }


    public String verifyTpnCreationInfo(Map<String,String>data) throws InterruptedException {
        return filltpninfo(data);
    }

    public void verifySearchMerchant(Map<String,String>data){
        sendKeys(searchMerchant,data.get("Merchant Name"), WaitStrategy.VISIABLE);
    }


/*This Func check Single Store or Multi Store if its multi store Merchant Click
    Store dropdown if its single Store click*/


    public void verifyIfStoreIsSelected(Map<String,String>data) throws InterruptedException {
        try{
            //if this element present in dom, let assume its single store it select default.
            click(clickStoreDropdown,WaitStrategy.CLICKABLE);
            String isStoreSelectXpath=DynamicXpathUtils.getXpath(CustomXpath.isStoreSelected,data.get("Store Name"));
            ExplicitWaitFactory.performExplicityWait(WaitStrategy.PRESENCE,By.xpath(isStoreSelectXpath)).isDisplayed();
            System.out.println("Store Defaultly Selected");
        }catch (Exception e){
            //If element Not present, it goes Catch block and Select store in Dropdown
            System.out.println("Store Not Selected");
            verifySelectStore(data);
        }
    }


    public void searchStore(Map<String,String>data) throws InterruptedException {
        click(clickFilter,WaitStrategy.CLICKABLE);
        sendKeys(searchStore,data.get("Store Name"),WaitStrategy.VISIABLE);
    }

    public void verifySelectStore(Map<String,String>data) throws InterruptedException {
        /*click(clickStoreDropdown,WaitStrategy.CLICKABLE);*/
        sendKeys(selectStoreField,data.get("Store Name"),WaitStrategy.VISIABLE);
        Thread.sleep(1000);
        StringUtil.ClicklistofBtnByGetText(data.get("Store Name"), getListofstore,DriverManager.getDriver());
    }

    public void verifyClickMerchantLink(){
        click(clickMerchantLink,WaitStrategy.CLICKABLE);
    }
}