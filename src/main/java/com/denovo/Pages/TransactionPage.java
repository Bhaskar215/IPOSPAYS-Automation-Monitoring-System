package com.denovo.Pages;

import com.denovo.Reports.ExtentLogger;
import com.denovo.enums.WaitStrategy;
import com.denovo.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class TransactionPage extends BasePage{

    private final By transactionIsLoaded = By.xpath("//*[@class='container merchant-list-view-design ng-star-inserted']");

    private final By clickTransactionPage = By.xpath("//*[text()='Transactions']");

    public void clickTransactionPage(){
        click(clickTransactionPage,WaitStrategy.CLICKABLE);
    }

    public void verifyIsTransactionLoaded() throws Exception {
        boolean flag=false;
        try{
            long startTime=System.nanoTime();
            ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE,transactionIsLoaded);
            flag=true;
            long elapsedTime=System.nanoTime() - startTime;
            ExtentLogger.info("Transaction Page load taken time " +elapsedTime/1000000 + " sec ");
        }catch (Exception e){
            throw new Exception("Transaction Page Not Loaded");
        }
    }
}
