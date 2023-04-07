/*
package com.denovo.testscripts;

import com.denovo.Pages.TpnCreationForm;
import com.denovo.Util.JavascriptExecutorUtil;
import com.denovo.Util.StringUtil;
import com.denovo.Util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.denovo.Base.TestBase.driver;

public class EditTpnPage {

    @FindBy(xpath = "//span[normalize-space()='Merchants']")
    WebElement clickMerchantLink;

    @FindBy(xpath = "//*[@class='col-8 px-0']/input")
    WebElement searchMerchant;

    @FindBy(xpath = "//div[@class='chat-body store-body ps ps--active-y']//u")
    List<WebElement> searchStore;

    @FindBy(xpath = "//input[@id='storeLbl']")
    WebElement selectStore;

    @FindBy(xpath = "//button[contains(text(),'Add Device')]")
    WebElement AddDevices;

    @FindBy(id = "manufacturerName")
    WebElement manufacturerNameField;

    @FindBy(xpath = "//ng-select[@formcontrolname='manufacturerId']//ng-dropdown-panel[@role='listbox']//span")
    List<WebElement> manufacturerDropDown;

    //(//*[@class='col-md-11 row pt-md-2'])[1]//u

    @FindBy(xpath = "//*[@formcontrolname='deviceModelId']")
    WebElement deviceModel;

    TpnCreationForm tpnCreationForm;


    public EditTpnPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyClickMerchantLink() {
        TestUtil.waitForElementToBeClickable(clickMerchantLink);
        clickMerchantLink.click();
    }

    public void verifySearchMerchant(TpnCreationForm tpnCreationForm) {
        TestUtil.waitForElementToBeClickable(searchMerchant);
        searchMerchant.sendKeys(tpnCreationForm.getMerchantName());
    }

    private String fillEditTpnInfo(String searchStoredba, String Merchantname) throws InterruptedException {
        verifyClickMerchantLink();
        verifySearchMerchant(Merchantname);
        verifySearchStore(searchStoredba);
        Thread.sleep(5000);
        return null;
    }

    public void verifySearchMerchant(String MerchantName){
        TestUtil.waitForElementToBeClickable(searchMerchant);
        searchMerchant.sendKeys(MerchantName);

    }

    public void verifySearchStore(String searchstoredba) throws InterruptedException {
        Thread.sleep(1000);
        StringUtil.ClickTextInListDropDown(searchstoredba,searchStore,driver);
    }

    void verifyChangeTpn(String Mname, String Sname,String manufacturer, String deviceModel,
                         String applicationSign, String routingType, String processor, String defaultLabel, String bin,
                         String selectProfile, String mid, String agent, String chain, String store,
                         String termNo, String termID) {

        tpnCreationForm = new TpnCreationForm(Mname, Sname, manufacturer, deviceModel, applicationSign, routingType,
                processor, defaultLabel, bin, selectProfile, mid, agent, chain, store,
                termNo, termID);

    }

       void changeTpn(String value){
            switch (value){
                case"P3":
                 //Xpath
                    //*[contains(text(),'Device Model')]//parent::dt//following-sibling::dd/p[normalize-space()='P3']
                 break;
                case"CloudPos":
                  //xpath
                  break;
                case"P5":
                    //xpath
                  break;

    }
    }
}*/
