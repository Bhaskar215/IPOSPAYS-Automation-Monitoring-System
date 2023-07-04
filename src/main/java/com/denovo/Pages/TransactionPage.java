package com.denovo.Pages;


import com.aventstack.extentreports.gherkin.model.ScenarioOutline;
import com.denovo.Reports.ExtentLogger;
import com.denovo.Util.ELKUtils;
import com.denovo.enums.WaitStrategy;
import com.denovo.factories.ExplicitWaitFactory;
import com.mysql.cj.util.TimeUtil;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class TransactionPage extends BasePage{

    private final By transactionIsLoaded = By.xpath("//*[@class='container merchant-list-view-design ng-star-inserted']");

    private final By clickTransactionPage = By.xpath("//*[text()='Transactions']");

    public void clickTransactionPage(){
        click(clickTransactionPage,WaitStrategy.CLICKABLE);
    }

    public String verifyIsTransactionLoaded() throws Exception {
        /*boolean flag=false;*/
        long TxpageLoadingTimeTaken;

        try{

            long startTime=System.nanoTime();

            ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE,transactionIsLoaded);
            /*flag=true;*/

            long endTime=System.nanoTime();
            long elapsedTime = endTime - startTime;

            //TimeUnit
             TxpageLoadingTimeTaken = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
              System.out.println("==================================");
              System.out.println(TxpageLoadingTimeTaken);
              System.out.println("==================================");

             ELKUtils.sendTxPageLodingTimeToELK(String.valueOf(TxpageLoadingTimeTaken));

             ExtentLogger.info("Transaction Page load taken time " + TxpageLoadingTimeTaken + " seconds ");

        }catch (Exception e){
            throw new Exception("Transaction Page Not Loaded");
        }
        return String.valueOf(TxpageLoadingTimeTaken);
    }
}