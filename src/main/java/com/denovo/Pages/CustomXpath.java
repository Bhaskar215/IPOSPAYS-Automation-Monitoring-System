package com.denovo.Pages;

import org.openqa.selenium.By;

public final class CustomXpath {

    private CustomXpath(){

    }

    //CUSTOM XPATH FOR ALL PAGES

                                                              //label[text()='Tag and Tx']//following::p-selectbutton[1]//span
    protected final static String listOfParamSwitchBtnXpath = "//label[text()='%s']//following::p-selectbutton[1]//span";

    protected final static String ParamSection ="//a[contains(text(),'%s')]";

    protected final static String menuLinkTxt ="//*[text()='%s']/parent::a";

    protected final static String isStoreSelected ="(//*[@class='ng-value ng-star-inserted'])[1]/span[normalize-space() ='%s']";

    protected final static String subMenuLinkTxt="//*[text()='%s']";

    protected final static String buttonXpath ="//button[text()=' %s ']";
                                                //label[text()='Tip']//following::p-selectbutton[1]//span[text()='No']//parent::div
    protected final static String isBtnDisable="//label[text()='%s']//following::p-selectbutton[1]//span[text()='%s']//parent::div";

    protected final static  String isBtnSetTONo="//label[text()='%s']//following::p-selectbutton[1]//span[text()='No']//parent::div";

    protected final static String FeeTypeSymbol = "(//*[@class='ng-arrow-wrapper'])[2]";

    protected final static String ParamRadioBtn
            ="//*[text()=' %s']//parent::div//child::p-radiobutton";
    //*[text()=' Custom Fee']//parent::div//child::p-radiobutton//input
               //space need before FeeTXt








}
