package com.denovo.Pages;

import com.denovo.enums.WaitStrategy;
import com.denovo.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class BasePage {


    public void click(By locator, WaitStrategy waitStrategy){
        WebElement ele=ExplicitWaitFactory.performExplicityWait(waitStrategy,locator);
        ele.click();
    }

    public void sendKeys(By locator,String sendValue,WaitStrategy waitStrategy){
        WebElement ele=ExplicitWaitFactory.performExplicityWait(waitStrategy,locator);
        if(Objects.nonNull(ele)){
            ele.clear();
            ele.sendKeys(sendValue.trim());
        }
        else {
            System.out.println("Element Not Found in the Dom" +locator.toString());
        }
    }

    public void sendKeys(By locator, String sendValue,WaitStrategy waitStrategy, Keys enter){
        WebElement ele=ExplicitWaitFactory.performExplicityWait(waitStrategy,locator);
        ele.clear();
        ele.sendKeys(sendValue,enter);
        //DriverManager.getDriver().findElement(locator).sendKeys(sendValue,enter);
    }

    public String getTexts(By locator, WaitStrategy waitStrategy){
        WebElement ele=ExplicitWaitFactory.performExplicityWait(waitStrategy,locator);
        if(Objects.isNull(ele)){
            try {
                throw new Exception("GetTexts Element of "+ locator +"Not Found in the Dom");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            return ele.getText();
    }

    public void searchCloudPosTpn(By isPrefilled, By sendCloudTpn, String value, WaitStrategy waitStrategy) throws InterruptedException {

        try {
            Thread.sleep(2000);
            ExplicitWaitFactory.performExplicityWait(waitStrategy,isPrefilled).isDisplayed();
        }catch (Exception e){
            sendKeys(sendCloudTpn,value,waitStrategy,Keys.ENTER);
        }
    }

    public void SwitchButtonIsDisable(){


    }
}