package com.denovo.Util;

import com.denovo.Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptExecutorUtil extends TestBase {

    public static void scrollPageUp(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
    }

    public static void scrollDownUp(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)");
    }

    public static void clickPrintChoices(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void clickElementByJs(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }
    public static void ScrollByVisibleElement(WebDriver driver,WebElement element) {
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",element );

    }

    public static void drawBorder(WebElement element,WebDriver driver)
    {
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='3px solid red'",element);
    }

}