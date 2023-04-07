package com.denovo.Util;

import com.denovo.Driver.DriverManager;
import com.denovo.enums.WaitStrategy;
import com.denovo.factories.ExplicitWaitFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class StringUtil {


    public static void ClickRadioBtnByValue(String value, List<WebElement> element, WebDriver driver) {
        boolean flag = false;
        for (WebElement ele : element) {
            if (ele.getAttribute("value").equalsIgnoreCase(value)) {
                flag = true;
                JavascriptExecutorUtil.clickElementByJs(driver, ele);
                break;
            }
        }
        if (!flag){
            System.out.println("element not found");
        }
    }


    public static void ClickRadioBtnByValue(String value, WebElement element, WebDriver driver) {

        boolean flag = false;
        if (element.getAttribute("value").equalsIgnoreCase(value)) {
            flag = true;
            JavascriptExecutorUtil.clickElementByJs(driver, element);
        }
        if (!flag) {
            System.out.println("element not found Dti");
        }
    }

    public static void ClicklistofBtnByValue(String value, List<WebElement> element, WebDriver driver) {
        boolean flag = false;
        for (WebElement ele : element) {
            if (ele.getAttribute("value").equalsIgnoreCase(value)) {
                flag = true;
                JavascriptExecutorUtil.clickElementByJs(driver, ele);
                break;
            }
        }
        if (flag == false) {
            System.out.println(" element not found ");
        }
    }

   /* public static void ClicklistofBtnByGetText(String value, List<WebElement> element, WebDriver driver) throws InterruptedException {

        boolean flag = false;
        for (WebElement ele : element) {
            if (ele.getText().equalsIgnoreCase(value)) {
                flag = true;
                JavascriptExecutorUtil.clickElementByJs(driver, ele);
                //ele.click();
                break;
            }
        }
        if (!flag) {
            System.out.println("Element not found ClickListOfBtnByGetText in this Method");
        }
    }*/

    public static void  ClicklistofBtnByGetText(String value, By locator,WebDriver driver) throws InterruptedException {

        boolean flag = false;
        ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE,locator);
        for (WebElement ele : DriverManager.getDriver().findElements(locator)){
            try {
                if (ele.getText().equalsIgnoreCase(value)) {
                    flag = true;
                    JavascriptExecutorUtil.clickElementByJs(driver, ele);
                    //ele.click();
                    break;
                }
            }catch (StaleElementReferenceException e){
                System.out.println(locator.toString()+ "this locator give stale element exception");
                e.printStackTrace();
            }
        }
        if (!flag) {
            System.out.println("Element not found ClickListOfBtnByGetText in this Method");
        }
    }


    public static void ClickMultiSelectCheckBox(String value, List<WebElement> elements) {

        String[] arr = value.split(",");
        for (String s : arr) {
            for (WebElement ele : elements) {
                if (ele.getText().equalsIgnoreCase(s)) {
                    //multiselect
                    ele.click();
                    break;
                }
            }
        }

    }

    /*
    * Get Build No , and Add +1
    *
    *
    * */

    public static int getBuildNo(WebElement element) {

        String str=element.getText();
        System.out.println(str);
        if(str.equals("No Latest builds")) {
            return 1;
        }
        else {
            String[] build =str.split(" ");

            for(int i=0;i<build.length;i++){
                System.out.println(build[i]);
            }

            String actualbuildno = build[3].trim();

            //convert String value to Integervalue
            int buildnum=Integer.parseInt(actualbuildno);

            return buildnum + 1;
        }
    }



    public static void ClickTextInListDropDownBySplit(String value, List<WebElement> element, WebDriver driver) throws InterruptedException {

        boolean flag = false;
        for (WebElement ele : element) {
            String[]getstr= ele.getText().split("-");
            String str=getstr[0].trim();
            if (str.equalsIgnoreCase(value)) {
                Thread.sleep(2000);
                flag = true;
                JavascriptExecutorUtil.clickElementByJs(driver, ele);
                //ele.click();
                break;
            }
        }
        if (flag == false) {
            System.out.println("element not found");
        }
    }


    public static void ClickTextInDropDown(String value, WebElement element, WebDriver driver) throws InterruptedException {
        boolean flag = false;
            if (element.getText().equalsIgnoreCase(value)) {
                flag = true;
                JavascriptExecutorUtil.clickElementByJs(driver, element);
            }
        if (flag == false) {
            System.out.println("element not found");
        }
    }

    //use this randomEmail also
    protected static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
        // Call it as getSaltString()+"@gmail.com" in you code
    }

    public static String getRandomNumber() {
        String SALTCHARS = "1234";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() <= 4) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
        // Call it as getSaltString()+"@gmail.com" in you code
    }


    public static String getRandomAlphaNumericStringMinOrMax(){
        return RandomStringUtils.randomAlphanumeric(5,9);
    }


    public static String getRandomAlphaNumericForEmail(){
        String generatedstring=RandomStringUtils.randomAlphabetic(8);
        return (generatedstring);
    }


    public static String replaceDollar(String replaceThis ,WebElement element){
        String replacedValue="";
        return replacedValue=element.getText().replace(replaceThis,"");
    }

    public static String ExtractOnlyNumbers(String value){
        //This method replace all String before eg. Process : 1.09
        //After 1.09
            return value.replaceAll("[^0-9.]","");
    }

    public static Boolean isBtnDisable(By locator){
        boolean flag=false;
        WebElement btnElement=ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE,locator);

        if(btnElement.getAttribute("aria-pressed").equalsIgnoreCase("true")){
            flag=true;
        }
        else{
            System.out.println("already disabled");
        }
        return flag;
    }

    public static Boolean isRadioBtnDisable(By locator){
        boolean flag=false;
        WebElement radioBtnElement=ExplicitWaitFactory.performExplicityWait(WaitStrategy.VISIABLE,locator);
        if(radioBtnElement.getAttribute("aria-checked").equalsIgnoreCase("true")){
            flag=true;
        }
        return flag;
    }

}