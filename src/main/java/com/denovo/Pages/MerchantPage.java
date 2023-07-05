package com.denovo.Pages;

import com.denovo.Reports.ExtentLogger;
import com.denovo.Util.ELKUtils;
import com.denovo.enums.WaitStrategy;
import com.denovo.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class MerchantPage extends BasePage {

    private final By merchantModuleIsLoaded = By.xpath("//*[@role='tabpanel']");

    private final By clickMerchantPage = By.xpath("//*[text()='Merchants']");

    public void clickMerchantPage(){
        click(clickMerchantPage, WaitStrategy.CLICKABLE);
    }

    public String verifyIsMerchantLoaded() throws Exception {
        /*boolean flag=false;*/
        long MerchantpageLoadingTimeTaken;

        try{

            long startTime=System.nanoTime();

            ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE,merchantModuleIsLoaded);
            /*flag=true;*/

            long endTime=System.nanoTime();
            long elapsedTime = endTime - startTime;


            //TimeUnit
            MerchantpageLoadingTimeTaken = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);

            //ELKUtils.sendMerchantPageLodingTimeToELK(String.valueOf(MerchantpageLoadingTimeTaken));

            ExtentLogger.info("Merchant Page load taken time: " + MerchantpageLoadingTimeTaken + " seconds ");

        }catch (Exception e){
            throw new Exception("Merchant Page Not Loaded");
        }
        return String.valueOf(MerchantpageLoadingTimeTaken);
    }

}
