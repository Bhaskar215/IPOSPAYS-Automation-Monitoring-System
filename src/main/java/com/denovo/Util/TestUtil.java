package com.denovo.Util;


import com.denovo.Driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestUtil   {

    public static void maximize() {
       DriverManager.getDriver().manage().window().maximize();
    }

    public static void implicitWait() {
     // driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    }

    public static void waitForPageElementPresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait( DriverManager.getDriver(),10);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Some error Occurred while waiting for the Element" + locator.toString());
        }
    }

    public static void waitForTextToBePresent(WebElement element,String str) {
        try {
            WebDriverWait wait = new WebDriverWait( DriverManager.getDriver(),10);
            wait.until(ExpectedConditions.textToBePresentInElement(element,str));
        } catch (Exception e) {
            System.out.println("Some error Occurred while waiting for the Element" + element.toString());
        }
    }

    public static void waitForElementToBeClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait( DriverManager.getDriver(),10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (StaleElementReferenceException e){
            element.click();
        }
        catch (Exception e) {
            System.out.println("Some error Occurred while waiting for the Element654" + element.toString());
        }
    }

    public static void waitForListOfElementToBevisible(List<WebElement> element ) {
        try {
            WebDriverWait wait = new WebDriverWait( DriverManager.getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOfAllElements(element));

        }catch(Exception e) {

            System.out.println("Some error Occurred while waiting for the Element" + element.toString());
        }
    }


    public static void waitForElementToBeVisible(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait( DriverManager.getDriver(),11);
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception e) {
            System.out.println("Some error Occurred while waiting for the Element" + element.toString());
        }
    }

    public static void uploadfile(WebElement element,int value,String path) throws AWTException {

        int n=value;

        while (n!=0){
            element.click();
            Robot rb = new Robot();
            rb.delay(2000);

            StringSelection ss = new StringSelection(path);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.delay(3000);

            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);
            rb.delay(3000);


            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            rb.delay(3000);
            n--;
        }
    }


    public static void Selectcountrydropdown(String countryname,WebDriver driver) {
        List<WebElement> listofcountry = null;
        try {
           // TestUtil.waitForListOfElementToBevisible(listofcountry);
            listofcountry = driver.findElements(By.xpath("//ul[@class='iti__country-list']/li"));
            for (int i = 0; i < listofcountry.size(); i++) {
                //System.out.println(listofcountry.get(i).getText());
                  listofcountry = driver.findElements(By.xpath("//ul[@class='iti__country-list']/li"));
                if (listofcountry.get(i).getText().contains(countryname)) {
                    listofcountry.get(i).click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void SelectRoleDropdown(WebElement element, String Role) {
        Select select = new Select(element);
        List<WebElement> listofOption = select.getOptions();
        boolean flag = false;
        for (WebElement option : listofOption) {
            String list = option.getText().trim();
            if (list.equalsIgnoreCase(Role.trim())) {
                flag = true;
                select.selectByVisibleText(list);
            }
        }
        if (flag == false) {
            System.out.println("element not found");
        }
    }

    public static String getFontcolor(WebElement element, String value) {
        String color = element.getCssValue(value).trim();
        String color_hex[];
        color_hex = color.replace("rgba(", "").split(",");
        String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()),
                Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));

        return actual_hex;
    }

    public static String getColor(WebElement element, String value) {
        String color = element.getCssValue(value).trim();
        String color_hex[];
        color_hex = color.replace("rgba(", "").split(",");
        String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()),
                Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));

        return actual_hex;
    }


    public static boolean isImagePresent(WebElement element, WebDriver driver){
       WebDriverWait wait = new WebDriverWait(driver,20);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && "
                    + "typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
            return ImagePresent;
        }catch (StaleElementReferenceException e){
            wait.until(ExpectedConditions.visibilityOf(element));
            Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && "
                    + "typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
            return ImagePresent;
        }
    }


    public static boolean handlingStaleException(WebElement element) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 2) {
            try {
                element.click();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return false;
    }

    public static boolean handlingStaleExceptionForLogo(WebElement element) {
        boolean result = false;
        int attempts = 0;

        while (attempts < 2) {
            try {
                element.click();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return false;
    }


    public static String handlingStaleExceptionForText(WebElement element) {
        boolean result = false;
        int attempts = 0;
        String header = "";
        while (attempts < 2) {
            try {
                TestUtil.waitForElementToBeVisible(element);
               // header=element.getText().trim();
                element.click();
                result = true;
                break;
            } catch (StaleElementReferenceException  e) {
            }
            attempts++;
        }
        return header;
    }


    public static void moveToElement(WebElement element){
        Actions actions = new Actions( DriverManager.getDriver());
        actions.moveToElement(element).click();
    }

}