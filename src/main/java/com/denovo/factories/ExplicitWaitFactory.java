package com.denovo.factories;

import com.denovo.Driver.DriverManager;
import com.denovo.constants.FrameWorkConstants;
import com.denovo.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitFactory {

    public static WebElement performExplicityWait(WaitStrategy waitStrategy, By locator) {
        WebElement element = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.getExplicitWait())
                    .until(ExpectedConditions.elementToBeClickable(locator));

        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.getExplicitWait())
                    .until(ExpectedConditions.presenceOfElementLocated(locator));

        } else if (waitStrategy == WaitStrategy.VISIABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.getExplicitWait())
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));

        } else if (waitStrategy == WaitStrategy.NONE) {
            DriverManager.getDriver().findElement(locator);
        }
        return element;
    }

    public static Boolean waitForTextToBePresent(By locator, String str) {
        Boolean element = null;
        try {
            element = new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.getExplicitWait())
                    .until(ExpectedConditions.textToBePresentInElementLocated(locator, str));
        }catch (Exception e){
            System.out.println("Element Not Found "+ locator);
        }
        return element;
    }
}
