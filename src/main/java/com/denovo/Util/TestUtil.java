package com.denovo.Util;

import com.denovo.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestUtil extends TestBase {

    public static void maximize() {
        driver.manage().window().maximize();
    }

    public static void implicitWait() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    public static void waitForPageElementPresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Some error Occurred while waiting for the Element" + locator.toString());
        }
    }

    public static void waitForElementToBeClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
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


    public static void Selectcountrydropdown(String countryname) {
        try {
            List<WebElement> listofcountry = driver.findElements(By.xpath("//ul[@class='iti__country-list']/li"));
            for (int i = 0; i < listofcountry.size(); i++) {
                //System.out.println(listofcountry.get(i).getText());
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

    public static String getcolor(WebElement element, String value) {
        String color = element.getCssValue(value).trim();
        String color_hex[];
        color_hex = color.replace("rgba(", "").split(",");
        String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()),
                Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));

        return actual_hex;
    }

}