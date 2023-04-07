package com.denovo.Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class JavascriptExecutorUtil  {

    public static void scrollPageUp(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }

    public static void scrollPageUpforReceipt(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-50)");
    }
    public static void scrollPageUpforLogDropdown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-65)");
    }

    public static void scrollDown(WebDriver driver) {
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

       /* JavascriptExecutor js = (JavascriptExecutor) driver;
                System.out.println(js.executeScript("document.getElementById('emailInput').value;",emailFormField));*/

    public static void  scrollToCertainPoint(WebDriver driver) {
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,300)");

    }

    //Copied url form clipboard and Pasted From New window.
    public static void doCopyPasteUrlOnNewWindow(WebDriver driver) throws IOException, UnsupportedFlavorException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Object copiedUrl = clipboard.getData(DataFlavor.stringFlavor);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.open(\""+copiedUrl+"\")");
    }


    public static void drawBorder(WebElement element,WebDriver driver)
    {
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='3px solid red'",element);
    }

    public static void selectDataByJs(WebDriver driver,String dateVal,WebElement ele) {
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','"+dateVal+"')",ele);
    }

    public static void getElementId(WebDriver driver,String script,WebElement ele) {
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript(script);
    }

    //document.getElementById('emailInput').value

}