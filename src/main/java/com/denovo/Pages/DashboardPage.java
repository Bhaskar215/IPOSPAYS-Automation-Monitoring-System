package com.denovo.Pages;

import com.denovo.Util.DynamicXpathUtils;
import com.denovo.Util.StringUtil;
import com.denovo.enums.WaitStrategy;
import com.denovo.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.ThreadLocalRandom;

public class DashboardPage extends BasePage{

    private final By clickDashboardCustomizeBtn =By.xpath("//button[@title='Customize']");

    private final By isTxVolumeBoardError =By.xpath("(//div[@class='ngx-background-spinner ngx-position-absolute center-center loading-background']/ancestor::div[@class='row ng-star-inserted'])[1]");

    private final By isTxCountBoardError=By.xpath("(//div[@class='ngx-background-spinner ngx-position-absolute center-center loading-background']/ancestor::div[@class='row ng-star-inserted'])[2]");

    private final By isMerchantBoardingError=By.xpath("(//div[@class='ngx-background-spinner ngx-position-absolute center-center loading-background']/ancestor::div[@class='row ng-star-inserted'])[3]");

    private final By isMerchantDeactivateError=By.xpath("(//div[@class='ngx-background-spinner ngx-position-absolute center-center loading-background']/ancestor::div[@class='row ng-star-inserted'])[4]");

    //isTransactedMerchantBoard == Mcc Chart + agingAnalysis + % of Transacted merchants
    private final By isTransactedMerchantBoard=By.xpath("(//div[@class='ngx-background-spinner ngx-position-absolute center-center loading-background']/ancestor::div[@class='row ng-star-inserted'])[5]");

    private final By isMerchantHaveNotTransactedBoard=By.xpath("(//div[@class='ngx-background-spinner ngx-position-absolute center-center loading-background']/ancestor::div[@class='row ng-star-inserted'])[6]");

    private final By isDashBoardTxtPresent =By.xpath("//*[contains(text(),'Transactions Volume')]");

    private final String clickCheckBox = "//*[text()='%s']";

    private final By clickTxCountCheckBox=By.xpath("//*[text()='Transactions Count']");

    private final By clickMerchantDeactive = By.xpath("//*[text()='Merchants Deactivation']");

    private final String isCheckboxEnable="//*[contains(text(),'%s')]/parent::div//input";

    private final By clickSaveAndCloseBtn=By.xpath("//*[contains(text(),'Save & Close')]");


    public String VerifyDashboardPageIsLoading(){
        ExplicitWaitFactory.waitForTextToBePresent(isDashBoardTxtPresent,"Transactions Volume");
        return getTexts(isDashBoardTxtPresent, WaitStrategy.PRESENCE);
    }


    public boolean verifyTransactionVolume() {
        boolean flag=true;
        WebElement TxBoardVolume;
        try {
            TxBoardVolume=ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE, isTxVolumeBoardError);
            TxBoardVolume.isDisplayed();
            flag=false;
        }catch (Exception e){
            System.out.println("Transaction Volume No Error or loaded Completely");
        }
        return flag;

    }

    public boolean verifyTransactionCount() {
        boolean flag=true;
        WebElement TxBoardCount;
        try {
            TxBoardCount = ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE, isTxCountBoardError);
            TxBoardCount.isDisplayed();
            flag=false;
        }catch (Exception e){
            System.out.println("Transaction count No Error or loaded Completely");
        }
        return flag;
    }

    public boolean verifyMerchantBoarding() {
        boolean flag=true;
        WebElement MerchantBoarding;
        try {
             MerchantBoarding = ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE, isMerchantBoardingError);
            MerchantBoarding.isDisplayed();
            flag=false;
        }catch (Exception e){
            System.out.println("MerchantBoarding No Error or loaded Completely");
        }
        return flag;
    }

    public boolean verifyMerchantDeactivateBoard() {
        boolean flag=true;
        WebElement MerchantDeactivate;
        try {
            MerchantDeactivate = ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE, isMerchantDeactivateError);
            MerchantDeactivate.isDisplayed();
            flag=false;
        }catch (Exception e){
            System.out.println("MerchantDeactivate Board No Error Found and loaded Completely");
        }
        return flag;
    }


    public boolean verifyTransactedMerchantBoard() {
        boolean flag=true;
        WebElement TransactedMerchantBoard;
        try {
            TransactedMerchantBoard = ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE, isTransactedMerchantBoard);
            TransactedMerchantBoard.isDisplayed();
            flag=false;
        }catch (Exception e){
            System.out.println("TransactedMerchantBoard No Error Found and loaded Completely");
        }
        return flag;
    }

    public boolean verifyMerchantHaveNotTransactedBoard() {
        boolean flag=true;
        WebElement MerchantHaveNotTransacted;
        try {
            MerchantHaveNotTransacted = ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE, isMerchantHaveNotTransactedBoard);
            MerchantHaveNotTransacted.isDisplayed();
            flag=false;
        }catch (Exception e){
            System.out.println("MerchantHaveNotTransacted Board No Error Found and loaded Completely");
        }
        return flag;
    }

    public void setClickDashboardCustomizeBtn() throws InterruptedException {
        click(clickDashboardCustomizeBtn,WaitStrategy.CLICKABLE);
        clickTransactionCountCheckBox();
        clickMerchantsDeactivationCheckBox();
    }

    public void clickTransactionCountCheckBox() throws InterruptedException {
        click(clickTxCountCheckBox,WaitStrategy.CLICKABLE);
        Thread.sleep(2000);
    }

    public void clickMerchantsDeactivationCheckBox() throws InterruptedException {

        click(clickMerchantDeactive,WaitStrategy.CLICKABLE);
    }

    public void clickSaveAndCloseBtn() throws InterruptedException {
        Thread.sleep(2000);
        click(clickSaveAndCloseBtn,WaitStrategy.CLICKABLE);
    }

}
